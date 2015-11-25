/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.acc.j2ee.momow1;

import edu.acc.j2ee.momow1.GenericUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gnonschmidt
 */
public class MomowDAO {
    
    private String lastError;

    private Connection CONN;

    public MomowDAO(String jdbcUrl) {
        try {
            CONN = DriverManager.getConnection(jdbcUrl);
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        }
    }

    public String getLastError() {
        return lastError;
    }
    public List<ServiceOrder> getListServices(int id) {
        List<ServiceOrder> listServices = new ArrayList<>();
        String sql = "SELECT * FROM service_order " 
                    + "WHERE memberid = " + id + " AND expiration_date IS null "
                    + "ORDER BY need_by_date DESC";
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = CONN.createStatement();       
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                //check for need by date is null
                Date rsNeedByDate = null; 
                if(rs.getDate("need_by_date") !=null){
                    rsNeedByDate = new Date(rs.getDate("need_by_date").getTime());
                }else{
                    rsNeedByDate = null;
                }
                //check for scheduled date is null
                Date rsScheduledDate = null;
                if(rs.getDate("scheduled_date") !=null){
                    rsScheduledDate = new Date(rs.getDate("scheduled_date").getTime());
                }else{
                    rsScheduledDate = null;
                }
                
                ServiceOrder sh = new ServiceOrder( 
                        rs.getString("service_group"),
                        rsNeedByDate,
                        rsScheduledDate,
                        rs.getBoolean("completed_flag"),
                        rs.getInt("id")
                );
                listServices.add(sh);
            }
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqle) {
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException sqle) {
                }
            }
        }
        return listServices;
    }
    
      public ServiceOrder displayService(int id) {
       String sql = "SELECT * FROM service_order " 
                    + "WHERE expiration_date IS null AND id = " + id; 
        Statement stat = null;
        ResultSet rs = null;
        ServiceOrder serviceOrder = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                //check for need by date is null
                Date rsNeedByDate = null; 
                if(rs.getDate("need_by_date") !=null){
                    rsNeedByDate = new Date(rs.getDate("need_by_date").getTime());
                }else{
                    rsNeedByDate = null;
                }
                //check for scheduled date is null
                Date rsScheduledDate = null;
                if(rs.getDate("scheduled_date") !=null){
                    rsScheduledDate = new Date(rs.getDate("scheduled_date").getTime());
                }else{
                    rsScheduledDate = null;
                }
                
                //check for complted date is null
                Date rsCompletedDate = null;
                if(rs.getDate("completed_date") !=null){
                    rsCompletedDate = new Date(rs.getDate("completed_date").getTime());
                }else{
                    rsCompletedDate = null;
                }
                //check for expiration date is null
                Date rsExpirationDate = null; 
                if(rs.getDate("expiration_date") !=null){
                    rsExpirationDate = new Date(rs.getDate("completed_date").getTime());
                }else{
                    rsExpirationDate = null;
                }
                //check for create date is null
                Date rsCreateDate = null; 
                if(rs.getTimestamp("create_date") !=null){
                   //convert timestamp to date 
                   rsCreateDate = rs.getTimestamp("create_date");  
                   rsCreateDate = new Date(rsCreateDate.getTime());
                }else{
                    rsCreateDate = null;
                }
                //check for change date is null
                Date rsChangeDate = null; 
                if(rs.getTimestamp("change_date") !=null){
                    //convert timestamp to date
                    rsChangeDate = rs.getTimestamp("change_date");                  
                    rsChangeDate = new Date(rsChangeDate.getTime());
                }else{
                    rsChangeDate = null;
                }
                serviceOrder = new ServiceOrder();
                        serviceOrder.setId(rs.getInt("id"));
                        serviceOrder.setMemberId(rs.getInt("memberid"));
                        serviceOrder.setServiceGroup(rs.getString("service_group"));
                        serviceOrder.setServiceTypeMow(rs.getString("service_type_mow"));
                        serviceOrder.setServiceTypeEdge(rs.getString("service_type_edge"));
                        serviceOrder.setServiceTypeRake(rs.getString("service_type_rake"));
                        serviceOrder.setInstruction(rs.getString("instruction"));
                        serviceOrder.setNeedByDate(rsNeedByDate);
                        serviceOrder.setScheduledDate(rsScheduledDate);
                        serviceOrder.setCompletedFlag(rs.getBoolean("completed_flag"));
                        serviceOrder.setCompletedDate(rsCompletedDate); 
                        serviceOrder.setExpirationDate(rsExpirationDate);
                        serviceOrder.setCreateUserName(rs.getString("create_user_name"));
                        serviceOrder.setCreateDate(rsCreateDate);                       
                        serviceOrder.setChangeUserName(rs.getString("change_user_name"));
                        serviceOrder.setChangeDate(rsChangeDate);
            }
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqle) {
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException sqle) {
                }
            }
        }
        return serviceOrder;
    }
        
     public List<Service> getServices() {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM services " 
                    + "WHERE expiration_date IS null";
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                               
                Service service = new Service();
                       
                        service.setServiceGroup(rs.getString("service_group"));
                        service.setServiceGroupDescription(rs.getString("service_group_description"));
                        service.setServiceType(rs.getString("service_type"));
                        service.setServiceTypeDescription(rs.getString("service_type_description"));
                   
                services.add(service);
            }
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqle) {
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException sqle) {
                }
            }
        }
        return services;
    }
     
    public Company getCompany() {
        
        String sql = "SELECT * FROM company " 
                    + "WHERE expiration_date IS null";
           
        Statement stat = null;
        ResultSet rs = null;
        Company company = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                company = new Company();
                        company.setCompanyName(rs.getString("company_name"));
                        company.setAddress(rs.getString("address"));
                        company.setCity(rs.getString("city"));
                        company.setSt(rs.getString("st"));
                        company.setZip(rs.getString("zip"));
                        company.setEmail(rs.getString("email"));
                        company.setPhone(rs.getString("phone"));  
            }
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqle) {
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException sqle) {
                }
            }
        }
        return company;
    }
     
    public void createServices(ServiceOrder serviceOrder){
        String sql = "INSERT INTO service_order "
                   + "(memberid, service_group, service_type_mow, service_type_edge, service_type_rake, "
                   + "instruction, need_by_date, create_user_name, create_date, change_user_name, change_date)" 
                   + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstat = null;
        try {
            pstat = CONN.prepareStatement(sql);
            pstat.setInt(1, serviceOrder.getId());
            pstat.setString(2, serviceOrder.getServiceGroup());
            pstat.setString(3, serviceOrder.getServiceTypeMow());
            pstat.setString(4, serviceOrder.getServiceTypeEdge());
            pstat.setString(5, serviceOrder.getServiceTypeRake());
            pstat.setString(6,  serviceOrder.getInstruction());
            pstat.setDate(7, new java.sql.Date(serviceOrder.getNeedByDate().getTime()));          
            pstat.setString(8, "javauser");
            pstat.setTimestamp(9, GenericUtilities.getCurrentTimeStamp());       
            pstat.setString(10, "javauser");
            pstat.setTimestamp(11, GenericUtilities.getCurrentTimeStamp()); 
            pstat.executeUpdate();
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (pstat != null) {
                try {
                    pstat.close();
                } catch (SQLException sqle) {
                }
            }
        }
    }
    
    public void editService(int serviceId, Date needByDate, String specialInstructions, String[] arraySelectedServices){
        String sql = "UPDATE service_order "
                   + "SET need_by_date = ?, service_type_mow = ?, service_type_edge = ?, "
                   + "service_type_rake = ?, instruction = ?, change_user_name = ?, change_date = ? " 
                   + "WHERE id = ?";
        PreparedStatement pstat = null;
        try {
            pstat = CONN.prepareStatement(sql);
            pstat.setDate(1, new java.sql.Date(needByDate.getTime()));
            pstat.setString(2, arraySelectedServices[0]);
            pstat.setString(3, arraySelectedServices[1]);
            pstat.setString(4, arraySelectedServices[2]);
            pstat.setString(5, specialInstructions);
            pstat.setString(6, "javauser");
            pstat.setTimestamp(7, GenericUtilities.getCurrentTimeStamp()); 
            pstat.setInt(8, serviceId);
            pstat.executeUpdate();
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (pstat != null) {
                try {
                    pstat.close();
                } catch (SQLException sqle) {
                }
            }
        }
    }
    
    //not actual deleting but updating exipiration date and will no longer be displayed
    public void deleteService(int serviceId){
        String sql = "UPDATE service_order "
                   + "SET expiration_date = ?, change_user_name = ?, change_date = ?"
                   + "WHERE id = ?";
      
        PreparedStatement pstat = null;
        try {
            pstat = CONN.prepareStatement(sql);
            pstat.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pstat.setString(2, "javauser");
            pstat.setTimestamp(3, GenericUtilities.getCurrentTimeStamp()); 
            pstat.setInt(4, serviceId);
            pstat.executeUpdate();
            lastError = null;
        } catch (SQLException sqle) {
            lastError = sqle.getMessage();
        } finally {
            if (pstat != null) {
                try {
                    pstat.close();
                } catch (SQLException sqle) {
                }
            }
        }
    }        
    
    public void close() {
        if (CONN != null) {
            try {
                CONN.close();
            } catch (SQLException sqle) {
            }
        }
    }
}
