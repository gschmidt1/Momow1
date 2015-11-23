
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Services Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
        <link href="css/jquery-ui.css" rel="stylesheet">
	<script src="external/jquery/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
        
        <script>
        /*minimum date today and 6 months out*/    
	$(function() {
		$( "#datepicker1" ).datepicker({
			showOn: "button",
			buttonImage: "css/images/calendar.gif",
			buttonImageOnly: true,
                        minDate: 0, 
                        maxDate: "+6M"
		});
	});
	</script>
    </head>
    <body>  
        <div id="logo">
            <h1><a id="top">momow Create</a></h1>
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
      
        <h1>Select Services</h1>
        <h2 class="flash">${flash}</h2>
        <form method="POST" action="main">
            <input type="hidden" name="action" value="createService"/>
            <table>
                <tr><td>Service: </td><td><select name="serviceGroup"><option value="lawn">Lawn</option></select></td></tr>
                <tr><td>Need by Date: </td><td><input type="text" name="needByDate" id="datepicker1"></td></tr>        
            </table>
            Special Instructions: 
            <br>
            <textarea name="specialInstructions" rows="7" maxlength="140"><c:out value="${fn:trim(content)}"/></textarea>
            <br>
            ${fn:trim(displayService.instruction)}
            <c:forEach var="service" items="${services}">
                <input type="checkbox" name="selectedServices" value="${service.serviceType}">
                ${service.serviceTypeDescription}
                <br>      
            </c:forEach>
                <br>
            <input type="SUBMIT" value="Submit">
            <input type="RESET" value="Reset">
            
        </form>        
        
         <p><a href="main?action=member">Back to Member</a></p>
         
    </body>
</html>
