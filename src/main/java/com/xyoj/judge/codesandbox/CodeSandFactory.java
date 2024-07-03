package com.xyoj.judge.codesandbox;

import com.xyoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.xyoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.xyoj.judge.codesandbox.impl.ThirdCodeSandbox;

/**
 * 静态工厂
 */
public class CodeSandFactory {

    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example": return new ExampleCodeSandbox();
            case "third": return new ThirdCodeSandbox();
            case "remote": return new RemoteCodeSandbox();
            default: return new ExampleCodeSandbox();
        }
    }
}
