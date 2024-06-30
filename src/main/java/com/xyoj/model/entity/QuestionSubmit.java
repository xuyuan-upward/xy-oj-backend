package com.xyoj.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 提交题目
 * @TableName question_submit
 */
@TableName(value ="question_submit")
@Data
public class QuestionSubmit implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 代码内容
     */
    private String code;

    /**
     * 标签列表（json 数组）
     */
    private String tags;

    /**
     * 创建用户 Id
     */
    private Integer userId;

    /**
     * 题目 Id
     */
    private Integer questionId;

    /**
     * 提交提交的状态
     */
    private Integer status;

    /**
     * 判题信息(判题得出的信息结果 eg：编译失败，超时等）
     */
    private String judgeInfo;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}