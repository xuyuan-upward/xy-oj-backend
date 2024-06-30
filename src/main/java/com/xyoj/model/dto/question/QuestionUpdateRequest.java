package com.xyoj.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 更新请求
 *
 * @author xuyuan
 *  
 */
@Data
public class QuestionUpdateRequest implements Serializable {
    /**
     * 题目id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 答案
     */
    private String answer;
    /**
     * 判题用例 输入和输出用例
     */
    private String judgeCase;

    /**
     * 判题配置
     */
    private String judgeConfig;

    private static final long serialVersionUID = 1L;
}