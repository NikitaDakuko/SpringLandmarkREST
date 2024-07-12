package org.nikita.SpringLandmarkREST.exception;

public class LandmarkNotFoundException extends RuntimeException{
    public LandmarkNotFoundException(long id){
        super("Could not find landmark with ID: " + id);
    }
}
