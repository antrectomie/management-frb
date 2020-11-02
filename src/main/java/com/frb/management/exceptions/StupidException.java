package com.frb.management.exceptions;

import com.frb.management.errorconfig.ExceptionType;
import lombok.Data;

@Data
public class StupidException extends Exception {
    private ExceptionType exceptionType;
    public StupidException(String s, ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
}
