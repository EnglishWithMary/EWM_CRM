<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31.10.2016
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<div align="right">
    <security:authorize access="isAuthenticated()">
        User:<security:authentication property="principal.username"/>
    </security:authorize>
    <security:authorize access="isAnonymous()">
        <a href="/login">Login</a>
        to be authorized user
    </security:authorize>
</div>
<table>
    <td><a href="/home">Home</a></td>
    <td><a href="/dep">Departments</a></td>
    <security:authorize access="isAnonymous()">
        <td><a href="/login">Login</a></td>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
        <td>
            <a href="/logout" >Logout</a>
        </td>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <td><a href="/users">Users</a></td>
    </security:authorize>
</table>
