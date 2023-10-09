package com.barradas.infra.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.NoSuchElementException;

@ControllerAdvice
public class HandlerExceptionResponse {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardException> handleNoSuchElementException(NoSuchElementException e,
                                                                          HttpServletRequest http) {
        String error  = "Resource not found!";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardException ste = new StandardException(Instant.now(),
                status.value(), error, e.getMessage(), http.getRequestURI());
        return ResponseEntity.status(status).body(ste);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandardException> handleIllegalArgumentException(IllegalArgumentException e,
                                                                          HttpServletRequest http) {
        String error  = "Bad request!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardException ste = new StandardException(Instant.now(),
                status.value(), error, e.getMessage(), http.getRequestURI());
        return ResponseEntity.status(status).body(ste);
    }
}
