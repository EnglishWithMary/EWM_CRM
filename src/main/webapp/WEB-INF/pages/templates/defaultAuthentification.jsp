<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="right">
    <security:authorize access="isAnonymous()">
        <a href="/login" style="float: right;" class="button alt">Log in</a>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
        <a href="/personProfile" class="button alt">Profile</a>
        <a href="/logout" style="float: right;" class="button alt">Log out</a>
    </security:authorize>
</nav>
