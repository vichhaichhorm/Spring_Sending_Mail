package com.vichhaicoder.userservice_send_mail.modal.exception;

import com.vichhaicoder.userservice_send_mail.modal.apiResponse.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public HttpResponse handleEmailAlreadyExistsException(EmailAlreadyExistsException ex) {
        return HttpResponse.builder()
                .timeSpam(LocalDateTime.now().toString())
                .statusCode(HttpStatus.CONFLICT.value())
                .status(HttpStatus.CONFLICT)
                .message(ex.getMessage())
                .build();
    }
}

