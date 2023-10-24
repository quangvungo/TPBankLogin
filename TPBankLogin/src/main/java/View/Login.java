/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Bank;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author conch
 */
public class Login extends Menu<String> {

    public static Scanner sc = new Scanner(System.in);
    static String[] mc = {"Tiếng Việt", "English", "Exit / Thoát"};
    private Bank bank; // A reference to the Bank class for managing language.
    private Validation validation; // A class for validation.
    FileInputStream vn = new FileInputStream(System.getProperty("user.dir") + File.separator + "Vn.properties");
    FileInputStream en = new FileInputStream(System.getProperty("user.dir") + File.separator + "En.properties");

    public Login() throws FileNotFoundException {
        super("MENU", mc);
         bank = new Bank(null); // You can pass null or initialize with default ResourceBundle.
        validation = new Validation();
    }

    @Override
    public void execute(String n) {
        switch (n) {
            case "1" -> {
                // Switch to Vietnamese language and perform login.
                ResourceBundle viMessages = null;
                try {
                    viMessages = new PropertyResourceBundle(vn);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                bank.setMessages(viMessages); // Set the messages for the Bank class.
                performLogin();
            }

            case "2" -> {
                // Switch to English language and perform login.
                ResourceBundle enMessages = null;
                try {
                    enMessages = new PropertyResourceBundle(en);
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                bank.setMessages(enMessages); // Set the messages for the Bank class.
                performLogin();
            }

            case "3" ->
                System.exit(0);
            default ->
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

   private void performLogin() {
    String accountNumber = "";
    String password = "";
    String captcha = generateCaptcha();

    while (true) {
        System.out.println(bank.getMessages().getString("enter_account_number"));
        accountNumber = sc.nextLine();
        String accountNumberErrorMessage = validation.checkAccountNumber(accountNumber, bank.getMessages());

        if (accountNumberErrorMessage != null) {
            System.out.println(accountNumberErrorMessage);
            continue; // Continue to the next iteration to re-enter the account number.
        }

        break; // Exit the loop when a valid account number is provided.
    }

    while (true) {
        System.out.println(bank.getMessages().getString("enter_password"));
        password = sc.nextLine();
        String passwordErrorMessage = validation.checkPassword(password, bank.getMessages());

        if (passwordErrorMessage != null) {
            System.out.println(passwordErrorMessage);
            continue; // Continue to the next iteration to re-enter the password.
        }

        break; // Exit the loop when a valid password is provided.
    }

    System.out.println("Captcha: " + captcha);

    while (true) {
        System.out.println(bank.getMessages().getString("enter_captcha"));
        String captchaInput = sc.nextLine();
        String captchaErrorMessage = validation.checkCaptcha(captchaInput, captcha, bank.getMessages());

        if (captchaErrorMessage != null) {
            System.out.println(captchaErrorMessage);
            continue; // Continue to the next iteration to re-enter the captcha.
        }

        break; // Exit the loop when a valid captcha is provided.
    }
}

    private String generateCaptcha() {
        Random random = new Random();
        char[] captcha = new char[6];
        for (int i = 0; i < 6; i++) {
            captcha[i] = (char) (random.nextInt(26) + 'A');
        }
        return new String(captcha);
    }

}
