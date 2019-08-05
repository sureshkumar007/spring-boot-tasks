package com.stackroute.trackservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseEntity<Object> trackNotfound(final TrackNotFoundException ex)
    {
       return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity<Object> trackAlready(final TrackAlreadyExistsException ex1)
    {
        return new ResponseEntity<>(ex1.getMessage(),HttpStatus.OK);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> Expection(final Exception ex3)
    {
        return new ResponseEntity<>(ex3.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
