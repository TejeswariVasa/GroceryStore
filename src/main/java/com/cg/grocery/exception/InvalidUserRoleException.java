package com.cg.grocery.exception;
@SuppressWarnings("serial")


public class InvalidUserRoleException extends RuntimeException {
	public InvalidUserRoleException(String msg) {
		super(msg);
	}

}
