/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progwhatsapp;

/**
 *
 * @author user
 */


import java.util.Random;

/**
 * Represents a single QuickChat message and holds the Part 2 string logic.
 */
public class Message {

          private static final int MAX_LENGTH = 250;
    private static final Random RANDOM = new Random();

  private final String messageID;
                    private final int messageNumber;
   
                 private final String recipient;
         private final String messageText;
   
               private final String messageHash;

    public Message(int messageNumber, String recipient, String messageText) {
                     
                        this.messageNumber = messageNumber;
    this.recipient = recipient;
          
            this.messageText = messageText;
      
        this.messageID = generateMessageID();
           this.messageHash = createMessageHash();
    }

    
    private static String generateMessageID() {
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            id.append(RANDOM.nextInt(10));
        }
        return id.toString();
    }

   
    public String checkMessageLength() {
        if (messageText.length() <= MAX_LENGTH) {
            return "Message ready to send.";
        }
        return "Message exceeds 250 characters by "
                + (messageText.length() - MAX_LENGTH) + "; please reduce the size.";
    }

    
    private String createMessageHash() {
        String[] words = messageText.trim().split("\\s+");

      String firstWord = words[0].replaceAll("[^A-Za-z]", "");
        String lastWord = words[words.length - 1].replaceAll("[^A-Za-z]", "");

        return messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord.toUpperCase() + lastWord.toUpperCase();
    }

      public String getMessageID() {
        return messageID;
    }

       public int getMessageNumber() {
        return messageNumber;
    }
       
      public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

                 public String getMessageHash() {
        return messageHash;
    }

    /**
     * The details shown to the user once a message has been sent.
     *
     * @return a formatted summary of this message
     */
    public String printMessageDetails() {
        return "Message ID   : " + messageID + "\n"
                + "Message Hash : " + messageHash + "\n"
                + "Recipient    : " + recipient + "\n"
                + "Message      : " + messageText;
    }
}

