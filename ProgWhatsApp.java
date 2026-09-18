/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progwhatsapp;

/**
 *
 * @author user
 */


import java.util.Scanner;

public class ProgWhatsApp {

   
public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

     System.out.println("######################################");
        
     System.out.println(" Registration and Login Application");
            System.out.println("######################################");

            System.out.println("\n--- Registration ---");

            String firstName = readInput(scanner, "Enter your first name: ");
            String lastName = readInput(scanner, "Enter your last name: ");
            String username = readInput(scanner, "Enter a username: ");
            String password = readInput(scanner, "Enter a password: ");
            String cellPhone = readInput(scanner,
                    "Enter your cellphone number, for example +27838968976: ");

            Login user = new Login(
                  firstName,
                    
                   lastName,
                    
                    username,
                    
                    password,
                    
                    cellPhone
            );

            String registrationMessage = user.registerUser();

            if (user.isRegistered()) {
     System.out.println("\nUsername successfully captured.");
           System.out.println("Password successfully captured.");
                System.out.println("Cell phone number successfully added.");
            }

            System.out.println(registrationMessage);

            if (!user.isRegistered()) {
                System.out.println("\nRegistration was unsuccessful.");
                System.out.println("Please correct the details and try again.");
                return;
            }

            System.out.println("\n--- Login ---");

            String loginUsername = readInput(scanner,
                    "Enter your username to login: ");

            String loginPassword = readInput(scanner,
                    "Enter your password to login: ");

            boolean loginSuccessful
                    = user.loginUser(loginUsername, loginPassword);

            System.out.println(user.returnLoginStatus(loginSuccessful));
        }
    }

    /**
     * Reads a line of input from the user.
     *
     * @param scanner the Scanner object
     * @param message the prompt displayed to the user
     * @return the input entered by the user
     */
    private static String readInput(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}