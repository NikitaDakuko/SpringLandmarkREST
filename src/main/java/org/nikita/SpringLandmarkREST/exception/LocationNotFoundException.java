package org.nikita.SpringLandmarkREST.exception;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(long id){
        super("Could not find location with ID: " + id);
    }
}
