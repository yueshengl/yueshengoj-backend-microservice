package com.yuesheng.yueshengojbackendjudgeservice.judge;

/**
 * @Author: Dai
 * @Date: 2024/12/04 16:34
 * @Description: JudgeService
 * @Version: 1.0
 */


import com.yuesheng.yueshengojbackendmodel.model.entity.QuestionSubmit;

/**
 * 判题服务
 */
public interface JudgeService {

    QuestionSubmit doJudge(long questionSubmitId);
}
