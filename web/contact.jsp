<%-- 
    Document   : contact
    Created on : Nov 10, 2015, 7:27:33 PM
    Author     : gnonschmidt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Us Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
    <body>
        <c:set var="logoName" value="Contact" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %>
        <div id="bodyplus">
        <h2>Contact Us</h2>
        <table>
            <tr><td><b>${company.companyName}</b></th></tr>
            <tr><td><b>Address:</b></td></tr>
            <tr><td>${company.address}</td></tr>
            <tr><td>${company.city}, ${company.st} ${company.zip}</td></tr>
            <tr><td><b>Email: </b>${company.email}</td></tr>
            <tr><td><b>Phone: </b>${company.phone}</td></tr>
        </table>
        <p></p>
        <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
