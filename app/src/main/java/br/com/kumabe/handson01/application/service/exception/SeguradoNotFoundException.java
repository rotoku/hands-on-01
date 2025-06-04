package br.com.kumabe.handson01.application.service.exception;

public class SeguradoNotFoundException extends RuntimeException {
    public SeguradoNotFoundException(String message) {
        super(message);
    }
}
