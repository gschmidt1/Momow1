<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="menu">
            
            <ul>
                <li><a href="main?action=home">Home</a></li>
	        <li><a href="main?action=about">About Us</a></li>
                <li><a href="main?action=contact">Contact Us</a></li>
                <c:choose>
                <c:when test="${user ne null}">
                <li><a href="main?action=member">Member</a></li>
                <li><a href="main?action=logout">Log Out</a></li>
                <li><a>Welcome ${user.userName}</a></li>
                </c:when>
                <c:otherwise>
                <li><a href="main?action=registration">Registration</a></li>
                <li><a href="main?action=login">Login</a></li>
                </c:otherwise>
                </c:choose>
            </ul>
        </div>
        </body>
</html>
