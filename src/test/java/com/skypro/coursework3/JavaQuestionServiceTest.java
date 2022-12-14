package com.skypro.coursework3;

import com.skypro.coursework3.exception.QuestionExistYet;
import com.skypro.coursework3.exception.QuestionNotExist;
import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.JavaQuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collection;
import java.util.stream.Stream;

public class JavaQuestionServiceTest {
    JavaQuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
       javaQuestionService = new JavaQuestionService();
        Stream.of(
                new Question("Test1", "Testik1"),
                new Question("Test2", "Testik2"),
                new Question("Test3", "Testik3"),
                new Question("Test4", "Testik4"),
                new Question("Test5", "Testik5")
        ).forEach(javaQuestionService::add);
    }

    @Test
    public void shouldReturnTrueSizeAndAddQuestion() {
        Question test = new Question("question", "answer");
        javaQuestionService.add(test);
        Collection<Question> allQuestions = javaQuestionService.getAll();
        Assertions.assertThat(allQuestions).hasSize(6);
        Assertions.assertThat(allQuestions).contains(test);
    }

    @Test
    public void shouldReturnTrueSizeAndRemoveQuestion() {
        Question test = new Question("Test1", "Testik1");
        javaQuestionService.remove(test);
        Collection<Question> allQuestions = javaQuestionService.getAll();
        Assertions.assertThat(allQuestions).hasSize(4);
    }

    @Test
    public void shouldThrowQuestionExistYet() {
        Question test = new Question("Test1", "Testik1");
        assertThrows(QuestionExistYet.class, () -> javaQuestionService.add(test));
    }

    @Test
    public void shouldThrowQuestionNotExist() {
        Question test = new Question("Test11", "Testik11");
        assertThrows(QuestionNotExist.class, () -> javaQuestionService.remove(test));
    }

    @Test
    public void shouldReturnRandomQuestion() {
        Question random = javaQuestionService.getRandomQuestion();
        Collection<Question> allQuestions = javaQuestionService.getAll();
        Assertions.assertThat(allQuestions).contains(random);
    }
}
