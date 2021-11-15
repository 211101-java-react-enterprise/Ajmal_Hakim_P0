package com.revature.AHBank.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String msg){

        super(msg);
    }

}
