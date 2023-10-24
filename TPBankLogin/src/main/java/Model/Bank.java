/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ResourceBundle;

/**
 *
 * @author conch
 */
public class Bank {
    private ResourceBundle messages;

    public ResourceBundle getMessages() {
        return messages;
    }

    public void setMessages(ResourceBundle messages) {
        this.messages = messages;
    }

    public Bank(ResourceBundle messages) {
        this.messages = messages;
    } 
}
