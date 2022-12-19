package com.skypro.coursework3.repository;

import com.skypro.coursework3.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();
}
