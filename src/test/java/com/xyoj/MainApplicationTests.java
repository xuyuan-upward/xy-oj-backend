package com.xyoj;

import com.google.gson.Gson;
import com.xyoj.model.dto.question.JudgeCase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 主类测试
 *
 * @author xuyuan
 *  
 */
@SpringBootTest
class MainApplicationTests {
    private final static Gson GSON = new Gson();
    @Test
    void contextLoads() {
        List<String> tags = new ArrayList<>();
        tags.add("ni");
        tags.add("ni");
        tags.add("ni");
        System.out.println(tags
        );
        System.out.println(GSON.toJson(tags));
        JudgeCase judgeCase = new JudgeCase();
        judgeCase.setInput("rre");
        judgeCase.setOutput("wrwe");
        System.out.println(GSON.toJson(judgeCase));
    }

}
