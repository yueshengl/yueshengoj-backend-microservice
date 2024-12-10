package com.yuesheng.yueshengojbackendjudgeservice.judge.strategy;

import cn.hutool.json.JSONUtil;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.JudgeInfo;
import com.yuesheng.yueshengojbackendmodel.model.dto.question.JudgeCase;
import com.yuesheng.yueshengojbackendmodel.model.dto.question.JudgeConfig;
import com.yuesheng.yueshengojbackendmodel.model.entity.Question;
import com.yuesheng.yueshengojbackendmodel.model.enums.JudgeInfoMessageEnum;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: Dai
 * @Date: 2024/12/04 17:24
 * @Description: DefaultJudgeStrategy
 * @Version: 1.0
 */

/**
 * java判题策略
 */
public class JavaLanguageJudgeStrategy implements JudgeStrategy{

    @Override
    public JudgeInfo doJudge(JudgeContext judgeContext) {
        JudgeInfo judgeInfo = judgeContext.getJudgeInfo();
        Long memory = Optional.ofNullable(judgeInfo.getMemory()).orElse(0L);
        Long time = Optional.ofNullable(judgeInfo.getTime()).orElse(0L);

        List<String> inputList = judgeContext.getInputList();
        List<String> outputList = judgeContext.getOutputList().stream().flatMap(output -> Stream.of(output.split("\n"))).collect(Collectors.toList());
        Question question = judgeContext.getQuestion();
        List<JudgeCase> judgeCaseList = judgeContext.getJudgeCaseList();

        JudgeInfoMessageEnum judgeInfoMessageEnum = JudgeInfoMessageEnum.ACCEPTED;
        JudgeInfo judgeInfoResponse = new JudgeInfo();
        judgeInfoResponse.setMemory(memory);
        judgeInfoResponse.setTime(time);
        //判断编译或运行是否出错
        Integer status = judgeContext.getStatus();
        if(status.equals(2)){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.COMPILE_ERROR;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        if(status.equals(3)){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.RUNTIME_ERROR;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }

        //先判断沙箱的执行结果，设置题目的判题状态和信息
        if(outputList.size()!=inputList.size()){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        //依次判断每一项输出和预期输出是否相等
        for (int i = 0; i < judgeCaseList.size(); i++) {
            String expectedOutput = judgeCaseList.get(i).getOutput();
            String actualOutput = outputList.get(i);
            if(!expectedOutput.equals(actualOutput)){
                judgeInfoMessageEnum = JudgeInfoMessageEnum.WRONG_ANSWER;
                judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
                return judgeInfoResponse;
            }
        }
        //判断题目限制
        String judgeConfigStr = question.getJudgeConfig();
        JudgeConfig judgeConfig = JSONUtil.toBean(judgeConfigStr, JudgeConfig.class);
        Long needTimeLimit = judgeConfig.getTimeLimit();
        Long needMemoryLimit = judgeConfig.getMemoryLimit();
        if(memory>needMemoryLimit){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.MEMORY_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        //java程序本身需要额外执行2s
        long JAVA_PROGRAM_EXTRA_TIME = 2000L;
        if(time-JAVA_PROGRAM_EXTRA_TIME>needTimeLimit){
            judgeInfoMessageEnum = JudgeInfoMessageEnum.TIME_LIMIT_EXCEEDED;
            judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
            return judgeInfoResponse;
        }
        judgeInfoResponse.setMessage(judgeInfoMessageEnum.getValue());
        return judgeInfoResponse;
    }
}
