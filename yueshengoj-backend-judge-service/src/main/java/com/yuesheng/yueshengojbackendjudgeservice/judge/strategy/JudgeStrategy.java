package com.yuesheng.yueshengojbackendjudgeservice.judge.strategy;

/**
 * @Author: Dai
 * @Date: 2024/12/04 17:21
 * @Description: JudgeStrategy
 * @Version: 1.0
 */


import com.yuesheng.yueshengojbackendmodel.model.codesandbox.JudgeInfo;

/**
 * 判题策略
 */
public interface JudgeStrategy {
    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}
