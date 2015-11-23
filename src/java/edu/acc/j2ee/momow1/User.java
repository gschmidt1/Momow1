package edu.acc.j2ee.momow1;

import java.util.Date;

public class User implements java.io.Serializable {

    private int id;
    private int memberId;
    private String userName;
    private String password;
    private Date expirationDate;
    private String createUserName;
    private Date createDate;
    private String changeUserName;
    private Date changeDate;

    public User(){
    }
    
    //TEST constructor
    public User(int id, int memberId, String userName){
        this.id = id;
        this.memberId = memberId;
        this.userName =  userName;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the memberId
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

        /**
     * @return the expirationDate
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * @param expirationDate the expirationDate to set
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    
    /**
     * @return the createUserName
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * @param createUserName the createUserName to set
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the changeUserName
     */
    public String getChangeUserName() {
        return changeUserName;
    }

    /**
     * @param changeUserName the changeUserName to set
     */
    public void setChangeUserName(String changeUserName) {
        this.changeUserName = changeUserName;
    }

    /**
     * @return the changeDate
     */
    public Date getChangeDate() {
        return changeDate;
    }

    /**
     * @param changeDate the changeDate to set
     */
    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
    
    @Override
    public String toString() {
        return "User [id=" + getId() + ", memberId=" + getMemberId()
                + ", userName=" + userName
                + ", password=" + password               
                + ", expirationDate=" + expirationDate
                + ", createUserName=" + createUserName 
                + ", createDate=" + createDate
                + ", changeUserName=" + changeUserName
                + ", changeDate=" + changeDate + "]";
    }    


 
    
}
