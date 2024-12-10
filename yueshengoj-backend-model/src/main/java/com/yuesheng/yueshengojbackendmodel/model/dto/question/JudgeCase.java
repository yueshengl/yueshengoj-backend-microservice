package com.yuesheng.yueshengojbackendmodel.model.dto.question;

import lombok.Data;

/**
 * @Author: Dai
 * @Date: 2024/11/30 22:46
 * @Description: JudgeCase
 * @Version: 1.0
 */
@Data
public class JudgeCase {
    /**
     * 输入用例
     */
    private String input;
    /**
     * 输出用例
     */
    private String output;
}