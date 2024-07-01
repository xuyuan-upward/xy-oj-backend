package com.xyoj.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 创建题目
 * @TableName question
 */
@TableName(value ="question")
@Data
public class Question implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
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
    private String tags;

    /**
     * 答案
     */
    private String answer;

    /**
     * 创建用户 Id
     */
    private Long userId;

    /**
     * 提交人数
     */
    private Integer submitNum;

    /**
     * 通过人数
     */
    private Long acceptedNum;

    /**
     * 点赞人数
     */
    private Long thumbNum;

    /**
     * 收藏人数
     */
    private Long favourNum;

    /**
     * 判题用例
     */
    private String judgeCase;

    /**
     * 判题配置
     */
    private String judgeConfig;

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