package com.xyoj.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.xyoj.model.dto.question.JudgeCase;
import com.xyoj.model.dto.question.JudgeConfig;
import com.xyoj.model.dto.questionsubmit.JudgeInfo;
import com.xyoj.model.entity.Question;
import com.xyoj.model.entity.QuestionSubmit;
import com.xyoj.model.enums.JudgeInfoMessageEnum;

import java.util.List;

/**
 * 默认判题策略 （扩展点：java实现判题策略，同时允许多种语言进行）
 */
public class DefaultJudgeStrategy implements JudgeStrategy{
    /**
     *
     * @param judgeContext
     * @return
     */
    @Override
    public JudgeInfo doJudgeInfo(JudgeContext judgeContext) {
        // 获取对应编译的结果
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        Long time = judgeInfo.getTime();
        Long memory = judgeInfo.getMemory();
        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();
        Question question = judgeContext.getQuestion();
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        // 返回的judgeInfoResponse结果
        // 1.设置初始化judgeInfoResponse
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemory(memory);
        judgeInfoResponse.setTime(time);
        // 3.设置编译状态 判断题目限制
        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.WAITING;
        if (outputList.size() != inputList.size()) {
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        for (int i = 0; i < outputList.size(); i++) {
            if (!outputList.get(i).equals(judgeCaseList.get(i).getOutput())) {
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfoResponse;
            }
        }
        // 判断编译范围有没有超时等等
        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        if ( time> judgeConfig.getTimeLimit()) {
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }  if (memory> judgeConfig.getMemoryLimit()) {
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        // 运行通过
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
        return judgeInfoResponse;
    }
}
