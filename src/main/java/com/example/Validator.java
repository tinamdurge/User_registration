package com.example;

import com.example.Exceptions.InvalidEmailException;
import com.example.Exceptions.InvalidFirstNameException;
import com.example.Exceptions.InvalidLastNameException;
import com.example.Exceptions.InvalidPasswordException;
import com.example.Exceptions.InvalidPhoneNumberException;

// UC12: creating validators to throw custom exceptions
public class Validator {
    public static boolean validateFirstName(String firstname) throws InvalidFirstNameException {
        String firstNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        if (!firstname.matches(firstNameRegex)) {
            throw new InvalidFirstNameException();
        }
        return true;
    }

    public static boolean validateLastName(String lastname) throws InvalidLastNameException {
        String lastNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        if (!lastname.matches(lastNameRegex)) {
            throw new InvalidLastNameException();
        }
        return true;
    }

    public static boolean validateEmail(String email) throws InvalidEmailException {
        String emailRegex = "^+[a-zA-Z0-9$&%_+-]+(\\.[a-zA-Z0-9$&%_+-]+)?@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,}){1,2}+$";
        if (!email.matches(emailRegex)) {
            throw new InvalidEmailException();
        }
        return true;
    }

    public static boolean validatePhoneNumber(String phone) throws InvalidPhoneNumberException {
        String phoneRegex = "^[0-9]{1,4} [0-9]{5,15}$";
        if (!phone.matches(phoneRegex)) {
            throw new InvalidPhoneNumberException();
        }
        return true;
    }

    public static boolean validatePassword(String password) throws InvalidPasswordException {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$";
        if (!password.matches(passwordRegex)) {
            throw new InvalidPasswordException();
        }
        return true;
    }
}
