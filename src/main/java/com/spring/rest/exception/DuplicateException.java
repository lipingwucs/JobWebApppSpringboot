package com.spring.rest.exception;

public class DuplicateException extends RuntimeException {

    public DuplicateException() {
        super();
    }

    public DuplicateException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public DuplicateException(final String message) {
        super(message);
    }

    public DuplicateException(final Throwable cause) {
        super(cause);
    }
}