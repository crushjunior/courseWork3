package com.skypro.coursework3.service;

import com.skypro.coursework3.exception.BadRequestException;
import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository questions;
    private final UtilService utilService;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questions, UtilService utilService) {
        this.questions = questions;
        this.utilService = utilService;
    }


    @Override
    public Question add(String question, String answer) {
        if (question == null || question.isBlank()) {
            throw new BadRequestException("Некоретный вопрос");
        }
        if (answer == null || answer.isBlank()) {
            throw new BadRequestException("Некоретный ответ");
        }
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(questions.getAll());
        return list.get(utilService.getRandomInt(list.size()));
    }
}
