package com.mycompany.messageproject; // Make sure this matches your package!

import org.json.JSONObject;

public class Message {
    private String recipient;
    private String messageText;
    private String flag;
    private String messageHash;
    private String messageId;

    // Constructor for creating a new Message manually
    public Message(String recipient, String messageText, String flag) {
        this.recipient = recipient;
        this.messageText = messageText;
        this.flag = flag;
        this.messageId = generateMessageId();
        this.messageHash = createMessageHash();
    }

    // Constructor for reading a Message from the JSON file
    public Message(JSONObject obj) {
        this.recipient = obj.getString("Recipient");
        this.messageText = obj.getString("Message");
        this.flag = obj.getString("Flag");
        
        // If the JSON doesn't have an ID or Hash, generate them
        this.messageId = obj.optString("MessageID", generateMessageId());
        this.messageHash = obj.optString("MessageHash", createMessageHash());
    }

    // Generates a random 9-digit ID
    private String generateMessageId() {
        return String.valueOf((int)(Math.random() * 900000000) + 100000000);
    }

    // Creates the hash based on the first two and last two letters of the message
    private String createMessageHash() {
        String firstTwo = messageText.length() >= 2 ? messageText.substring(0, 2).toUpperCase() : messageText.toUpperCase();
        String lastTwo = messageText.length() >= 2 ? messageText.substring(messageText.length() - 2).toUpperCase() : messageText.toUpperCase();
        return firstTwo + ":" + messageId.substring(0, 2) + ":" + lastTwo;
    }

    // Getters used by MessageManager and Tests
    public String getRecipient() { 
        return recipient; 
    }
    
    public String getMessageText() { 
        return messageText; 
    }
    
    public String getFlag() { 
        return flag; 
    }
    
    public String getMessageHash() { 
        return messageHash; 
    }
    
    public String getMessageId() { 
        return messageId; 
    }
}
