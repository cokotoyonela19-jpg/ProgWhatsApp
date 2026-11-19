package com.mycompany.messageproject; // Make sure this matches your project package!

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class MessageManagerTest {

    private MessageManager manager;
  
    public void setUp() {
        manager = new MessageManager();
        
        // Injecting the exact test data from your assignment images
        injectTestData(manager, "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        injectTestData(manager, "+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        injectTestData(manager, "0838884567", "It is dinner time !", "Sent");
        injectTestData(manager, "+27838884567", "Ok, I am leaving without you.", "Stored");
    }

    // Helper method to populate the arrays for testing
    private void injectTestData(MessageManager m, String recip, String msg, String flag) {
        try {
            java.lang.reflect.Field countField = MessageManager.class.getDeclaredField("messageCount");
            countField.setAccessible(true);
            int count = (int) countField.get(m);

            java.lang.reflect.Field recipField = MessageManager.class.getDeclaredField("recipients");
            recipField.setAccessible(true);
            String[] recips = (String[]) recipField.get(m);
            recips[count] = recip;

            java.lang.reflect.Field msgField = MessageManager.class.getDeclaredField("messages");
            msgField.setAccessible(true);
            String[] msgs = (String[]) msgField.get(m);
            msgs[count] = msg;

            java.lang.reflect.Field flagField = MessageManager.class.getDeclaredField("flags");
            flagField.setAccessible(true);
            String[] flags = (String[]) flagField.get(m);
            flags[count] = flag;

            // Mocking Hash and ID based on index for testing
            java.lang.reflect.Field hashField = MessageManager.class.getDeclaredField("messageHashes");
            hashField.setAccessible(true);
            String[] hashes = (String[]) hashField.get(m);
            hashes[count] = "HASH" + count;

            java.lang.reflect.Field idField = MessageManager.class.getDeclaredField("messageIds");
            idField.setAccessible(true);
            String[] ids = (String[]) idField.get(m);
            ids[count] = String.valueOf(count + 1);

            countField.set(m, count + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void testGetLongestMessage() {
        String expected = "Where are you? You are late! I have asked you to be on time.";
        String actual = manager.getLongestMessage();
        assertEquals(expected, actual, "The system should return the longest stored message.");
    }

    public void testSearchByRecipient() {
        ArrayList<String> results = manager.searchByRecipient("+27838884567");
      
        assertEquals(2, results.size());
        assertEquals("Where are you? You are late! I have asked you to be on time.", results.get(0));
        assertEquals("Ok, I am leaving without you.", results.get(1));
    }

    public void testSearchByMessageId() {
        // In our setup, message 3 (index 2) is "It is dinner time !" with ID "3"
        String expected = "Recipient: 0838884567 | Message: It is dinner time !";
        String actual = manager.searchByMessageId("3");
        assertEquals(expected, actual);
    }

    public void testDeleteMessageByHash() {
        String expectedResponse = "Message: \"Where are you? You are late! I have asked you to be on time.\" successfully deleted.";
        String actualResponse = manager.deleteMessageByHash("HASH0");
        
        assertEquals(expectedResponse, actualResponse);
        
        assertEquals("Ok, I am leaving without you.", manager.getLongestMessage());
    }
}
