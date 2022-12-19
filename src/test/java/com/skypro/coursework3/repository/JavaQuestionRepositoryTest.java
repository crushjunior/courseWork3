package com.skypro.coursework3.repository;

import com.skypro.coursework3.exception.BadRequestException;
import com.skypro.coursework3.model.Question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JavaQuestionRepositoryTest {
    private JavaQuestionRepository repository;

    @BeforeEach
    void setUp() {
        repository = new JavaQuestionRepository();
        repository.add(new Question("Q1", "A1"));
        repository.add(new Question("Q2", "A2"));
    }

    @Test
    void addNewQuestion() {
        Question expected = new Question("Q3", "A3");
        Question actual = repository.add(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
        Assertions.assertThat(repository.getAll().contains(expected)).isTrue();
        Assertions.assertThat(repository.getAll().size()).isEqualTo(3);
    }

    @Test
    void addNewExistingQuestion() {
        repository.add(new Question("Q1", "A1"));
        Assertions.assertThat(repository.getAll().size()).isEqualTo(2);
    }

    @Test
    void addNullQuestion() {
        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> repository.add(null));
    }

    @Test
    void removeQuestion() {
        Question expected = new Question("Q2", "A2");
        Question actual = repository.remove(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
        Assertions.assertThat(repository.getAll().size()).isEqualTo(1);
    }

    @Test
    void removeNotExistingQuestion() {
        Question expected = new Question("Q3", "A3");
        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> repository.remove(expected));
    }

    @Test
    void getAll() {
        Assertions.assertThat(repository.getAll().size()).isEqualTo(2);
    }
}
