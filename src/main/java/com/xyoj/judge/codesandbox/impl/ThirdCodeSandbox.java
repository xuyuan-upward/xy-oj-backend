package com.xyoj.judge.codesandbox.impl;

import com.xyoj.judge.codesandbox.CodeSandbox;
import com.xyoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xyoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 第三方沙箱（调用第三方接口扩展）
 */
public class ThirdCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("示例沙箱");
        return null;
    }
}
