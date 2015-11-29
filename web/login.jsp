<%-- 
    Document   : login
    Created on : Nov 8, 2015, 8:02:17 PM
    Author     : gnonschmidt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <h1><a id="top">momow Login</a></h1>
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
        <h1>Login to Momow</h1>
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
        <div class="footer">
        glenn.schmidt@g.austincc.edu
        </div>
    </body>
</html>
