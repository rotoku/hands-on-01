package br.com.kumabe.handson01.domain.exception;

public class ApoliceNotFoundException extends RuntimeException {

    public ApoliceNotFoundException(String message) {
        super(message);
    }
    
}
