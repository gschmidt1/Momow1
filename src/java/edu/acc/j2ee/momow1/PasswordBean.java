package edu.acc.j2ee.momow1;

public class PasswordBean implements java.io.Serializable {
     
    private String password1;
    private String password2;
    
    
    public PasswordBean() {}
    
    public PasswordBean(String password1, String password2) {
         
        this.password1 = password1;
        this.password2 = password2;
    }
    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
