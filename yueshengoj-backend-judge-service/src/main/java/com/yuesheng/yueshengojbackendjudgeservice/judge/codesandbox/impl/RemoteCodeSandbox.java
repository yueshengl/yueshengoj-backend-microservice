package com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.yuesheng.yueshengojbackendcommon.common.ErrorCode;
import com.yuesheng.yueshengojbackendcommon.exception.BusinessException;
import com.yuesheng.yueshengojbackendjudgeservice.judge.codesandbox.CodeSandbox;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.yuesheng.yueshengojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Dai
 * @Date: 2024/12/04 14:57
 * @Description: ExampleCodeSandbox
 * @Version: 1.0
 */

/**
 * 远程代码沙箱
 */
public class RemoteCodeSandbox implements CodeSandbox {

    private static final String AUTH_REQUEST_HEADER = "auth";
    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        String url = "http://192.168.247.146:8090/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if(StringUtils.isBlank(responseStr)){
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR,"executeCode remoteSandbox error = "+responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }

}
