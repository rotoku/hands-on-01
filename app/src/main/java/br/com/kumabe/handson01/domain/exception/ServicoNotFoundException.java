package br.com.kumabe.handson01.domain.exception;

public class ServicoNotFoundException extends RuntimeException {

    public ServicoNotFoundException(String message) {
        super(message);
    }
    
}
