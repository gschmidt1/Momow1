<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Registration Page</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css"/>
    </head>
    <body>
        <c:set var="logoName" value="Edit" /> 
        <%@ include file="logo.jsp" %>
        <%@ include file="header.jsp" %>
        <div id="bodyplus">
        <h2>Update Momow Membership</h2>
        <h2 class="flash">${flash}</h2>
        <form method="POST" action="main">
            <input type="hidden" name="mode" value="edit"/>
            <input type="hidden" name="action" value="editRegistration"/>
            <table id="formtable">
                <tr><td colspan="2"><em>Required fields * </em></td></tr>
                <tr><td>Your First Name *:</td><td><input value="${registrationBean.firstName}" type="text" name="fname"/></td></tr>
                <tr><td>Your Last Name *:</td><td><input value="${registrationBean.lastName}" type="text" name="lname"/></td></tr>
                <tr><td>Your Address *:</td><td><input value="${registrationBean.address}" type="text" name="address"/></td></tr>
                <tr><td>Your City *:</td><td><input value="${registrationBean.city}" type="text" name="city"/></td></tr>
                 <tr><td>Your State *:</td><td><select name="state"><option value="TX">TX</option></select></td></tr>
                <tr><td>Your Zip Code *:</td><td><input value="${registrationBean.zipCode}" type="text" name="zip" placeholder="5 or 5-4 format"/></td></tr>
                <tr><td>Your Phone# *:</td><td><input value="${registrationBean.phone}" type="text" name="phone" placeholder="###-###-#### format"/></td>
                <tr><td>Allow Text:</td><td><input value="${registrationBean.textFlag}" type="checkbox" name="textFlag"       
                               <c:if test="${registrationBean.textFlag eq true}">
                                   checked="checked"
                               </c:if>
                                   />
                    </td></tr>
                <tr><td>Your Email Address *:</td><td><input value="${registrationBean.email}" type="email" name="email"/></td></tr>
                <tr><td colspan="2"><input type="submit" value="Update"/></td></tr>
            </table>
        </form>
        <p><a href="main?action=member">Back to Member</a></p>  
        <br>
        <%@ include file="footer.jsp" %>
        </div>
    </body>
</html>
