package com.xyoj.judge;


import com.xyoj.judge.strategy.DefaultJudgeStrategy;
import com.xyoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.xyoj.judge.strategy.JudgeContext;
import com.xyoj.judge.strategy.JudgeStrategy;
import com.xyoj.judge.codesandbox.model.JudgeInfo;
import com.xyoj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {
    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudgeInfo(judgeContext);
    }

}
