package com.nashss.se.remindme.exceptions;

public class TaskNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -1230785223023147290L;

    public TaskNotFoundException() {
        super();
    }

    public TaskNotFoundException(String message) {
        super(message);
    }

    public TaskNotFoundException(Throwable cause) {
        super(cause);
    }

    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
