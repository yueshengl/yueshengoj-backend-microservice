package com.yuesheng.yueshengojbackendmodel.model.dto.question;

import lombok.Data;

/**
 * @Author: Dai
 * @Date: 2024/11/30 22:47
 * @Description: JudgeConfig
 * @Version: 1.0
 */
@Data
public class JudgeConfig {
    /**
     * 时间限制(ms)
     */
    private Long timeLimit;
    /**
     * 内存限制(kB)
     */
    private Long memoryLimit;
    /**
     * 堆栈限制(kB)
     */
    private Long stackLimit;
}
