package org.nikita.SpringLandmarkREST.exception.handler;

import org.nikita.SpringLandmarkREST.exception.LandmarkNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LandmarkNotFoundHandler {
    @ExceptionHandler(LandmarkNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundHandler(LandmarkNotFoundException e){
        return e.getMessage();
    }
}
