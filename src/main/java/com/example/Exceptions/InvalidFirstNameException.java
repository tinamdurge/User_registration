package com.example.Exceptions;

public class InvalidFirstNameException extends Exception {
    public InvalidFirstNameException() {
        super("First name is invalid");
    }
}
