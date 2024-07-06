package com.xyoj.judge;

import cn.hutool.json.JSONUtil;
import com.xyoj.common.ErrorCode;
import com.xyoj.exception.BusinessException;
import com.xyoj.judge.codesandbox.CodeSandFactory;
import com.xyoj.judge.codesandbox.CodeSandbox;
import com.xyoj.judge.codesandbox.CodeSandboxProxy;
import com.xyoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xyoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.xyoj.judge.strategy.JudgeContext;
import com.xyoj.model.dto.question.JudgeCase;
import com.xyoj.judge.codesandbox.model.JudgeInfo;
import com.xyoj.model.entity.Question;
import com.xyoj.model.entity.QuestionSubmit;
import com.xyoj.model.enums.QuestionSubmitStatusEnum;
import com.xyoj.service.QuestionService;
import com.xyoj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JudgeServiceImpl implements JudgeService {
    @Resource
    private QuestionSubmitService questionSubmitService;
    @Resource
    private QuestionService questionService;
    @Value("${codesandbox.type:example}")
    private String type;
    @Resource
    private JudgeManager judgeManager;

    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {

        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目提交信息不存在");
        }
        Long questionId = questionSubmit.getQuestionId();
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目信息不存在");
        }
        // 实现题目判断逻辑
        // 题目不是等待中 不需要判题，并抛出异常
        Integer status = questionSubmit.getStatus();
        if (!status.equals(QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "题目正在判题中...");
        }
        // 设置状态
        QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
        questionSubmitUpdate.setId(questionSubmitId);
        questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
        boolean flag = questionSubmitService.updateById(questionSubmitUpdate);
        if (!flag) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        // 题目测试用例
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        // 获取所有输入用例
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        // 代码沙箱模块构建
        // 1.根据type创建沙箱实例
        CodeSandbox codeSandbox = CodeSandFactory.newInstance(type);
        // 2.执行代理模式
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        // 构建代码执行请求类
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest
                .builder()
                .code(code)
                .language(language)
                .input(inputList).build();

        // 3.获取运行代码沙箱结果
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        // 4.根据沙箱的运行的结果，设置题目的判题状态和信息
        // 创建对应判题需要的方法
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(executeCodeResponse.getOutputList());
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestion(question);
        judgeContext.setQuestionSubmit(questionSubmit);
        // 5.根据不同编程语言执行不同的判题机制
        //  5.1得到题目的判题状态
        JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);
//        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
//        JudgeInfo judgeInfo = judgeStrategy.doJudgeInfo(judgeContext);
        // 6.编译结束,更新提交题目信息
        QuestionSubmit updateQuestionSubmit = new QuestionSubmit();
        updateQuestionSubmit.setId(questionSubmitId);
        //  6.1转化为json字符串存放到数据库
        updateQuestionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        updateQuestionSubmit.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        //  6.2更新提交题目状态
        boolean updateFlag = questionSubmitService.updateById(updateQuestionSubmit);
        if (!updateFlag) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        // 7.查找最新状态下的提交题目信息 并返回
        QuestionSubmit questionSubmitResult = questionSubmitService.getById(questionId);
        return questionSubmitResult;
    }
}
