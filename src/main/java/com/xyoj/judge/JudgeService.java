package com.xyoj.judge;

import com.xyoj.model.entity.QuestionSubmit;
public interface JudgeService {
    /**
     * 根据提交题目提交Id进行对应的判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
