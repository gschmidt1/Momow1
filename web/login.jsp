<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
    <body>
        <c:set var="logoName" value="Login" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %>
        <h2>Login to Momow</h2>
        <h2 class="flash">${flash}</h2>
        <form method="POST" action="main">
            <input type="hidden" name="action" value="login"/>
            <table id="formtable">
                <tr><td>User Name:</td><td><input type="text" name="user"/></td></tr>
                <tr><td>Password:</td><td><input type="password" name="pass"/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Login"/></td></tr>
            </table>
        </form>
        <p><a href="main?action=home">Back to Home</a></p>
        <br>
        <%@ include file="footer.jsp" %>
    </body>
</html>
