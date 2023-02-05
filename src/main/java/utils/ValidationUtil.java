package utils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class ValidationUtil {

    public static final String EMAIL = "email";
    public static final String LASTNAME = "lastname";
    public static final String FIRSTNAME = "firstname";
    public static final String PASSWORD = "password";

    public static void validateEmail(String email, ActionSupport action) {
        String emailRegex = "^(.+)@(\\S+)$";
        if (email == null || StringUtils.isEmpty(email)) {
            action.addFieldError(EMAIL, "Email must not be empty");
            return;
        }
        if (!Pattern.matches(emailRegex, email)) {
            action.addFieldError(EMAIL, "Must be a valid email");
        }
    }

    public static void validatePassword(String password, ActionSupport action) {
        String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6}$";
        if (password == null || StringUtils.isEmpty(password)) {
            action.addFieldError(PASSWORD, "Password must not be empty");
            return;
        }
//        if (!Pattern.matches(passwordRegex, password)) {
//            action.addFieldError(PASSWORD, "Must be a valid Password");
//        }
    }

    public static void validNonEmptyString(String field, String str, ActionSupport action) {
        if (str == null || StringUtils.isEmpty(str)) {
            String fieldName = field.toUpperCase().charAt(0) + field.substring(1);
            action.addFieldError(field, fieldName + " must not be empty");
        }
    }
}
