<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<p><a href="home">Home</a></p>
<p>Users</p>
<table>
    <tr>
        <td>User login</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <a href="user/${user.id}">${user.login}</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p><a href="/userAdd">Add User</a></p>
</body>
</html>
