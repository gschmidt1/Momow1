<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       
        <title>Member Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
    <body>
        <c:set var="logoName" value="Member" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %>
        <h2>Member Services</h2>
        <h2 class="flash">${flash}</h2>
        <h2 class="success">${success}</h2>
        <table>
            <tr><th>Click Needed Option</th></tr> 
            <tr><td>
                    <form method="GET" action="main">
                        <input type="hidden" name="action" value="createService"/>           
                        <input type="submit" value="Create Service Order" style="width: 500px; height: 30px;"/>
                    </form>
                    <br>
             </td></tr>
            <tr><td>
                    <form method="GET" action="main">
                        <input type="hidden" name="action" value="listService"/>           
                        <input type="submit" value="List Services" style="width: 500px; height: 30px;"/>
                    </form>
                    <br>
             </td></tr>
            <tr><td>
                    <form method="GET" action="main">
                        <input type="hidden" name="action" value="editRegistration"/>     
                        <input type="hidden" name="mode" value="display"/>  
                        <input type="submit" value="Update Membership" style="width: 500px; height: 30px;"/>
                    </form>
                    <br>
             </td></tr>
            <tr><td>
                    <form method="GET" action="main">
                        <input type="hidden" name="action" value="editPassword"/>     
                        <input type="hidden" name="mode" value="display"/>  
                        <input type="submit" value="Update Password" style="width: 500px; height: 30px;" />
                    </form>
                    <br>
             </td></tr>
            <tr><td>
                    <form method="GET" action="main">
                        <input type="hidden" name="action" value="editUsername"/>     
                        <input type="hidden" name="mode" value="display" />  
                        <input type="submit" value="Update Username" style="width: 500px; height: 30px;" />
                    </form>
                    <br>
             </td></tr>
        </table>
        <br>
        <%@ include file="footer.jsp" %>
    </body>
</html>
