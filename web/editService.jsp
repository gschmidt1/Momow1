
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Service Page</title>
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
        <h1>Edit Services</h1>
        <h2 class="flash">${flash}</h2>
        
        <c:choose>
            <c:when test="${displayService.id ne null}">
            <c:set var="paramServiceId" value="${displayService.id}"/>
            </c:when>
        <c:otherwise>
            <c:set var="paramServiceId" value="${param.serviceId}"/>
        </c:otherwise>
        </c:choose>
        
        <c:choose>
            <c:when test="${displayService.needByDate ne null}">
            <c:set var="paramNeedByDate" value="${displayService.needByDate}"/>
            </c:when>
        <c:otherwise>
            <c:set var="paramNeedByDate" value="${param.needByDate}"/>
            <fmt:parseDate pattern="MM/dd/yyyy" value="${paramNeedByDate}" var="paramNeedByDate" />
        </c:otherwise>
        </c:choose>
        
        <form method="POST" action="main">
            <input 
            <input type="hidden" name="action" value="editService"/>
            <input type="hidden" name="serviceId" value="<c:out value="${paramServiceId}"/>"/>             
            <table>
                <tr><td>Service: </td><td><select name="serviceGroup"><option value="${displayService.serviceGroup}">${services[0].serviceGroupDescription}</option></select></td></tr>  
                <tr><td>Need by Date: </td><td>         
                        <fmt:formatDate pattern="MM/dd/yyyy" value="${paramNeedByDate}" var="formattedDate" type="date" />
                       <input type="text" name="needByDate" value="${formattedDate}" id="datepicker1" /></td></tr>                          
                <tr><td>Scheduled Date: </td><td><fmt:formatDate value="${displayService.scheduledDate}" var="formattedDate" type="date" pattern="MM-dd-yyyy" /><c:out value="${formattedDate}" default="Not Yet"/></td></tr>
                <tr><td colspan="2">Special Instructions: </td></tr>
                <tr><td colspan="2"><textarea name="specialInstructions" rows="7" maxlength="140"><c:out value="${fn:trim(displayService.instruction)}"/></textarea>
                <tr><td colspan="2">Lawn Services: </td></tr>  
        <c:forEach var="service" items="${services}">
            <tr><td><input type="checkbox" name="selectedServices" value="${service.serviceType}" 
              <c:choose>
                  <c:when test="${displayService.serviceTypeMow ne null or
                                    displayService.serviceTypeRake ne null or
                                        displayService.serviceTypeEdge ne null}">  
                        <c:choose>
                            <c:when test="${service.serviceType eq displayService.serviceTypeMow}"> 
                            checked="checked"
                            </c:when>
                            <c:when test="${service.serviceType eq displayService.serviceTypeRake}"> 
                            checked="checked"
                            </c:when>
                            <c:when test="${service.serviceType eq displayService.serviceTypeEdge}"> 
                            checked="checked"
                            </c:when>
                            <c:otherwise>
                            </c:otherwise>
                        </c:choose>
                    </c:when>        
                    <c:otherwise>
                        <c:forEach var="paramSelectedService" items="${paramValues.selectedServices}"> 
                            <c:choose>
                                <c:when test="${service.serviceType eq paramSelectedService}">
                                checked="checked"   
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>    
                            </c:choose>    
                        </c:forEach>  
                    </c:otherwise>       
              </c:choose>              
            /></td><td>${service.serviceTypeDescription}</td></tr>      
        </c:forEach>
            <tr>
                <td>
                    <input type="SUBMIT" value="Submit">
                </td>
                <td>
                    <input type="RESET" value="Reset">
                </td>
            </tr>        
        </table>           
        </form>
        <br>       
        <p><a href="main?action=listService">Back to List</a></p>   
    </body>
</html>
