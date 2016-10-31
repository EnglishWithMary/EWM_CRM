<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Menu -->
<nav id="menu">
    <ul class="links">
        <li><a href="/home">Home</a></li>
        <li><a href="/dep">Departments</a></li>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/users">Users</a></li>
        </security:authorize>
    </ul>
</nav>
