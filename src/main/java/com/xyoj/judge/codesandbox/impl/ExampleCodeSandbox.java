package com.xyoj.judge.codesandbox.impl;

import com.xyoj.judge.codesandbox.CodeSandbox;
import com.xyoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xyoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.xyoj.judge.codesandbox.model.JudgeInfo;
import com.xyoj.model.enums.JudgeInfoMessageEnum;

import java.util.List;

/**
 * 示例代码沙箱
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setMessage("编译成功");
        List<String> inputList = executeCodeRequest.getInput();
       /*
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());

        executeCodeResponse.setJudgeInfo(judgeInfo);
       * */
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setStatus(1);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        executeCodeResponse.setOutputList(inputList);
        System.out.println("示例沙箱");
        return executeCodeResponse;
    }
}
