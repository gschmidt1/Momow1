<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <title>List Service Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/> 
    </head>
    <body>
        <c:set var="logoName" value="List" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %>
        <h2>Services List</h2>
        <table>
            <h2 class="flash">${flash}</h2>
            <h2 class="success">${success}</h2>
            <c:if test="${not empty listServices}">
                <tr><th>Service</th><th>Need by Date</th><th>Scheduled Date</th><th>Completed</th></tr>
            </c:if>    
            <c:forEach var="list" items="${listServices}">
                <tr>
                <td><a href="main?action=displayService&id=${list.id}">${list.serviceGroup}</a></td>
                <td><a href="main?action=displayService&id=${list.id}"><fmt:formatDate value="${list.needByDate}" var="formattedDate" type="date" pattern="MM-dd-yyyy" />${formattedDate}</a></td>
                <td><a href="main?action=displayService&id=${list.id}"><fmt:formatDate value="${list.scheduledDate}" var="formattedDate" type="date" pattern="MM-dd-yyyy" /><c:out value="${formattedDate}" default="Not Yet"/></a></td>
                <td><a href="main?action=displayService&id=${list.id}">${list.completedFlag ? 'Yes' : 'No'}</a></td>
                </tr>
            </c:forEach>            
        </table> 
        <p><a href="main?action=member">Back to Member</a></p> 
        <br>
        <%@ include file="footer.jsp" %>
        </body>
</html>


