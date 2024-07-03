package com.xyoj.judge.codesandbox.impl;

import com.xyoj.judge.codesandbox.CodeSandbox;
import com.xyoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xyoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 示例代码沙箱
 */
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("示例沙箱");
        return null;
    }
}
