package com.skypro.coursework3.service;

import com.skypro.coursework3.exception.BadRequestException;
import com.skypro.coursework3.exception.NotFoundException;
import com.skypro.coursework3.model.Question;
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
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl service;

    @Mock
    private UtilService utilService;

    @Mock
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        service = new ExaminerServiceImpl(List.of(questionService), utilService);
    }

    @Test
    void getQuestionsWithTrueAmount() {
        Question expected = new Question("Q", "A");
        Set<Question> expectedSet = Set.of(expected);
        Mockito.when(utilService.getRandomInt(anyInt())).thenReturn(0);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(expected);
        Mockito.when(questionService.getAll()).thenReturn(expectedSet);
        Collection<Question> actualSet = service.getQuestions(1);
        Assertions.assertThat(actualSet).isEqualTo(expectedSet);
    }

    @Test
    void getQuestionsWithFalseAmount() {
        Question expected = new Question("Q", "A");
        Set<Question> expectedSet = Set.of(expected);
        Mockito.when(questionService.getAll()).thenReturn(expectedSet);
        Assertions.assertThatExceptionOfType(NotFoundException.class).isThrownBy(() -> service.getQuestions(2));
    }
}
