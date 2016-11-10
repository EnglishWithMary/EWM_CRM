<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Add User</title>
<body>
<header>
    <div align="right">User:<security:authentication property="principal.username"/></div>
    <table>
        <td><a href="/home">Home</a></td>
        <td><a href="/dep">Departments</a></td>
        <security:authorize access="isAnonymous()">
            <td><a href="/login">Login</a></td>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <td><a href="/logout">Logout</a></td>
        </security:authorize>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <td><a href="/users">Users</a></td>
        </security:authorize>
    </table>
</header>
<sf:form modelAttribute="role">
    <label for="role">Role:</label>
    <sf:select path="role">
        <sf:option value="ROLE_ADMIN"/>
        <sf:option value="ROLE_DIRECTOR"/>
        <sf:option value="ROLE_TEACHER"/>
        <sf:option value="ROLE_USER"/>
    </sf:select>

    <input type="submit" value="Set Role"/>

    <p>User id for role: ${user_id}</p>
</sf:form>

</body>
</html>
