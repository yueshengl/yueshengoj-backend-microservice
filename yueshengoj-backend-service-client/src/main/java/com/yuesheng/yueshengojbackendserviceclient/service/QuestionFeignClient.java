package com.yuesheng.yueshengojbackendserviceclient.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuesheng.yueshengojbackendmodel.model.dto.question.QuestionQueryRequest;
import com.yuesheng.yueshengojbackendmodel.model.entity.Question;
import com.yuesheng.yueshengojbackendmodel.model.entity.QuestionSubmit;
import com.yuesheng.yueshengojbackendmodel.model.vo.QuestionVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
* @description 针对表【Question(题目)】的数据库操作Service
* @createDate 2023-08-07 20:58:00
*/
@FeignClient(name="yueshengoj-backend-question-service",path = "/api/question/inner")
public interface QuestionFeignClient {

    //questionService.getById(questionId)
    //questionSubmitService.getById(questionSubmitId)
    //questionSubmitService.updateById(questionSubmitUpdate)
    //questionService.updateById(question);

    @GetMapping("/get/id")
    Question getQuestionById(@RequestParam("questionId") long questionId);

    @GetMapping("/question_submit/get/id")
    QuestionSubmit getQuestionSubmitById(@RequestParam("questionId") long questionSubmitId);

    @PostMapping("/question_submit/update")
    boolean updateQuestionSubmitById(@RequestBody QuestionSubmit questionSubmit);

    @PostMapping("/question/update")
    boolean updateQuestionById(@RequestBody Question question);

}
