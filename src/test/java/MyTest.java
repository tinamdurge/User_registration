import static org.junit.jupiter.api.Assertions.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.example.Validator;
import com.example.Exceptions.InvalidEmailException;
import com.example.Exceptions.InvalidFirstNameException;
import com.example.Exceptions.InvalidPasswordException;
import com.example.Exceptions.InvalidPhoneNumberException;

public class MyTest {

    // UC11: testing with all given email ids
    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc-100@yahoo.com",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc-100@abc.net",
            "abc.100@abc.com.au",
            "abc@1.com",
            "abc@gmail.com.com",
            "abc+100@gmail.com",
    })
    public void testEmailHappy(String email) {
        String emailRegex = "^+[a-zA-Z0-9$&%_+-]+(\\.[a-zA-Z0-9$&%_+-]+)?@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,}){1,2}+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        assertTrue(matcher.matches());
    }

    // UC12: handle custom exceptions for sad test cases
    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abc@.com.my",
            "abc123@gmail.a",
            "abc123@.com",
            "abc123@.com.com",
            ".abc@abc.com",
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com",
            "abc.@gmail.com",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au"
    })
    public void testEmailSad(String email) throws InvalidEmailException {
        try {
            Validator.validateEmail(email);
            fail("Expected InvalidEmailException");
        } catch (InvalidEmailException exception) {
            assertEquals("Email is invalid", exception.getMessage());
        }
    }

    // UC10: testing all other fields
    @ParameterizedTest
    @ValueSource(strings = { "Tinam", "Abc" })
    public void testNameHappy(String name) {
        String nameRegex = "^[A-Z][a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(nameRegex);
        Matcher matcher = pattern.matcher(name);
        assertTrue(matcher.matches());
    }

    // UC12: handle custom exceptions for sad test cases
    @ParameterizedTest
    @ValueSource(strings = { "tinam", "ab", "aB", "abc" })
    public void testNameSad(String name) throws InvalidFirstNameException {
        try {
            Validator.validateFirstName(name);
            fail("Expected InvalidFirstNameException");
        } catch (InvalidFirstNameException exception) {
            assertEquals("First name is invalid", exception.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "91 9313402393", "99 8412612" })
    public void testPhoneNumberHappy(String phone) {
        String phoneRegex = "^[0-9]{1,4} [0-9]{5,15}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phone);
        assertTrue(matcher.matches());
    }

    // UC12: handle custom exceptions for sad test cases
    @ParameterizedTest
    @ValueSource(strings = { "+91 9313402393", "9313402393", "93134 02393", "919313402393" })
    public void testPhoneNumberSad(String phone) throws InvalidPhoneNumberException {
        try {
            Validator.validatePhoneNumber(phone);
            fail("Expected InvalidPhoneNumberException");
        } catch (InvalidPhoneNumberException exception) {
            assertEquals("Phone number is invalid", exception.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = { "HelloWorld@123", "IamPassword#05" })
    public void testPasswordHappy(String pasword) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(pasword);
        assertTrue(matcher.matches());
    }

    // UC12: handle custom exceptions for sad test cases
    @ParameterizedTest
    @ValueSource(strings = { "Hello", "helloworld", "HelloWorld", "HelloWorld123" })
    public void testPasswordSad(String pasword) throws InvalidPasswordException {
        try {
            Validator.validatePassword(pasword);
            fail("Expected InvalidPasswordException");
        } catch (InvalidPasswordException exception) {
            assertEquals("Password is invalid", exception.getMessage());
        }
    }
}
