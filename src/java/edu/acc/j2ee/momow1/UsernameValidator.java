package edu.acc.j2ee.momow1;

public class UsernameValidator {
    
    public static boolean isValid(UsernameBean bean) {
        if (!bean.getUserName().matches("^\\w{4,12}$"))
            return false;
        return true;
    }
}
