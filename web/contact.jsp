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
        <div id="logo">
            <h1><a id="top">momow Contact</a></h1>
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
        <div id="bodyplus">
        <h1>Contact Us</h1>
        <h2 class="flash">${flash}</h2>
        <table>
            <tr><td><b>${company.companyName}</b></th></tr>
            <tr><td><b>Address:</b></td></tr>
            <tr><td>${company.address}</td></tr>
            <tr><td>${company.city}, ${company.st} ${company.zip}</td></tr>
            <tr><td><b>Email: </b>${company.email}</td></tr>
            <tr><td><b>Phone: </b>${company.phone}</td></tr>
        </table>
        <p></p>
        <div class="footer">
         glenn.schmidt@g.austincc.edu
        </div>
        </div>
    </body>
</html>
