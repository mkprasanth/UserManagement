package com.uxpsystems.assignment.service;


public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6052302746073903917L;

	public UserNotFoundException(String message) {
		super(message);
	}

}
