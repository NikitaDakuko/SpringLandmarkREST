package org.nikita.SpringLandmarkREST.exception.handler;

import org.nikita.SpringLandmarkREST.exception.LocationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LocationNotFoundHandler {
    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundHandler(LocationNotFoundException e){
        return e.getMessage();
    }
}
