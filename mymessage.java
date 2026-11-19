package mymessages;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        MessageManager manager = new MessageManager();
        Scanner scanner = new Scanner(System.in);
        
        manager.loadMessagesFromJson("messages.json"); 

        boolean running = true;
        while (running) {
            System.out.println("\n--- Message Menu ---");
            System.out.println("1. Display Sender and Recipient");
            System.out.println("2. Display Longest Message");
            System.out.println("3. Search by Message ID");
            System.out.println("4. Search by Recipient");
            System.out.println("5. Delete Message by Hash");
            System.out.println("6. Display Full Report");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    manager.displayStoredMessages();
                    break;
                case 2:
                    System.out.println("Longest Message: " + manager.getLongestMessage());
                    break;
                case 3:
                    System.out.print("Enter Message ID: ");
                    String id = scanner.nextLine();
                    System.out.println(manager.searchByMessageId(id));
                    break;
                case 4:
                    System.out.print("Enter Recipient Number: ");
                    String recip = scanner.nextLine();
                    ArrayList<String> foundMsgs = manager.searchByRecipient(recip);
                    if (foundMsgs.isEmpty()) {
                        System.out.println("No messages found for this recipient.");
                    } else {
                        for (String m : foundMsgs) {
                            System.out.println("- " + m);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter Message Hash to delete: ");
                    String hash = scanner.nextLine();
                    System.out.println(manager.deleteMessageByHash(hash));
                    break;
                case 6:
                    manager.displayReport();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
