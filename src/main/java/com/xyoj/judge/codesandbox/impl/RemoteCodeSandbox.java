package com.xyoj.judge.codesandbox.impl;

import com.xyoj.judge.codesandbox.CodeSandbox;
import com.xyoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xyoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 远程代码沙箱（实际调用接口的沙箱）
 */
public class RemoteCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("示例沙箱");
        return null;
    }
}
