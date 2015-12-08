<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        <h2>Contact Momow</h2>
        <table>
            <tr><td><b>${company.companyName}</b></th></tr>
            <tr><td><b>Address:</b></td></tr>
            <tr><td>${company.address}</td></tr>
            <tr><td>${company.city}, ${company.st} ${company.zip}</td></tr>
            <tr><td><b>Email: </b>${company.email}</td></tr>
            <tr><td><b>Phone: </b>${company.phone}</td></tr>
        </table>
        <p></p>
        <p><a href="main?action=home">Back to Home</a></p>
        <br>
        <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
