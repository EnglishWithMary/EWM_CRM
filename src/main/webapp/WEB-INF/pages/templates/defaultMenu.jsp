<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Menu -->

<security:authorize access="isAuthenticated()">
    <ul class="links">
        <li><a href="/home">Home</a></li>
        <li><a href="/managers">Managers</a></li>
        <li><a href="/teachers">Teachers</a></li>
        <li><a href="/students">Students</a></li>
        <li><a href="/groups">Groups</a></li>
        <li><a href="/schedules">Schedules</a></li>
        <li><a href="/leads">Leads</a></li>
        <li><a href="/listView">List view</a></li>
        <li><a href="/pipeline">Pipeline</a></li>
        <li><a href="/persons">Persons</a></li>

        <security:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/admin">Admin</a></li>
            <li><a href="/users">Users List</a></li>
            <%--<li><a href="/managers">Managers List</a></li>--%>
            <%--<li><a href="/teachers">Teachers List</a></li>--%>
            <%--<li><a href="/students">Students List</a></li>--%>
        </security:authorize>
    </ul>
</security:authorize>