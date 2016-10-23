<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Departments</title>
</head>
<body>
<script>
    window.onload = function () {
        window.history.pushState(null, '', 'dep');
    };
</script>
<header>
    <div align="right">
        <security:authorize access="isAuthenticated()">
            User:<security:authentication property="principal.username"/>
        </security:authorize>
        <security:authorize access="isAnonymous()">
            <a href="/j_spring_security_login">Login</a>
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
<p>Departments</p>
<table width="600px">
    <tr>
        <td><b>Name</b></td>
        <td><b>Actions</b></td>
    </tr>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>${department.name}</td>
            <td>
                <a href="/depDelete?id=${department.id}">Delete</a>
            </td>
            <td>
                <a href="/depEdit?id=${department.id}">Edit</a>
            </td>
            <td>
                <a href="/empl?id=${department.id}">Employees</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/depAdd">Add department</a>
</body>
</html>