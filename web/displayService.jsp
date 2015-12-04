
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
    </head>
    <body>
        <div id="logo">
            <h1><a id="top">momow Display</a></h1>
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
        <h2 class="flash">${flash}</h2>
        <table>
                <tr><td>Service: </td><td>${displayService.serviceGroup}</td></tr>
                <tr><td>Need by Date: </td><td><fmt:formatDate value="${displayService.needByDate}" var="formattedDate" type="date" pattern="MM-dd-yyyy" /><c:out value="${formattedDate}" default="-"/></td></tr>
                <tr><td>Scheduled Date: </td><td><fmt:formatDate value="${displayService.scheduledDate}" var="formattedDate" type="date" pattern="MM-dd-yyyy" /><c:out value="${formattedDate}" default="Not Yet"/></td></tr>
                <tr><td>Completed Date: </td><td><fmt:formatDate value="${displayService.completedDate}" var="formattedDate" type="date" pattern="MM-dd-yyyy" /><c:out value="${formattedDate}" default="No"/></td></tr>
                <tr><td>Completed: </td><td>${list.completedFlag ? 'Yes' : 'No'}</td></tr>
  
                <tr><td colspan="2">Special Instructions: </td></tr>
                <tr><td colspan="2"><textarea name="postText" rows="7" maxlength="140" disabled><c:out value="${fn:trim(displayService.instruction)}"/></textarea>
                <tr><td colspan="2">Lawn Services: </td></tr>  
        <c:forEach var="service" items="${services}">
            <tr><td><input type="checkbox" name="selected" disabled="disabled" value="${service.serviceType}"  
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
            /></td><td>${service.serviceTypeDescription}</td></tr>      
        </c:forEach>
            <tr>
                <td>
                    <form method="POST" action="main">
                        <input type="hidden" name="action" value="displayEditService"/>
                        <input type="hidden" name="serviceId" value="${displayService.id}" />
                        <input type="submit" value="EDIT">
                    </form>
                </td>
                <td>
                    <form method="POST" action="main">
                        <input type="hidden" name="action" value="deleteService"/>
                        <input type="hidden" name="serviceId" value="${displayService.id}" />
                        <input type="submit" value="DELETE">
                    </form>
                </td>
            </tr>        
        </table>    
        <br>       
        <p><a href="main?action=listService">Back to List</a></p>   
        <br>
        <%@ include file="footer.jsp" %>
    </body>
</html>
