  
package edu.acc.j2ee.momow1;

public class GenericUtilities {
    
    static java.sql.Timestamp getCurrentTimeStamp() {        
      return new java.sql.Timestamp(System.currentTimeMillis());
    }
}
