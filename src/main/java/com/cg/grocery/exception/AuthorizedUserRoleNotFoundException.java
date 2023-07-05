package com.cg.grocery.exception;


@SuppressWarnings("serial")
public class AuthorizedUserRoleNotFoundException extends RuntimeException {
    public AuthorizedUserRoleNotFoundException (String msg) {
        super(msg);
    }

}
