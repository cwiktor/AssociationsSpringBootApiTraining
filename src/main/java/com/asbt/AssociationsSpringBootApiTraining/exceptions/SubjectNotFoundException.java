package com.asbt.AssociationsSpringBootApiTraining.exceptions;

public class SubjectNotFoundException extends RuntimeException{
    public SubjectNotFoundException(String message){
        super(message);
    }
}
