package com.spring.rest.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.spring.rest.exception.DuplicateException;
import com.spring.rest.exception.IdMismatchException;
import com.spring.rest.exception.NotFoundException;


// refs https://github.com/eugenp/tutorials/tree/master/spring-boot-modules/spring-boot-bootstrap
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    public RestExceptionHandler() {
        super();
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Resource not found: "  + ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
    
    @ExceptionHandler(DuplicateException.class)
    protected ResponseEntity<Object> handleDuplicate(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, "Resource already exist: " + ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({
      IdMismatchException.class
    })
    public ResponseEntity<Object> handleBadRequest(Exception ex, WebRequest request) {
        return handleExceptionInternal(ex, ex
          .getLocalizedMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    
}
