package com.frb.management.exceptions;

public class WrongIdException extends RuntimeException{
    public WrongIdException(String message) {
        super(message);
    }
}
