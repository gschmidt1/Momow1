<%-- 
    Document   : member
    Created on : Nov 8, 2015, 8:09:24 PM
    Author     : gnonschmidt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
    <body>
        <a name="top">&nbsp;</a>
        <c:set var="logoName" value="Member" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %>
        <h2>Member Services</h2>
        <h2 class="flash">${flash}</h2>
        <h2 class="success">${success}</h2>
        <table>
            <tr><th>Click Needed Option</th></tr> 
            <tr><td><a href="main?action=createService">Create Service Order</a></td></tr>
            <tr><td><a href="main?action=listService">List Services</a></td></tr>
            <tr><td><a href="main?action=editRegistration&mode=display">Update Membership</a></td></tr>
            <tr><td><a href="main?action=editPassword&mode=display">Update Password</a></td></tr>
            <tr><td><a href="main?action=editUsername&mode=display">Update Username</a></td></tr>
        </table>
        <br>
        <%@ include file="footer.jsp" %>
    </body>
</html>
