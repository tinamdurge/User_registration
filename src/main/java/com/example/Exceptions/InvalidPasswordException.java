package com.example.Exceptions;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super("Password is invalid");
    }
}
