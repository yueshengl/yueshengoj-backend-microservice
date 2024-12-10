package com.yuesheng.yueshengojbackendjudgeservice.judge.strategy;

/**
 * @Author: Dai
 * @Date: 2024/12/04 17:22
 * @Description: JudgeContext
 * @Version: 1.0
 */

import com.yuesheng.yueshengojbackendmodel.model.codesandbox.JudgeInfo;
import com.yuesheng.yueshengojbackendmodel.model.dto.question.JudgeCase;
import com.yuesheng.yueshengojbackendmodel.model.entity.Question;
import com.yuesheng.yueshengojbackendmodel.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * 上下文（用于定义在策略中传递的参数）
 */
@Data
public class JudgeContext {

    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;
    private Integer status;

    private Question question;

    private QuestionSubmit questionSubmit;
}
