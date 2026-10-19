package com.mycompany.progwhatsapp;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * QuickChat: registration, login and the Part 2 message menu.
 */
public class ProgWhatsApp {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final ArrayList<Message> SENT_MESSAGES = new ArrayList<>();

    private static int totalMessagesToSend = 0;
    private static int messagesSent = 0;

    public static void main(String[] args) 
    {

  System.out.println("######################################");
             System.out.println(" Registration and Login Application");
        
          System.out.println("######################################");

      System.out.println("\n--- Registration ---");

            String firstName = readInput("Enter your first name: ");
      
            String lastName = readInput("Enter your last name: ");
     String username = readInput("Enter a username: ");
        
     String password = readInput("Enter a password: ");
      
           String cellPhone = readInput(
                "Enter your cellphone number, for example +27838968976: ");

        Login user = new Login(firstName, lastName, username, password, cellPhone);

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

    String loginUsername = readInput("Enter your username to login: ");
        String loginPassword = readInput("Enter your password to login: ");

    boolean loginSuccessful = user.loginUser(loginUsername, loginPassword);
       
    System.out.println(user.returnLoginStatus(loginSuccessful));

      
        if (!loginSuccessful) {
    System.out.println("Login failed. You cannot send messages.");
            return;
        }

        runQuickChat();
    }

    // ===================== QuickChat menu =====================

    private static void runQuickChat()
            
    {
    System.out.println("\nWelcome to QuickChat.");

        
    totalMessagesToSend = readNumber("How many messages do you wish to enter? ");

                    if (totalMessagesToSend <= 0) {
            System.out.println("No messages to send. Goodbye.");
            return;
        }

        int option = 0;
        while (option != 3) {
    System.out.println("\n1) Send Messages");
        System.out.println("2) Show recently sent messages");
                  System.out.println("3) Quit");
   System.out.print("Choose an option: ");

            option = readNumber("");

            if (option == 3) {
                System.out.println("Goodbye.");
                break;
            }

    switch (option) {
             case 1:
                    sendMessage();
                    break;
             case 2:
                    System.out.println("Coming Soon.");
                    break;
              default:
                    System.out.println("Invalid option, please enter 1, 2 or 3.");
     }
     }
      }

    private static void sendMessage() {
       
        if (messagesSent >= totalMessagesToSend) {
            System.out.println("You have already sent all "
                    + totalMessagesToSend + " message(s).");
            return;
        }

        System.out.println("You can still send "
                + (totalMessagesToSend - messagesSent) + " message(s).");

   String recipient = readInput("Enter recipient number: ");
           String text = readInput("Enter your message: ");

      Message message = new Message(messagesSent + 1, recipient, text);

        
        String lengthFeedback = message.checkMessageLength();
        System.out.println(lengthFeedback);
        if (!"Message ready to send.".equals(lengthFeedback)) {
            return;
        }

        messagesSent++;
        SENT_MESSAGES.add(message);

        System.out.println("\n--- Message sent ---");
        System.out.println(message.printMessageDetails());
    }

       /** Reads a whole number, or -1 if the user typed anything else. */


    private static String readInput(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }


    private static int readNumber(String prompt) {
        if (!prompt.isEmpty()) {
            System.out.print(prompt);
        }
        try {
            return Integer.parseInt(SCANNER.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
