<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Service Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/> 
    </head>
    <body>
        <div id="logo">
            <h1><a id="top">momow List</a></h1>
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
        
        <table>
            <h2 class="flash">${flash}</h2>
            <h2 class="success">${success}</h2>
            
            
            
                <tr><th>Service</th><th>Need by Date</th><th>Scheduled Date</th><th>Completed</th></tr>
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

        </body>
</html>


