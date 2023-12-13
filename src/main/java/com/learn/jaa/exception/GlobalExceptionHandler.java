package com.learn.jaa.exception;

import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.security.access.*;
import org.springframework.security.authentication.*;
import org.springframework.web.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ProblemDetail> handleAccessDeniedException(AccessDeniedException e) {
        log.error("Came to AccessDeniedException in GlobalExceptionHandler", e);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.FORBIDDEN, e.getMessage());
        problemDetail.setTitle("Requested Resource is FORBIDDEN");
        return new ResponseEntity<>(problemDetail, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProblemDetail> handleException(Exception e) {
        log.error("Came to Exception in GlobalExceptionHandler", e);
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        problemDetail.setTitle("Server Side Error");
        return new ResponseEntity<>(problemDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(BadCredentialsException e) {
        log.error("Came to BadCredentialsException in GlobalExceptionHandler", e);
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TokenAuthorizationException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(TokenAuthorizationException e) {
        log.error("Came to TokenAuthorizationException in GlobalExceptionHandler", e);
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
