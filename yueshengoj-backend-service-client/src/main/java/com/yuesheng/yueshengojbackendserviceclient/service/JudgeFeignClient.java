package com.yuesheng.yueshengojbackendserviceclient.service;

/**
 * @Author: Dai
 * @Date: 2024/12/04 16:34
 * @Description: JudgeService
 * @Version: 1.0
 */

import com.yuesheng.yueshengojbackendmodel.model.entity.QuestionSubmit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 判题服务
 */
@FeignClient(name="yueshengoj-backend-judge-service",path = "/api/judge/inner")
public interface JudgeFeignClient {

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    @PostMapping("/do")
    QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId);
}
