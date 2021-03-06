package com.frb.management.exceptions;

import com.frb.management.errorconfig.ExceptionType;
import lombok.Data;

@Data
public class WrongParameterException extends RuntimeException {
    private ExceptionType exceptionType;
    public WrongParameterException(String message, ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
