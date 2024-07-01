package com.xyoj.model.dto.question;

import lombok.Data;

/**
 * 题目用例 (为了方便输入用例的操作)
 */
@Data
public class JudgeCase {

    /**
     * 输入用例
     */
    private String input;
    /**
     * 输出用例
     */
    private String output;
}
