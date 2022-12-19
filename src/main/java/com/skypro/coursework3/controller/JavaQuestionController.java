package com.skypro.coursework3.controller;

import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(@Qualifier("javaQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

@GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String questionAnswer) {
    return questionService.add(questionText, questionAnswer);
}

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String questionAnswer) {
        Question remQuestion = new Question(questionText, questionAnswer);
        return questionService.remove(remQuestion);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
