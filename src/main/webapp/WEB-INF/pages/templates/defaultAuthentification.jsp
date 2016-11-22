<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <security:authorize access="isAnonymous()">
        <a href="/login" class="button alt">Log in</a>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
        <a href="/logout" class="button alt" >Log out</a>
    </security:authorize>
