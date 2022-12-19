package com.skypro.coursework3.service;

import com.skypro.coursework3.exception.BadRequestException;
import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.repository.JavaQuestionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private JavaQuestionRepository repository;

    @Mock
    private UtilService utilService;

    @InjectMocks
    private MathQuestionService service;

    @BeforeEach
    void setUp() {
        service = new MathQuestionService(repository, utilService);
    }

    @Test
    void addNewQuestion() {
        Question expected = new Question("Q", "A");
        Mockito.when(repository.add(any())).thenReturn(expected);
        Question actual = service.add(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addNewByQuestionAndAnswer() {
        Question expected = new Question("Q", "A");
        Mockito.when(repository.add(any())).thenReturn(expected);
        Question actual = service.add(expected.getQuestion(), expected.getAnswer());
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addNullOrBlankQuestion() {
        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> service.add(null, "A"));
        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> service.add("", "A"));
    }

    @Test
    void addNullOrBlankAnswer() {
        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> service.add("Q", null));
        Assertions.assertThatExceptionOfType(BadRequestException.class).isThrownBy(() -> service.add("Q", ""));
    }

    @Test
    void removeQuestion() {
        Question expected = new Question("Q", "A");
        Mockito.when(repository.remove(any())).thenReturn(expected);
        Question actual = service.remove(expected);
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getAllQuestions() {
        Collection<Question> expected = List.of(new Question("A1", "Q1"), new Question("A2", "Q2"));
        Mockito.when(repository.getAll()).thenReturn(expected);
        Collection<Question> actual = service.getAll();
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getRandomQuestion() {
        Question expected = new Question("Q", "A");
        List<Question> expectedList = List.of(expected);
        Mockito.when(repository.getAll()).thenReturn(expectedList);
        Mockito.when(utilService.getRandomInt(anyInt())).thenReturn(0);
        Question actual = service.getRandomQuestion();
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
