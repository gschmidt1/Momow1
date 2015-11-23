package edu.acc.j2ee.momow1;

import java.util.Date;

public class ServiceOrder {
    
    private int id;
    private int memberId;
    private String serviceGroup;
    private String serviceTypeMow;
    private String serviceTypeEdge;
    private String serviceTypeRake;
    private String instruction;
    private Date needByDate;
    private Date scheduledDate;
    private Boolean completedFlag;
    private Date completedDate;
    private Date expirationDate;
    private String createUserName;
    private Date createDate;
    private String changeUserName;
    private Date changeDate;
    
    public ServiceOrder(){
    }
    
    //constructor for listServices
    public ServiceOrder(String sg, Date nbd, Date sd, Boolean cf, int id){
        serviceGroup = sg;
        needByDate = nbd;
        scheduledDate = sd;
        completedFlag = cf;
        this.id = id;
    }
    
    //constructor for createService
    public ServiceOrder (int memberId, String serviceGroup, Date needByDate, String specialInstructions, String[] arraySelectedServices){
        id = memberId;
        this.serviceGroup = serviceGroup;
        this.needByDate = needByDate;
        instruction = specialInstructions;
        if(arraySelectedServices.length == 1){
            serviceTypeMow = arraySelectedServices[0];
        }
        if(arraySelectedServices.length == 2){
            serviceTypeMow = arraySelectedServices[0];
            serviceTypeEdge = arraySelectedServices[1];
        }
        if(arraySelectedServices.length == 3){
            serviceTypeMow = arraySelectedServices[0];
            serviceTypeEdge = arraySelectedServices[1];
            serviceTypeRake = arraySelectedServices[2];
        }
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
     * @return the serviceTypeMow
     */
    public String getServiceTypeMow() {
        return serviceTypeMow;
    }

    /**
     * @param serviceTypeMow the serviceTypeMow to set
     */
    public void setServiceTypeMow(String serviceTypeMow) {
        this.serviceTypeMow = serviceTypeMow;
    }

    /**
     * @return the serviceTypeEdge
     */
    public String getServiceTypeEdge() {
        return serviceTypeEdge;
    }

    /**
     * @param serviceTypeEdge the serviceTypeEdge to set
     */
    public void setServiceTypeEdge(String serviceTypeEdge) {
        this.serviceTypeEdge = serviceTypeEdge;
    }

    /**
     * @return the serviceTypeRake
     */
    public String getServiceTypeRake() {
        return serviceTypeRake;
    }

    /**
     * @param serviceTypeRake the serviceTypeRake to set
     */
    public void setServiceTypeRake(String serviceTypeRake) {
        this.serviceTypeRake = serviceTypeRake;
    }

    /**
     * @return the instruction
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * @param instruction the instruction to set
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    /**
     * @return the needByDate
     */
    public Date getNeedByDate() {
        return needByDate;
    }

    /**
     * @param needByDate the needByDate to set
     */
    public void setNeedByDate(Date needByDate) {
        this.needByDate = needByDate;
    }

    /**
     * @return the scheduledDate
     */
    public Date getScheduledDate() {
        return scheduledDate;
    }

    /**
     * @param scheduledDate the scheduledDate to set
     */
    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    /**
     * @return the completedFlag
     */
    public Boolean getCompletedFlag() {
        return completedFlag;
    }

    /**
     * @param completedFlag the completedFlag to set
     */
    public void setCompletedFlag(Boolean completedFlag) {
        this.completedFlag = completedFlag;
    }

    /**
     * @return the completedDate
     */
    public Date getCompletedDate() {
        return completedDate;
    }

    /**
     * @param completedDate the completedDate to set
     */
    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
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
        return "ServiceHeader [id=" + id + ", memberId=" + memberId
                + ", serviceGroup=" + serviceGroup
                + ", serviceTypeMow=" + serviceTypeMow               
                + ", serviceTypeEdge=" + serviceTypeEdge
                + ", serviceTypeRake=" + serviceTypeRake 
                 + ", instruction=" + instruction               
                + ", needByDate=" + needByDate
                + ", scheduledDate=" + scheduledDate 
                + ", completedFlag=" + completedFlag
                + ", completedDate=" + completedDate
                + ", expirationDate=" + expirationDate
                + ", createUserName=" + createUserName 
                + ", createDate=" + createDate
                + ", changeUserName=" + changeUserName
                + ", changeDate=" + changeDate + "]";
    }    
}
