package edu.acc.j2ee.momow1;

public class PasswordValidator {
    
    public static boolean isValid(PasswordBean bean) {
      
        if (!bean.getPassword1().matches("^[^'\"&<>]{6,15}$"))
            return false;
        if (!bean.getPassword2().equals(bean.getPassword1()))
            return false;
        return true;
    }
}
