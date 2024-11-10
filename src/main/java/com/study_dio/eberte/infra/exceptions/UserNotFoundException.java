package com.study_dio.eberte.infra.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("Could not find user "+id);
    }
}

