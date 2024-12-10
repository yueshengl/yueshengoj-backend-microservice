package com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox.impl;


/**
 * @Author: Dai
 * @Date: 2024/12/04 14:57
 * @Description: ExampleCodeSandbox
 * @Version: 1.0
 */

import com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 第三方代码沙箱（调用网上现成的代码沙箱）
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
