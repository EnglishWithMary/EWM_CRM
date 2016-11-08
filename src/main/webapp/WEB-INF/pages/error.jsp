<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 03.11.2016
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <c:if test="${empty username}">
    <h1>Error 404. Page not found.</h1>
        <img src="/resources/errorImages/404.jpg">
    </c:if>

    <c:if test="${not empty username}">
        <h1>Error 403 Access Denied</h1>
        <img src="/resources/errorImages/access-denied.png">
    <c:choose>
        <c:when test="${empty username}">
            <h2>You do not have permission to access this page!</h2>
        </c:when>
        <c:otherwise>
            <h2>Username : ${username} <br/>
                You do not have permission to access this page!</h2>
        </c:otherwise>
    </c:choose>
    </c:if>