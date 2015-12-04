package edu.acc.j2ee.momow1;

public class RegistrationValidator {
    
    public static boolean isValid(RegistrationBean bean) {
        if (!bean.getUserName().matches("^\\w{4,12}$"))
            return false;
        
        if(!bean.getMode().equals("edit")){
            if (!bean.getPassword1().matches("^[^'\"&<>]{6,15}$"))
                return false;
            if (!bean.getPassword2().equals(bean.getPassword1()))
                return false;
        }
        if (!bean.getPhone().matches("\\d{3}-\\d{3}-\\d{4}"))
            return false;
        if (!bean.getFirstName().matches("^[A-Za-z. -]{1,20}$"))
            return false;
        if (!bean.getLastName().matches("^[A-Za-z -']{1,30}$"))
            return false;
        if (!bean.getCity().matches("^[A-Za-z -']{1,40}$"))
            return false;
        if (!bean.getEmail().matches("^[\\w-.]+@[\\w-.]+$"))
            return false;
        if (!bean.getZipCode().matches("^\\d{5}(-\\d{4})?$"))
            return false;
        return true;
    }
}
