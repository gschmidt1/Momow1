
package edu.acc.j2ee.momow1;

import java.util.Date;

public class ServiceValidator {
    
    public static boolean validateService(Date needByDate, String specialInstructions, String[] arraySelectedServices ) {
       
        if(!validateDate(needByDate)){
            return false;
        }
       if(!validateSpecialInstructions(specialInstructions)){
            return false;
        }
       if(!validateSelectedServices(arraySelectedServices)){
            return false;
        }
        return true;   
    }
    public static boolean validateSpecialInstructions(String specialInstructions){
        
        String checkString = specialInstructions;
        
        if (checkString.indexOf("<") > 0) {
            return false;
        }
        if (checkString.indexOf(">") > 0) {
            return false;
        }
        if (checkString.indexOf("'") > 0) {
            return false;
        }
        if (checkString.indexOf("\"") > 0) {
            return false;
        }
        if (checkString.indexOf("&") > 0) {
            return false;
        }
        if (checkString.length() == 0) {
            return false;
        }
        return true;
    }
    
    public static boolean validateDate(Date needByDate){
        
        if (needByDate == null){
            return false;
        }
        return true;
    }
    
    public static boolean validateSelectedServices(String[] arraySelectedServices){
        
        if(arraySelectedServices == null){
            return false;
            
        }
        if(arraySelectedServices.length == 0){
            return false;
        }
        return true;
    }
}
