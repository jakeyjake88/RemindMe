package com.nashss.se.remindme.exceptions;

/**
 * Exception to throw when a given task isn't found
 * in the database.
 */
public class TaskNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -1230785223023147290L;

    /**
     * Exception with no message or cause.
     */
    public TaskNotFoundException() {
        super();
    }


    /**
     * Exception with a message, but no cause.
     * @param message A descriptive message for this exception.
     */
    public TaskNotFoundException(String message) {
        super(message);
    }

    /**
     * Exception with no message, but with a cause.
     * @param cause The original throwable resulting in this exception.
     */
    public TaskNotFoundException(Throwable cause) {
        super(cause);
    }

    /**
     * Exception with message and cause.
     * @param message A descriptive message for this exception.
     * @param cause The original throwable resulting in this exception.
     */
    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
