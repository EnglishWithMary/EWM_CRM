<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<script>
    window.onload = function () {
        window.history.pushState(null, '', 'userAdd');
    };
</script>
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
<sf:form method="post" modelAttribute="user" action="/userAdd">
    <fieldset>
        <table>
            <tr>
                <th><sf:label path="login">Login:</sf:label></th>
                <td><sf:input path="login"/><br/>
                    <sf:errors path="login"/>
                </td>
            </tr>

            <tr>
                <th><sf:label path="password">Password:</sf:label></th>
                <td><sf:input path="password"/><br/>
                    <sf:errors path="password"/>
                </td>
            </tr>

            <tr>
                <th><sf:label path="email">Email:</sf:label></th>
                <td><sf:input path="email"/><br/>
                    <sf:errors path="email"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Add department"/>
                </td>
            </tr>
        </table>
    </fieldset>
</sf:form>

</body>
</html>
