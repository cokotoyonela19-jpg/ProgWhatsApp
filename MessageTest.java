/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
package com.mycompany.progwhatsapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit tests for the Message class.
 */
public class MessageTest {

    @Test
    public void messageIDShouldBeTenDigits() {
        Message message = new Message(1, "+27707421532", "Hello there");

        assertEquals(10, message.getMessageID().length());
        assertTrue(message.getMessageID().matches("\\d{10}"));
    }

    @Test
    public void shortMessageShouldBeReadyToSend() {
        Message message = new Message(1, "+27707421532", "Hi did you get my message?");

        assertEquals("Message ready to send.", message.checkMessageLength());
    }

    @Test
    public void longMessageShouldReportExcessCharacters() {
        String longText = "a".repeat(260);
        Message message = new Message(1, "+27707421532", longText);

        assertEquals(
                "Message exceeds 250 characters by 10; please reduce the size.",
                message.checkMessageLength()
        );
    }

    @Test
    public void messageHashShouldFollowRequiredFormat() {
        Message message = new Message(0, "+27707421532", "Hi tonight");
        String id = message.getMessageID();

        assertEquals(
                id.substring(0, 2) + ":0:HITONIGHT",
                message.getMessageHash()
        );
    }

    @Test
    public void messageHashShouldUseTheMessageNumber() {
        Message message = new Message(2, "+27707421532", "Hello World");
        String id = message.getMessageID();

        assertEquals(
                id.substring(0, 2) + ":2:HELLOWORLD",
                message.getMessageHash()
        );
    }
}
