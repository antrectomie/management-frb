package com.frb.management.exceptions;

import com.frb.management.errorconfig.ExceptionType;

public class WrongIdException extends RuntimeException{
    private ExceptionType exceptionType;
    public WrongIdException(String message, ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
