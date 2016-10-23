<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Edit Employee</title>
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
<%--<h1>Employee ID: ${employee.id}</h1>--%>
<sf:form method="post" action="/emplEditSave" modelAttribute="employee">
    <table>
        <tr>
            <td><input type="hidden" name="id" value="${employee.id}"/></td>
        </tr>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="secondName" value="${employee.secondName}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Edit Employee"/>
            </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
