
package edu.acc.j2ee.momow1;

import java.util.Date;

public class Member {

    private int id;
    private int userId;
    private Date joinDate;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String st;
    private String zip;
    private String phone;
    private boolean textFlag;
    private String email;
    private Date expirationDate;
    private String createUserName;
    private Date createDate;
    private String changeUserName;
    private Date changeDate;

    public Member(){
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
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the joinDate
     */
    public Date getJoinDate() {
        return joinDate;
    }

    /**
     * @param joinDate the joinDate to set
     */
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the st
     */
    public String getSt() {
        return st;
    }

    /**
     * @param st the st to set
     */
    public void setSt(String st) {
        this.st = st;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the textFlag
     */
    public boolean isTextFlag() {
        return textFlag;
    }

    /**
     * @param textFlag the textFlag to set
     */
    public void setTextFlag(boolean textFlag) {
        this.textFlag = textFlag;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
        return "Member [id=" + id + ", userId=" + userId
                + ", joinDate=" + joinDate + ", firstName=" + firstName + ", lastName="
                + lastName + ", address=" + address + ", city=" + city 
                + ", state=" + st + ", zip=" + zip + ", phone=" + phone 
                + ", textFlag" + textFlag + ", email=" + email
                + ", expirationDate=" + expirationDate
                + ", createUserName=" + createUserName 
                + ", createDate=" + createDate
                + ", changeUserName=" + changeUserName
                + ", changeDate=" + changeDate + "]";
    }    
}
