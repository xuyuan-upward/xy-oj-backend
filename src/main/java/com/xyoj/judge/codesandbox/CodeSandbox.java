package com.xyoj.judge.codesandbox;

import com.xyoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xyoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口
 */
public interface CodeSandbox {
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
