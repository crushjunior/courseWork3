package com.skypro.coursework3.controller;

import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.JavaQuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

@GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String questionAnswer) {
    return javaQuestionService.add(questionText, questionAnswer);
}

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String questionAnswer) {
        Question remQuestion = new Question(questionText, questionAnswer);
        return javaQuestionService.remove(remQuestion);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return javaQuestionService.getAll();
    }

}
