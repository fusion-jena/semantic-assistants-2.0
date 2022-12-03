package com.unijena.nlp.exception;

public class RequestLimitException extends RuntimeException{
    public RequestLimitException(String message){
        super(message);
    }

}
