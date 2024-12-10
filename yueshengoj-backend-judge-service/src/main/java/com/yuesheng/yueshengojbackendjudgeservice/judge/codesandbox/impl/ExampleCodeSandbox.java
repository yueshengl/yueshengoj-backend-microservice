package com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox.impl;


import com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.JudgeInfo;
import com.yuesheng.yueshengojbackendmodel.model.enums.JudgeInfoMessageEnum;
import com.yuesheng.yueshengojbackendmodel.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * @Author: Dai
 * @Date: 2024/12/04 14:57
 * @Description: ExampleCodeSandbox
 * @Version: 1.0
 */

/**
 * 示例代码沙箱（仅为了跑通业务流程）
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();

        ExecuteCodeResponse executeCodeResponse=new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo=new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);

        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
