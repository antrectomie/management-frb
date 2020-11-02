package com.frb.management.errorconfig;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorModel {
    private HttpStatus httpStatus;

    private LocalDateTime timestamp;

    private String message;

    private String details;

    private ExceptionType exceptionType;

    public ErrorModel(HttpStatus httpStatus, String message, String details, ExceptionType exceptionType) {
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now();
        this.message = message;
        this.details = details;
        this.exceptionType = exceptionType;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
