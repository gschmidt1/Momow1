package edu.acc.j2ee.momow1;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringEscapeUtils;

public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getParameter("action");   
        if (action == null) action = "home";
        switch (action) {
            case "home": action = "home"; break;
            case "about": action = "about"; break;
            case "contact": action = "contact"; break;
            case "registration": action = registration(request); break;
            case "createService": action = createServices(request); break; 
            case "editService": action = editService(request); break;     
            case "Service": action = editService(request); break;
                
            case "editRegistration": action = editRegistration(request); break;
            case "editPassword": action = editPassword(request); break;
            case "deleteService": action = deleteService(request); break; 
            case "listService": action = listServices(request); break; 
            case "displayService": action = displayService(request); break;     
            case "member": action = "member"; break;   
         //   case "login": action = "login"; break;   
            case "login": action = login(request); break;
            default: action = "home";
        }
        request.getRequestDispatcher(action + ".jsp").forward(request,response);
    }
    
      private String createServices(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) return "createService";
        String [] inArraySelectedServices = null;
        Date needByDate = null;
        String inServiceGroup = request.getParameter("serviceGroup");         
        String inNeedByDate = request.getParameter("needByDate");
        String inSpecialInstructions = request.getParameter("specialInstructions");
        inArraySelectedServices = request.getParameterValues("selectedServices");
                
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try{
            needByDate = df.parse(inNeedByDate);
        }catch(ParseException pe){
            needByDate = null;
        }
        if (!ServiceValidator.validateService(needByDate, inSpecialInstructions, inArraySelectedServices)) {
             request.setAttribute("flash", "One or more fields is invalid.");
            return "createService";
        }
        MomowDAO db = (MomowDAO) getServletContext().getAttribute("db");
        
        User loginUser = (User) request.getSession().getAttribute("user");
                
        ServiceOrder serviceOrder = new ServiceOrder(loginUser.getMemberId(), inServiceGroup, needByDate, inSpecialInstructions, inArraySelectedServices);
                
        db.createServices(serviceOrder);
        if (db.getLastError() != null) {
            request.setAttribute("flash", db.getLastError());
            return "createService";
        }
        request.setAttribute("success", "Successfully created service");
        return listServices(request);
    }
    private String editService(HttpServletRequest request) {
        String[] inArraySelectedServices  = null;  
        String inServiceGroup = request.getParameter("serviceGroup"); 
        int serviceId = Integer.parseInt(request.getParameter("serviceId"));   
        String inNeedByDate = request.getParameter("needByDate");
        String inSpecialInstructions = request.getParameter("specialInstructions");
        inArraySelectedServices = request.getParameterValues("selectedServices");
        
        Date needByDate = null;
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try{
            needByDate = df.parse(inNeedByDate);
        }catch(ParseException pe){
            request.setAttribute("flash", "Need By Date Error.");
            return "editService";
        }
        
        //validation  
        if (!ServiceValidator.validateService(needByDate, inSpecialInstructions, inArraySelectedServices)) {
             request.setAttribute("flash", "One or more fields is invalid.");
            return "editService";
        }
        
        MomowDAO db = (MomowDAO) getServletContext().getAttribute("db");
        //User loginUser = (User) getServletContext().getAttribute("user");
        User loginUser = (User) request.getSession().getAttribute("user");
       
        ServiceOrder displayService = new ServiceOrder(loginUser.getMemberId(), inServiceGroup, needByDate, inSpecialInstructions, inArraySelectedServices);
        
        db.editService(displayService);
        if (db.getLastError() != null) {
            request.setAttribute("flash", db.getLastError());
            return "editService";
        }
        request.setAttribute("success", "Successfully edited service");
        return listServices(request);
    }
       
     private String deleteService(HttpServletRequest request) {
        
        String inServiceHeaderId = request.getParameter("serviceId");         
        int serviceId = Integer.parseInt(inServiceHeaderId);            
        
        MomowDAO db = (MomowDAO) getServletContext().getAttribute("db");
               
        db.deleteService(serviceId);
        if (db.getLastError() != null) {
            request.setAttribute("flash", db.getLastError());
            return "displayService";
        }
        request.setAttribute("success", "Successfully deleted service");
        return listServices(request);
    }

    private String listServices(HttpServletRequest request) {
        
        MomowDAO db = (MomowDAO) getServletContext().getAttribute("db");
        //pass in member id
        //User loginUser = (User) getServletContext().getAttribute("user");
        User loginUser = (User) request.getSession().getAttribute("user");
        
        List<ServiceOrder> listServices = db.getListServices(loginUser.getMemberId());
        if (db.getLastError() != null){
            request.setAttribute("flash", db.getLastError());
        }    
        request.setAttribute("listServices", listServices);
        if (!ListServiceValidator.validateArrayListIsEmpty(listServices)){
            request.setAttribute("success", "No Active Service Orders");
        }
        return "listService";
    }
    
    private String displayService(HttpServletRequest request) {
        //if (request.getMethod().equals("GET")) return "displayService";
        int id = Integer.parseInt(request.getParameter("id"));
        MomowDAO db = (MomowDAO) getServletContext().getAttribute("db");
        //pass in member id
        ServiceOrder displayService = db.displayService(id);
        if (db.getLastError() != null)
            request.setAttribute("flash", db.getLastError());
        request.setAttribute("displayService", displayService);
        return "displayService";
    }
    
     private String displayEditService(HttpServletRequest request) {
        //if (request.getMethod().equals("GET")) return "displayService";
        int id = Integer.parseInt(request.getParameter("serviceId"));
        MomowDAO db = (MomowDAO) getServletContext().getAttribute("db");
        
        ServiceOrder displayService = db.displayService(id);
        if (db.getLastError() != null)
            request.setAttribute("flash", db.getLastError());
        request.setAttribute("displayService", displayService);
        request.setAttribute("serviceId", id);
        return "editService";
    }
     
     private String login(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) return "login";
        String userName = request.getParameter("user");
        String password = request.getParameter("pass");
        Login login = new Login(userName, password);
        if (LoginValidator.validate(login)) {
            MomowDAO db = (MomowDAO) getServletContext().getAttribute("db");
            User user = db.authenticate(userName, password);
            if (user == null) {
                String error = db.getLastError();
                request.setAttribute("flash", (error == null? "Access Denied" : error));
                return "login";
            } else {
                request.getSession().setAttribute("user", user);
                return "member";
            }
        } else {
            request.setAttribute("flash", "Invalid user name or password");
            return "login";
        }
    }
     
    private String registration(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) return "registration";      
        boolean textFlag;
        String userName = request.getParameter("user");
        String password1 = request.getParameter("pass1");
        String password2 = request.getParameter("pass2");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip  = request.getParameter("zip");
        String phone  = request.getParameter("phone");
        textFlag = (request.getParameter("textFlag") == null) ? false : true;
        String email  = request.getParameter("email");
        RegistrationBean registrationBean = new RegistrationBean(userName, password1, password2, firstName, 
                                        lastName, address, city, state, zip, phone,
                                            textFlag, email);
        if (!RegistrationValidator.isValid(registrationBean)) {
            request.setAttribute("flash", "One or more fields are invalid.");
            request.setAttribute("registrationBean", registrationBean);
            return "registration";
        }
        MomowDAO db = (MomowDAO)getServletContext().getAttribute("db");
        int userId = db.register(registrationBean);
        if (db.getLastError() != null) {
            request.setAttribute("flash", db.getLastError());
            request.setAttribute("registrationBean", registrationBean);
            return "registration";
        }
        User user = db.getUserById(userId);
        request.getSession().setAttribute("user", user);
        return "member";
    }
    
     private String editRegistration(HttpServletRequest request) {
        boolean textFlag;    
        RegistrationBean registrationBean = null;
          String mode = request.getParameter("mode");       
        //Mode = Edit
        if(mode.equals("edit")){
        String userName = request.getParameter("user");
        String password1 = request.getParameter("pass1");
        String password2 = request.getParameter("pass2");
        String firstName = request.getParameter("fname");
        String lastName = request.getParameter("lname");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String zip  = request.getParameter("zip");
        String phone  = request.getParameter("phone");
        textFlag = (request.getParameter("textFlag") == null) ? false : true;
        String email  = request.getParameter("email");
        registrationBean = new RegistrationBean(userName, password1, password2, firstName, 
                                        lastName, address, city, state, zip, phone,
                                            textFlag, email);
        if (!RegistrationValidator.isValid(registrationBean)) {
            request.setAttribute("flash", "One or more fields are invalid.");
            request.setAttribute("registrationBean", registrationBean);
            return "editRegistration";
        }
        }
        
        //Mode = Display
        if(mode.equals("display")){    
        MomowDAO db = (MomowDAO) getServletContext().getAttribute("db");
        User loginUser = (User) request.getSession().getAttribute("user");
        registrationBean = db.displayEditRegistration(loginUser.getId());
        if (db.getLastError() != null)
            request.setAttribute("flash", db.getLastError());
        request.setAttribute("registrationBean", registrationBean);
        }
        return "editRegistration";
        }
     
     private String editPassword(HttpServletRequest request) {
        if (request.getMethod().equals("GET")) return "editPassword";  
    
        PasswordBean passwordBean = null;
        String mode = request.getParameter("mode");           
        String password1 = request.getParameter("pass1");
        String password2 = request.getParameter("pass2");      
        passwordBean = new PasswordBean(password1, password2);
        
        if (!PasswordValidator.isValid(passwordBean)) {
            request.setAttribute("flash", "Invalid password.");
            return "editPassword";
        }
        MomowDAO db = (MomowDAO) getServletContext().getAttribute("db");
        User loginUser = (User) request.getSession().getAttribute("user");
        db.editPassword(loginUser.getId(), passwordBean);
        if (db.getLastError() != null) {
            request.setAttribute("flash", db.getLastError());
            return "editPasword";
        }
        request.setAttribute("success", "Successfully updated password");
        return "member";
     }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
