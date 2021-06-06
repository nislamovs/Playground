package com.example.s3storage.domain.exceptions;

public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(String msg) {
        super(msg);
    }

    public FileNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}