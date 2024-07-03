package com.xyoj.judge.codesandbox;

import com.xyoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.xyoj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CodeSandboxTest {

    /*codesandbox:
  type: example*/
    @Value("${codesandbox.type:example}")
    private String type;

    @Test
    void executeCode() {
        // 利用静态工厂创建实例
        System.out.println(type);
        CodeSandbox codeSandbox = CodeSandFactory.newInstance(type);

        ExecuteCodeRequest executeCodeRequest = new ExecuteCodeRequest();
        executeCodeRequest.builder().code("int main()")
                .input(Arrays.asList("12 12", "123 234"))
                .language(QuestionSubmitLanguageEnum.JAVA.getValue())
                .build();
        Assertions.assertNotNull(codeSandbox.executeCode(executeCodeRequest));
    }

}