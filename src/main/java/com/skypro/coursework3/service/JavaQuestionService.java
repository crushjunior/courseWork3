package com.skypro.coursework3.service;

import com.skypro.coursework3.exception.QuestionExistYet;
import com.skypro.coursework3.exception.QuestionNotExist;
import com.skypro.coursework3.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{
    Set<Question> questions = new HashSet<>();
    Random random = new Random();
    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionExistYet("Данный вопрос уже добавлен");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotExist("Данного вопроса в списке нет");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        List list = new ArrayList<>(questions);
        return (Question)list.get(random.nextInt(list.size()));
    }
}
