package com.skypro.coursework3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class GetQuestionAmountException extends RuntimeException {
    public GetQuestionAmountException() {
    }

    public GetQuestionAmountException(String message) {
        super(message);
    }
}
