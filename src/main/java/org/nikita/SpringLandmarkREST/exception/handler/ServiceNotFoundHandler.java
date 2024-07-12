package org.nikita.SpringLandmarkREST.exception.handler;

import org.nikita.SpringLandmarkREST.exception.ServiceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceNotFoundHandler {
    @ExceptionHandler(ServiceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notFoundHandler(ServiceNotFoundException e){
        return e.getMessage();
    }
}
