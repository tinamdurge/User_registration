package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // UC1: validating firstname
        String firstNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        while (!firstName.matches(firstNameRegex)) {
            System.out.println("Please enter a valid response.");
            System.out.print("Enter first name: ");
            firstName = sc.nextLine();
        }

        // UC2: validating lastname
        String lastNameRegex = "^[A-Z][a-zA-Z]{2,}$";
        System.out.print("\nEnter last name: ");
        String lastName = sc.nextLine();
        while (!lastName.matches(lastNameRegex)) {
            System.out.println("Please enter a valid response.");
            System.out.print("Enter last name: ");
            lastName = sc.nextLine();
        }

        // UC3: validating email address
        String emailRegex = "^+[a-zA-Z0-9$&%_+-]+(\\.[a-zA-Z0-9$&%_+-]+)?@[a-zA-Z0-9-]+(\\.[a-zA-Z]{2,}){1,2}+$";
        System.out.print("\nEnter email: ");
        String email = sc.nextLine();
        while (!email.matches(emailRegex)) {
            System.out.println("Please enter a valid response.");
            System.out.print("\nEnter email: ");
            email = sc.nextLine();
        }

        // Uc4: validating phone number
        String phoneRegex = "^[0-9]{1,4} [0-9]{5,15}$";
        System.out.print("\nEnter phone number: ");
        String phone = sc.nextLine();
        while (!phone.matches(phoneRegex)) {
            System.out.println("Please enter a valid response.");
            System.out.print("\nEnter phone number: ");
            phone = sc.nextLine();
        }

        // UC5: validating password (8 chars)
        // UC6: validating password (uppercase)
        // UC7: validating password (digit)
        // UC8: validating password (special char)
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$";
        System.out.print("\nEnter password: ");
        String password = sc.nextLine();
        while (!password.matches(passwordRegex)) {
            System.out.println("Please enter a valid response.");
            System.out.print("\nEnter password: ");
            password = sc.nextLine();
        }

        sc.close();
    }
}