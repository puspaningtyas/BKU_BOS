package com.project.bku.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnaouthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UnaouthorizedException(String message) {
        super(message);
    }

    public UnaouthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}