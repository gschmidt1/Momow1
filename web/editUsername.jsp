<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Username Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
  
    <body>
        <c:set var="logoName" value="Edit" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %>
        <h2>Update Username</h2>
        <h2 class="flash">${flash}</h2>
        <form method="POST" action="main">
            <input type="hidden" name="mode" value="edit"/>
            <input type="hidden" name="action" value="editUsername"/>
            <table id="formtable">
                <tr><td>Pick Another Username:</td><td><input value="${usernameBean.userName}" type="text" name="user" placeholder="4 to 12 characters."/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Update"/></td></tr>
            </table>
        </form>
        <p><a href="main?action=member">Back to Member</a></p>  
        <br>
        <%@ include file="footer.jsp" %>
    </body>
</html>
