package com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox;

/**
 * @Author: Dai
 * @Date: 2024/12/04 15:53
 * @Description: CodeSandboxFactory
 * @Version: 1.0
 */


import com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox.impl.ExampleCodeSandbox;
import com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox.impl.RemoteCodeSandbox;
import com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 代码沙箱工厂（根据字符串参数创建指定的代码沙箱实例）
 */
public class CodeSandboxFactory {
    /**
     * 创建代码沙箱实例
     * @param type
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type){
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
