package edu.acc.j2ee.momow1;

public class UsernameBean implements java.io.Serializable {
    private String mode;
    private String userName;
    
    public UsernameBean() {}
    
    public UsernameBean(String mode, String userName) {
        this.mode = mode;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * @return the mode
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode the mode to set
     */
    public void setMode(String mode) {
        this.mode = mode;
    }
}
