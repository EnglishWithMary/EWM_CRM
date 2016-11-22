<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel='stylesheet prefetch' href="/resources/assets/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/style.css">
</head>
<body>

        <div align="center">
            <ul class="links">

                    <h1>Hello users!</h1>

                <li><a href="/home">Home</a></li>
                <li><a href="/mangers">Managers</a></li>
                <li><a href="/teachers">Teachers</a></li>
                <li><a href="/students">Students</a></li>
                <li><a href="/groups">Groups</a></li>
                <li><a href="/schedules">Schedules</a></li>
                <li><a href="/leads">Leads</a></li>

                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/admin">Admin</a></li>
                    <li><a href="/users">Users List</a></li>
                    <li><a href="/managers">Managers List</a></li>
                    <li><a href="/teachers">Teachers List</a></li>
                    <li><a href="/students">Students List</a></li>
                </security:authorize>
            </ul>
        </div>

</body>
</html>
