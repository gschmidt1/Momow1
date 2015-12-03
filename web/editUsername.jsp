<%-- 
    Document   : registration
    Created on : Nov 8, 2015, 8:02:49 PM
    Author     : gnonschmidt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Username Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
  
    <body>
        <div id="logo">
            <h1><a id="top">momow Edit</a></h1>
            <p> the Great Mower</p>
            <br><br><br><br>
	</div>
        <div id="menu">
            <ul>
                <li><a href="main?action=home">Home</a></li>
	        <li><a href="main?action=about">About Us</a></li>
                <li><a href="main?action=contact">Contact Us</a></li>
	        <li><a href="main?action=registration">Registration</a></li>
                <li><a href="main?action=login">Login</a></li>
            </ul>
        </div>       
        <h2>Edit Username</h2>
        <h2 class="flash">${flash}</h2>
        <form method="POST" action="main">
            <input type="hidden" name="mode" value="edit"/>
            <input type="hidden" name="action" value="editUsername"/>
            <table id="formtable">
                <tr><td>Pick Another Username:</td><td><input value="${usernameBean.userName}" type="text" name="user" placeholder="4 to 12 characters."/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Update"/></td></tr>
            </table>
        </form>
        <p><a href="main?action=member">Back to Member</a></p>  
        <br>
        <div class="footer">
        glenn.schmidt@g.austincc.edu
        </div>
    </body>
</html>
