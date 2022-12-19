package com.skypro.coursework3.service;

import com.skypro.coursework3.exception.NotFoundException;
import com.skypro.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;


@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final List<QuestionService> questionServices;
    private final UtilService utilService;


    public ExaminerServiceImpl(List<QuestionService> questionServices, UtilService utilService) {
        this.questionServices = questionServices;
        this.utilService = utilService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > sumAmount() || amount <= 0) {
            throw new NotFoundException("Введите число меньше, либо не равное нулю и не отрицательное");
        }
        Collection<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
            int serviceNumber = utilService.getRandomInt(questionServices.size());
            var questionService = questionServices.get(serviceNumber);
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }

    private int sumAmount() {
        return questionServices.stream()
                .mapToInt(s -> s.getAll().size()).sum();
    }
}
