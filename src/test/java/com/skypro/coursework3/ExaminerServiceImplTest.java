package com.skypro.coursework3;

import com.skypro.coursework3.model.Question;
import com.skypro.coursework3.service.ExaminerServiceImpl;
import com.skypro.coursework3.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    private Question test1 = new Question("Test1", "Testik1");

    @Mock
    JavaQuestionService javaQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerService;

private final Collection<Question> questions = Set.of(
        test1,
        new Question("Test2", "Testik2"),
        new Question("Test3", "Testik3"),
        new Question("Test4", "Testik4"),
        new Question("Test5", "Testik5")
);
    @BeforeEach
    public void setUp() {
        when(javaQuestionService.getAll()).thenReturn(questions);
        when(javaQuestionService.getRandomQuestion()).thenReturn(new Question("Test1", "Testik1"));
    }

    @Test
    public void shouldReturnAmountQuestion() {
        Assertions.assertEquals(examinerService.getQuestions(1), Set.of(test1));
    }
}
