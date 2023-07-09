package br.com.irley.studyfc3ci.domain;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String mensagem) {
        super(mensagem);
    }

    public UserNotFoundException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}