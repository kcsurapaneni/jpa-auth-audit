package com.learn.jaa.exception;

import org.springframework.security.access.*;

/**
 * @author Krishna Chaitanya
 */
public class TokenAuthorizationException extends RuntimeException {
    public TokenAuthorizationException(String msg) {
        super(msg);
    }

    public TokenAuthorizationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
