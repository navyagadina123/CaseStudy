package com.profile.exception;

public class ProfileAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProfileAlreadyExistException(String msg) {
		super(msg);
	}

}
