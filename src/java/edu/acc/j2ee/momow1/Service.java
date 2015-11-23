package edu.acc.j2ee.momow1;

import java.util.Date;

public class Service {
    
    private int id;
    private String serviceGroup;
    private String serviceGroupDescription;
    private String serviceType;
    private String serviceTypeDescription;
    private int valueId;
    private Date expirationDate;
    private String createUserName;
    private Date createDate;
    private String changeUserName;
    private Date changeDate;

    public Service(){
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
     * @return the serviceGroup
     */
    public String getServiceGroup() {
        return serviceGroup;
    }

    /**
     * @param serviceGroup the serviceGroup to set
     */
    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
    }

    /**
     * @return the serviceGroupDescription
     */
    public String getServiceGroupDescription() {
        return serviceGroupDescription;
    }

    /**
     * @param serviceGroupDescription the serviceGroupDescription to set
     */
    public void setServiceGroupDescription(String serviceGroupDescription) {
        this.serviceGroupDescription = serviceGroupDescription;
    }

    /**
     * @return the serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @param serviceType the serviceType to set
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * @return the serviceTypeDescription
     */
    public String getServiceTypeDescription() {
        return serviceTypeDescription;
    }

    /**
     * @param serviceTypeDescription the serviceTypeDescription to set
     */
    public void setServiceTypeDescription(String serviceTypeDescription) {
        this.serviceTypeDescription = serviceTypeDescription;
    }

    /**
     * @return the valueId
     */
    public int getValueId() {
        return valueId;
    }

    /**
     * @param valueId the valueId to set
     */
    public void setValueId(int valueId) {
        this.valueId = valueId;
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
        return "Service [id=" + id + ", serviceGroup=" + serviceGroup
                + ", serviceGroupDescription=" + serviceGroupDescription 
                + ", serviceType=" + serviceType 
                + ", serviceTypeDescription="+ serviceTypeDescription 
                + ", valueId=" + valueId
                + ", expirationDate=" + expirationDate
                + ", createUserName=" + createUserName 
                + ", createDate=" + createDate
                + ", changeUserName=" + changeUserName
                + ", changeDate=" + changeDate + "]";
    }    
}
