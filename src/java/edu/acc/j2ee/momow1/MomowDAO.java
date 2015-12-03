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

    public void editService(ServiceOrder serviceOrder){
        String sql = "UPDATE service_order "
                   + "SET need_by_date = ?, service_type_mow = ?, service_type_edge = ?, "
                   + "service_type_rake = ?, instruction = ?, change_user_name = ?, change_date = ? " 
                   + "WHERE id = ?";
        PreparedStatement pstat = null;
        try {
            pstat = CONN.prepareStatement(sql);
            pstat.setDate(1, new java.sql.Date(serviceOrder.getNeedByDate().getTime()));
            pstat.setString(2, serviceOrder.getServiceTypeMow());
            pstat.setString(3, serviceOrder.getServiceTypeEdge());
            pstat.setString(4, serviceOrder.getServiceTypeRake());
            pstat.setString(5, serviceOrder.getInstruction());
            pstat.setString(6, "javauser");
            pstat.setTimestamp(7, GenericUtilities.getCurrentTimeStamp()); 
            pstat.setInt(8, serviceOrder.getId());
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
     
    public void editPassword(int userId, PasswordBean passwordBean){
        String sql = "UPDATE users "
                   + "SET password = ?, change_user_name = ?, change_date = ?"
                   + "WHERE id = ?";
      
        PreparedStatement pstat = null;
        try {
            pstat = CONN.prepareStatement(sql);
            pstat.setString(1, passwordBean.getPassword1());
            pstat.setString(2, "javauser");
            pstat.setTimestamp(3, GenericUtilities.getCurrentTimeStamp()); 
            pstat.setInt(4, userId);
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
    
    public User authenticate(String userName, String password) {
        User user = null;
        String sql = "SELECT * FROM users WHERE username = '%s' AND password = '%s'";
        sql = String.format(sql, userName, password);
        Statement stat = null;
        ResultSet rs = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                user = new User(
                        rs.getInt("id"),
                        rs.getInt("memberid"),
                        rs.getString("username")
                       
                );
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
        return user;
    }

    public void close() {
        if (CONN != null) {
            try {
                CONN.close();
            } catch (SQLException sqle) {
            }
        }
    }
    
     public int register(RegistrationBean bean) {
        int userId = 0;
        int memberId = 0;
        userId = insertUser(bean);
        if (getLastError() != null) {
            return 0;
        }
        
        memberId = insertMember(bean, userId);
        if (getLastError() != null) {
            return 0;
        }
        updateUser(userId, memberId);
        if (getLastError() != null) {
            return 0;
        }
        return userId;
    }
     
    public int insertUser(RegistrationBean bean) {
        int userId = 0;
        String sql = "INSERT INTO USERS (username,password, create_user_name, create_date, change_user_name, change_date)";
        sql += " VALUES (?,?,?,?,?,?)";
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            pstat = CONN.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstat.setString(1, bean.getUserName());
            pstat.setString(2, bean.getPassword1());
            pstat.setString(3, "javauser");
            pstat.setTimestamp(4, GenericUtilities.getCurrentTimeStamp());       
            pstat.setString(5, "javauser");
            pstat.setTimestamp(6, GenericUtilities.getCurrentTimeStamp());
            pstat.executeUpdate();
            rs = pstat.getGeneratedKeys();
            if (rs.next()) {
                userId = rs.getInt(1);
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
            if (pstat != null) {
                try {
                    pstat.close();
                } catch (SQLException sqle) {
                }
            }
        }
        return userId;
    }
    
    public int insertMember(RegistrationBean bean, int userId) {
        String sql = "INSERT INTO members(userid, firstname, lastname, address, city, st, zip,"
                   + " phone, text_flag, email, create_user_name, create_date, change_user_name, change_date )";
        sql += " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstat = null;
        ResultSet rs = null;
        int memberId = 0;
        try {
            pstat = CONN.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstat.setInt(1, userId);
            pstat.setString(2, bean.getFirstName());
            pstat.setString(3, bean.getLastName());
            pstat.setString(4, bean.getAddress());
            pstat.setString(5, bean.getCity());
            pstat.setString(6, bean.getState());
            pstat.setString(7, bean.getZipCode());
            pstat.setString(8, bean.getPhone());
            pstat.setBoolean(9, bean.isTextFlag());
            pstat.setString(10, bean.getEmail());
            pstat.setString(11, "javauser");
            pstat.setTimestamp(12, GenericUtilities.getCurrentTimeStamp());       
            pstat.setString(13, "javauser");
            pstat.setTimestamp(14, GenericUtilities.getCurrentTimeStamp());
            
            pstat.executeUpdate();
            rs = pstat.getGeneratedKeys();
            if (rs.next()) {
                memberId = rs.getInt(1);
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
            if (pstat != null) {
                try {
                    pstat.close();
                } catch (SQLException sqle) {
                }
            }
        }

        return memberId;
    }
    
     public void updateUser(int userId, int memberId) {
        String sql = "UPDATE users SET memberid = ?, change_user_name = ?, change_date = ?"
                + " WHERE id = ?";
        PreparedStatement pstat = null;
        ResultSet rs = null;
        try {
            pstat = CONN.prepareStatement(sql);
            pstat.setInt(1, memberId);
            pstat.setString(3, "javauser");
            pstat.setTimestamp(4, GenericUtilities.getCurrentTimeStamp());
            pstat.setInt(5, userId);
            pstat.executeUpdate();
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
            if (pstat != null) {
                try {
                    pstat.close();
                } catch (SQLException sqle) {
                }
            }
        }
    }
     
    public User getUserById(int userId) {
        String sql = "SELECT * FROM USERS WHERE id = " + userId;
        Statement stat = null;
        ResultSet rs = null;
        User user = null;
        try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                /*
                 user = new User(
                 rs.getString("username"),
                 new Date(rs.getDate("joindate").getTime()),
                 rs.getInt("id")
                 );
                 */
                user = new User(
                        rs.getInt("id"),
                        rs.getInt("memberid"),
                        rs.getString("username")
                        
                );
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
        return user;
    }
    
     public RegistrationBean displayEditRegistration(int userId) {
       String sql = "SELECT * FROM users AS u"
                  + " INNER JOIN members AS m"
                  + " ON u.memberid = m.id"
                  + " WHERE u.expiration_date IS null AND "
                  + " m.expiration_date IS null AND "
                  + " u.id = " + userId; 
        Statement stat = null;
        ResultSet rs = null;
        RegistrationBean registrationBean = null;
       try {
            stat = CONN.createStatement();
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                registrationBean = new RegistrationBean();
                        registrationBean.setUserName(rs.getString("username"));
                        registrationBean.setPassword1(rs.getString("password"));
                        registrationBean.setPassword2(rs.getString("password"));
                        registrationBean.setFirstName(rs.getString("firstname"));
                        registrationBean.setLastName(rs.getString("lastname"));
                        registrationBean.setAddress(rs.getString("address"));
                        registrationBean.setCity(rs.getString("city"));
                        registrationBean.setState(rs.getString("st"));
                        registrationBean.setZipCode(rs.getString("zip"));
                        registrationBean.setPhone(rs.getString("phone"));
                        registrationBean.setTextFlag(rs.getBoolean("text_flag"));
                        registrationBean.setEmail(rs.getString("email"));   
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
        return registrationBean;
    
    }
}
