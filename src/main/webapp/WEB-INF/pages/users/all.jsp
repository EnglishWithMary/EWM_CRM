<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<script>
    window.onload = function () {
        window.history.pushState(null,'','users');
    };
</script>
<p><a href="home">Home</a></p>
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
