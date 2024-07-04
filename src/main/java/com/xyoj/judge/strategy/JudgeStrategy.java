package com.xyoj.judge.strategy;

import com.xyoj.model.dto.questionsubmit.JudgeInfo;

/**
 * 实现对应的策略模式
 */
public interface JudgeStrategy {
    JudgeInfo doJudgeInfo(JudgeContext judgeContext);
}
