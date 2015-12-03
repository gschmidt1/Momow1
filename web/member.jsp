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
        <div id="logo">
            <h1><a id="top">momow Member</a></h1>
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
        <h1>Member Services</h1>
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
    </body>
</html>
