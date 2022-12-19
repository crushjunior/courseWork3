package com.skypro.coursework3.repository;

import com.skypro.coursework3.exception.BadRequestException;
import com.skypro.coursework3.model.Question;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions = new HashSet<>();


    @Override
    public Question add(Question question) {
        if (question == null) {
            throw new BadRequestException("Пустой вопрос");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new BadRequestException("Такого вопроса нет");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
