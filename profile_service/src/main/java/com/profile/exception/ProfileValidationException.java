package com.profile.exception;

public class ProfileValidationException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public String message;

    public ProfileValidationException() {
        super();
        message = "Id already Existing";
    }

    public String getMessage() {

        return message;
    }

}
