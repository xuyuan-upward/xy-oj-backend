package com.xyoj.judge.codesandbox.model;

import lombok.Data;

/**
 * 题目提交编译信息
 */
@Data
public class JudgeInfo {
    /**
     * 程序执行结果信息
     */
    private String message;
    /**
     * 消耗内存
     */
    private Long memory;
    /**
     * 消耗时间
     */
    private Long time;
    /**
     * 消耗栈时间
     */
    private Long stackTime;
}
