package com.yuesheng.yueshengojbackendjudgeservice.controller.inner;

import com.yuesheng.yueshengojbackendjudgeservice.judge.JudgeService;
import com.yuesheng.yueshengojbackendmodel.model.entity.QuestionSubmit;
import com.yuesheng.yueshengojbackendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: Dai
 * @Date: 2024/12/09 16:37
 * @Description: UserInnerController
 * @Version: 1.0
 */
@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;


    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    @Override
    @PostMapping("/do")
    public QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId){
        return judgeService.doJudge(questionSubmitId);
    }

}
