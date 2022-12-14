package com.skypro.coursework3.service;

import com.skypro.coursework3.exception.GetQuestionAmountException;
import com.skypro.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
 // import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService questionService;
     // private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new GetQuestionAmountException("Введите число меньше, либо не равное нулю и не отрицательное");
        }
        Collection<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
