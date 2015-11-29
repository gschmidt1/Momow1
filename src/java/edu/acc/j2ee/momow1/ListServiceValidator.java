package edu.acc.j2ee.momow1;

import java.util.List;

public class ListServiceValidator {
    
    public static boolean validateArrayListIsEmpty(List<ServiceOrder> listServices){
        
        if(listServices.isEmpty()){
            return false;
        }
        return true;
    }
}
