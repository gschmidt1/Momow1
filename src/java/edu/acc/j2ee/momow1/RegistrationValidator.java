package edu.acc.j2ee.momow1;

import org.apache.commons.lang3.StringUtils;

public class RegistrationValidator {
    
    public static boolean isValid(RegistrationBean bean) {
      //invoke this when "create"
      //username and password go through another validator
      if(!bean.getMode().equals("edit")){
            if (!bean.getUserName().matches("^\\w{4,12}$"))
                return false;
            if (!bean.getPassword1().matches("^[^'\"&<>]{6,15}$"))
                return false;
            if (!bean.getPassword2().equals(bean.getPassword1()))
                return false;
        }
        if (!bean.getPhone().matches("\\d{3}-\\d{3}-\\d{4}"))
            return false;
        if (!bean.getFirstName().matches("^[A-Za-z. -]{1,20}$") || StringUtils.isBlank(bean.getFirstName()))
            return false;
        if (!bean.getLastName().matches("^[A-Za-z -']{1,30}$") || StringUtils.isBlank(bean.getLastName()))
            return false;
        if (!bean.getCity().matches("^[A-Za-z -']{1,40}$") || StringUtils.isBlank(bean.getCity()))
            return false;
        if (!bean.getEmail().matches("^[\\w-.]+@[\\w-.]+$"))
            return false;
        if (!bean.getZipCode().matches("^\\d{5}(-\\d{4})?$"))
            return false; 
        if (StringUtils.isBlank(bean.getAddress()))
            return false;
        return true;
    }
}
