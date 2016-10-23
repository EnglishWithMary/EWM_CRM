<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<header>
    <div align="right">
        <security:authorize access="isAuthenticated()">
            User:<security:authentication property="principal.username"/>
        </security:authorize>
        <security:authorize access="isAnonymous()">
            <a href="/login">Login</a>
            to be autorized user
        </security:authorize>
    </div>
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
<sf:form method="post" action="/saveEmpl" modelAttribute="employee">
    <input type="hidden" name="id" value="${id}"/>
    <table>
        <tr>
            <th><sf:label path="firstName">First Name:</sf:label></th>
            <td><sf:input path="firstName"/><br>
                <sf:errors path="firstName"/>
            </td>
        </tr>
        <tr>
            <th><sf:label path="secondName">Last Name:</sf:label></th>
            <td><sf:input path="secondName" name="secondName"/><br>
                <sf:errors path="secondName"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add Employee"/>
            </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
