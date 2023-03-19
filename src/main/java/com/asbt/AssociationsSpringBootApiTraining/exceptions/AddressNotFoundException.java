package com.asbt.AssociationsSpringBootApiTraining.exceptions;

public class AddressNotFoundException extends RuntimeException{
    public AddressNotFoundException(String message) {
        super(message);
    }
}
