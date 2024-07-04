package com.xyoj.judge.strategy;

import com.xyoj.model.dto.question.JudgeCase;
import com.xyoj.model.dto.questionsubmit.JudgeInfo;
import com.xyoj.model.entity.Question;
import com.xyoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文参数
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase>     judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
