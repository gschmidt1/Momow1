<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
    <body>
        <c:set var="logoName" value="Register" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %> 
        <h2>Register for Momow</h2>
        <h2 class="flash">${flash}</h2>
        <form method="POST" action="main">
            <input type="hidden" name="mode" value="create"/>
            <input type="hidden" name="action" value="registration"/>
            <table id="formtable">
                <tr><td>Pick a User Name:</td><td><input value="${registrationBean.userName}" type="text" name="user" placeholder="4 to 12 characters."/></td></tr>
                <tr><td>Enter Your Password:</td><td><input type="password" name="pass1" placeholder="6 to 15 characters."></td></tr>
                <tr><td>Re-enter Your Password:</td><td><input type="password" name="pass2" placeholder="same as the other"/></td></tr>
                <tr><td>Your First Name:</td><td><input value="${registrationBean.firstName}" type="text" name="fname"/></td></tr>
                <tr><td>Your Last Name:</td><td><input value="${registrationBean.lastName}" type="text" name="lname"/></td></tr>
                <tr><td>Your Address:</td><td><input value="${registrationBean.address}" type="text" name="address"/></td></tr>
                <tr><td>Your City:</td><td><input value="${registrationBean.city}" type="text" name="city"/></td></tr>
                 <tr><td>Your State:</td><td><select name="state"><option value="TX">TX</option></select></td></tr>
                <tr><td>Your Zip Code:</td><td><input value="${registrationBean.zipCode}" type="text" name="zip" placeholder="5 or 5-4 format"/></td></tr>
                <tr><td>Your Phone#:</td><td><input value="${registrationBean.phone}" type="text" name="phone" placeholder="###-###-#### format"/></td></tr>
                <tr><td>Allow Text:</td><td><input value="${registrationBean.textFlag}" type="checkbox" name="textFlag"/></td></tr>
                <tr><td>Your Email Address:</td><td><input value="${registrationBean.email}" type="email" name="email"/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>
            </table>
        </form>
        <br>
       <%@ include file="footer.jsp" %>
    </body>
</html>
