package edu.acc.j2ee.momow1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupListener implements ServletContextListener{
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String dbProtocol = sc.getInitParameter("db.protocol");
        String dbHost = sc.getInitParameter("db.host");
        String dbPort = sc.getInitParameter("db.port");
        String dbName = sc.getInitParameter("db.name");
        String dbUser = sc.getInitParameter("db.user");
        String dbPass = sc.getInitParameter("db.pass");
        String jdbcUrl = String.format(
            "%s://%s:%s/%s;user=%s;password=%s",
            dbProtocol, dbHost, dbPort, dbName, dbUser, dbPass
        );
        
        //Create DAO
        MomowDAO db = new MomowDAO(jdbcUrl);
        sce.getServletContext().setAttribute("db", db);
        
        //Load Lawn Services
         List<Service> services = db.getServices();
         sce.getServletContext().setAttribute("services",services);
         
         //Load Company Information
         Company company = db.getCompany();
         sce.getServletContext().setAttribute("company",company);
         
        //TEST user
        User user = new User(1, 1, "gschmidt");   
    	sce.getServletContext().setAttribute("user",user);
    }       

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        MomowDAO db = (MomowDAO)sce.getServletContext().getAttribute("db");
        db.close();
    }
}
