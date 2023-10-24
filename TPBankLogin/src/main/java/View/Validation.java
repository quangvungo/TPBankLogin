/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Bank;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 *
 * @author conch
 */
public class Validation {
     public String checkAccountNumber(String accountNumber, ResourceBundle messages ) {
        String pattern = "\\d{10}";
        if (Pattern.matches(pattern, accountNumber)) {
            return null; // Valid account number
        } else {
            return messages.getString("account_number_invalid");
        }
    }

    public String checkPassword(String password, ResourceBundle messages ) {
        if (password.length() >= 8 && password.length() <= 31 && password.matches(".*[a-zA-Z].*") && password.matches(".*\\d.*")) {
            return null; // Valid password
        } else {
            return messages.getString("password_invalid");
        }
    }
      public String checkCaptcha(String captchaInput, String captchaGenerate, ResourceBundle messages ) {
          if (captchaInput.length() == 1 && captchaGenerate.contains(captchaInput)) {
        return null; // Valid captcha
    } else {
        return messages.getString("captcha_invalid");
    }
    }
}
