<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Menu -->
    <ul class="links">
        <li><a href="/home">Home</a></li>
        <li><a href="/dep">Departments</a></li>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/users">Users</a></li>
        </security:authorize>
    </ul>
