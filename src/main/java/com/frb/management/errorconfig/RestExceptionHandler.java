package com.frb.management.errorconfig;

import com.frb.management.exceptions.StupidException;
import com.frb.management.exceptions.WrongIdException;
import com.frb.management.exceptions.WrongParameterException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorModel error = new ErrorModel(HttpStatus.BAD_REQUEST, "Validation Error", ex.getBindingResult().toString(), null);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorModel> handleEntityNotFound(EntityNotFoundException ex){
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Entity not found", ex.getMessage(), null);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongParameterException.class)
    private ResponseEntity<ErrorModel> handleEntityNotFound(WrongParameterException ex){
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Wrong parameter", ex.getMessage(), ex.getExceptionType());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WrongIdException.class)
    private ResponseEntity<ErrorModel> handleWrongId(WrongIdException ex){
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Wrong id", ex.getMessage(), ex.getExceptionType());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StupidException.class)
    private ResponseEntity<ErrorModel> handleNullParam(StupidException ex){
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Wrong id", ex.getMessage(), ex.getExceptionType());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
