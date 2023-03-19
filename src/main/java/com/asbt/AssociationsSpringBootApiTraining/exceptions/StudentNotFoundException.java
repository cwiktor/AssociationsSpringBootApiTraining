package com.asbt.AssociationsSpringBootApiTraining.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
}
