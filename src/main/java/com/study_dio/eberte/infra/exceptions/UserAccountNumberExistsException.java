package com.study_dio.eberte.infra.exceptions;

public class UserAccountNumberExistsException extends RuntimeException{

    public UserAccountNumberExistsException(String numberAccount){
        super("This account number already exists "+ numberAccount);
    }
}
