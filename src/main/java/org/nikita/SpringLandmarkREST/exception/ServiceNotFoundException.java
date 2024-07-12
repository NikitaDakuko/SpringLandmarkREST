package org.nikita.SpringLandmarkREST.exception;

public class ServiceNotFoundException extends RuntimeException{
    public ServiceNotFoundException(long id){
        super("Could not find service with ID: " + id);
    }
}
