<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!-- Menu -->
<nav id="menu">
    <ul class="links">
        <li><a href="/home">Home</a></li>
        <li><a href="/students">Students</a></li>
        <li><a href="/groups">Groups</a></li>
        <li><a href="/schedules">Schedules</a></li>

        <security:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_MANAGER')">
            <li><a href="/teachers">Teachers</a></li>
            <li><a href="/managers">Managers</a></li>
            <li><a href="/leads">Leads</a></li>
            <li><a href="/persons">Persons</a></li>
        </security:authorize>

    </ul>
</nav>