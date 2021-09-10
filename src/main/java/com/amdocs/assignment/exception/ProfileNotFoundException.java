package com.amdocs.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProfileNotFoundException extends Exception{
    public ProfileNotFoundException(String message){
        super(message);
    }
}
