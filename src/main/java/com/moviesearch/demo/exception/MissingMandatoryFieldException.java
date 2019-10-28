package com.moviesearch.demo.exception;

public class MissingMandatoryFieldException extends RuntimeException {

    private static final long serialVersionUID = 4004018412861484948L;

    public MissingMandatoryFieldException(String message) {
        super(message);
    }

    public MissingMandatoryFieldException(String message, Throwable cause) {
        super(message, cause);
    }
}
