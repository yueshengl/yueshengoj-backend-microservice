package com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox;


/**
 * @Author: Dai
 * @Date: 2024/12/04 14:47
 * @Description: CodeSandbox
 * @Version: 1.0
 */

import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {
    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
