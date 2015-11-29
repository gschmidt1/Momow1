package edu.acc.j2ee.momow1;

public class LoginValidator {
    public static boolean validate(Login login) {
        if (!login.getUserName().matches("^\\w{4,12}$")) {
            return false;
        }
        if (!login.getPassword().matches("^[^'\"&<>]{6,15}$")) {
            return false;
        }
        return true;
    }
}
