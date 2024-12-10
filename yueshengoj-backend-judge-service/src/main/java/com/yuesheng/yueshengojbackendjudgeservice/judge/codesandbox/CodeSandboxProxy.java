package com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox;

import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Dai
 * @Date: 2024/12/04 16:11
 * @Description: CodeSandboxProxy
 * @Version: 1.0
 */
@Slf4j
public class CodeSandboxProxy implements CodeSandbox{
    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息:"+executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息:"+executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
