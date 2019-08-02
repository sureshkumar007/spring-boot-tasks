package com.stackroute.trackservice.exceptions;

public class TrackAlreadyExistsException
{
    private String message;

    public TrackAlreadyExistsException() {
    }

    public TrackAlreadyExistsException(String message) {
        this.message = message;
    }
}
