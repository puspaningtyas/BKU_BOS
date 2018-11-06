package com.project.bku.exception;

public class FileStorageException extends RuntimeException {
	
	private static final long serialVersionUID = -4323676463294852241L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
