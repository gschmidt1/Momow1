<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Us Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
    <body>
        <c:set var="logoName" value="About" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %>
        <div id="bodyplus">
        <h2>About Momow</h2>
        <p>We started Momow with one goal in mind, to provide top quality lawn service to our local neighborhood residents looking for alternative lawn care service at an affordable price while providing great service.<img class="right" src="images/atswim.jpg" alt="Anderson Swim & Dive"></p>
        <p><img class="left" src="images/bwswim.png" alt="Balcones Blue Wave Swim">We are friendly and knowledgeable about lawn care and we happen to live right next door. Let us take care of your lawn while you're on the go and we promise will keep your lawn looking better than ever.</p>
        <p>We are neighborly proud and would like to earn your business.</p>
        <p>Proud member and sponsor of the Balcones Blue Wave and Anderson High School Swim teams</p> 
         <p><a href="main?action=home">Back to Home</a></p>
        <br>
        <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
