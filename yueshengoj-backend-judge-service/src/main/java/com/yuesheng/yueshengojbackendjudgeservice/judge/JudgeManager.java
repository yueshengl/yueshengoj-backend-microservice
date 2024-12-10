package com.yuesheng.yueshengojbackendjudgeservice.judge;

/**
 * @Author: Dai
 * @Date: 2024/12/04 17:52
 * @Description: JudgeManager
 * @Version: 1.0
 */

import com.yuesheng.yueshengojbackendjudgeservice.judge.strategy.DefaultJudgeStrategy;
import com.yuesheng.yueshengojbackendjudgeservice.judge.strategy.JavaLanguageJudgeStrategy;
import com.yuesheng.yueshengojbackendjudgeservice.judge.strategy.JudgeContext;
import com.yuesheng.yueshengojbackendjudgeservice.judge.strategy.JudgeStrategy;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.JudgeInfo;
import com.yuesheng.yueshengojbackendmodel.model.entity.QuestionSubmit;
import com.yuesheng.yueshengojbackendmodel.model.enums.QuestionSubmitLanguageEnum;
import org.springframework.stereotype.Service;

/**
 * 判题管理，简化调用,选择策略
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    public JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy JudgeStrategy = new DefaultJudgeStrategy();
        if(QuestionSubmitLanguageEnum.JAVA.getValue().equals(language)){
            JudgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return JudgeStrategy.doJudge(judgeContext);
    }
}
