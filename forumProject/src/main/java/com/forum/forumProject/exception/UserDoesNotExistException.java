package com.forum.forumProject.exception;

@SuppressWarnings("serial")
public class UserDoesNotExistException extends RuntimeException 
{
	public static String message = "user does not exists !..please login";

	public UserDoesNotExistException() {

	}

	@SuppressWarnings("static-access")
	public UserDoesNotExistException(String message) {
		this.message = message;
	}
}