package com.skypro.coursework3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class QuestionExistYet extends RuntimeException{
    public QuestionExistYet() {
    }

    public QuestionExistYet(String message) {
        super(message);
    }
}
