package edu.acc.j2ee.momow1;

public class Login implements java.io.Serializable {
    private String userName;
    private String password;
    
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    public Login() {}

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
}
