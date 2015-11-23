<%-- 
    Document   : about
    Created on : Nov 10, 2015, 7:26:27 PM
    Author     : gnonschmidt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Us Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
    <body>
        <div id="logo">
            <h1><a id="top">momow About</a></h1>
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
        <h1>About Us</h1>
        <h2 class="flash">${flash}</h2>
        <p>We started Momow with one goal in mind.  To provide top quality lawn service to our local neighborhood residents looking for alternative lawn care service at an affordable price while providing great service.<img class="right" src="images/atswim.jpg" alt="Anderson Swim & Dive"></p>
        <p><img class="left" src="images/bwswim.png" alt="Balcones Blue Wave Swim">We are friendly and knowledgeable about lawn care and we happen to live right next door. Let us take care of your lawn while you're on the go and we promise will keep your lawn looking better than ever.</p>
        <p>We are neighborly proud and would like to earn your business.</p>
        <p>Proud member and sponsor of the Balcones Blue Wave and Anderson High School Swim teams</p>        
        <div class="footer">
         glenn.schmidt@g.austincc.edu
        </div>
        </div>
    </body>
</html>
