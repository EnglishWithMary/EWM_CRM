<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
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
<script>
    window.onload = function () {
        window.history.pushState(null, '', 'users');
    };
</script>
<p>Users</p>
<table>
    <tr>
        <td>User login</td>
        <td>User role</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <a href="user/${user.id}">${user.login}</a>
            </td>
            <td>
                    ${user.role.role}
            </td>
            <td>
                <a href="userAddRole?id=${user.id}">add role</a>
            </td>
            <td>
                <a href="userDel?id=${user.id}">delete user</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p><a href="/userAdd">Add User</a></p>
</body>
</html>
