<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
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
        <c:set var="logoName" value="Create" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %>      
        <h2>Create Service Order</h2>
         <h2 class="flash">${flash}</h2>
        <c:if test="${!empty param.needByDate}">
            <c:set var="paramNeedByDate" value="${param.needByDate}"/>
             <fmt:parseDate pattern="MM/dd/yyyy" value="${paramNeedByDate}" var="formattedDate" />
        </c:if>      
        <form method="POST" action="main">
            <input type="hidden" name="action" value="createService"/>
            <table>
                <tr><td>Service: </td><td><select name="serviceGroup"><option value="${services[0].serviceGroup}">${services[0].serviceGroupDescription}</option></select></td></tr>
                <tr><td>Need by Date: </td><td><input type="text" name="needByDate" value="${param.needByDate}" id="datepicker1" /></td></tr>
                <tr><td colspan="2">Special Instructions: </td></tr>    
                <tr><td colspan="2"><textarea name="specialInstructions" rows="5" cols="50" maxlength="140"><c:out value="${fn:trim(param.specialInstructions)}"/></textarea></td>
                <tr><td colspan="2">Lawn Services: </td></tr>
            </table>
            <table>
                <c:forEach var="service" items="${services}">
                <tr><td><input type="checkbox" name="selectedServices" value="${service.serviceType}"
                <c:forEach var="paramSelectedService" items="${paramValues.selectedServices}"> 
                            <c:choose>
                                <c:when test="${service.serviceType eq paramSelectedService}">
                                checked="checked"   
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>    
                            </c:choose>    
                </c:forEach>/></td>
                     <td>${service.serviceTypeDescription}</td></tr>    
            </c:forEach>
                <tr>
                    <td><input type="SUBMIT" value="Submit"></td>
                    <td><input type="RESET" value="Reset"></td>
                </tr>
            </table>
        </form>       
         <p><a href="main?action=member">Back to Member</a></p>
         <br>
         <%@ include file="footer.jsp" %>
    </body>
</html>
