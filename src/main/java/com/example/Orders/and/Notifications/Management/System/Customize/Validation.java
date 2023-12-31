package com.example.Orders.and.Notifications.Management.System.Customize;

import com.example.Orders.and.Notifications.Management.System.Users.Language;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class Validation {
    private final String EmailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private final String PasswordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{8,}$"
            ;
    private final Pattern EmailPattern = Pattern.compile(EmailRegex);
    private final Pattern PasswordPattern = Pattern.compile(PasswordRegex);

    public boolean isValidEmail(String email) {
        Matcher matcher = EmailPattern.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = PasswordPattern.matcher(password);
        return matcher.matches();
    }
    public boolean isValidLanguage(Language language) {
        for (Language lang : Language.values()) {
            if (lang.equals(language)) {
                return true;
            }
        }return false;
    }
}