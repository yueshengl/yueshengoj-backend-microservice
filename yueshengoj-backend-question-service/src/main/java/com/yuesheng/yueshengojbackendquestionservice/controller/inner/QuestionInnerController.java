package com.yuesheng.yueshengojbackendquestionservice.controller.inner;

import com.yuesheng.yueshengojbackendmodel.model.entity.Question;
import com.yuesheng.yueshengojbackendmodel.model.entity.QuestionSubmit;
import com.yuesheng.yueshengojbackendquestionservice.service.QuestionService;
import com.yuesheng.yueshengojbackendquestionservice.service.QuestionSubmitService;
import com.yuesheng.yueshengojbackendserviceclient.service.QuestionFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: Dai
 * @Date: 2024/12/09 16:37
 * @Description: UserInnerController
 * @Version: 1.0
 */
@RestController
@RequestMapping("/inner")
public class QuestionInnerController implements QuestionFeignClient {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Override
    @GetMapping("/get/id")
    public Question getQuestionById(@RequestParam("questionId") long questionId){
        return questionService.getById(questionId);
    }

    @Override
    @GetMapping("/question_submit/get/id")
    public QuestionSubmit getQuestionSubmitById(@RequestParam("questionId") long questionSubmitId){
        return questionSubmitService.getById(questionSubmitId);
    }

    @Override
    @PostMapping("/question_submit/update")
    public boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit){
        return questionSubmitService.updateById(questionSubmit);
    }

    @Override
    @PostMapping("/question/update")
    public boolean updateQuestionById(@RequestBody Question question){
        return questionService.updateById(question);
    }

}
