<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello world</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css"/>
    <%--<link href="${pageContext.request.contextPath}/resources/assets/css/all.css" rel="stylesheet" type="text/css" />--%>
</head>
<body>
<%--<header id="header">--%>
<%--Header--%>
<header id="header">
    <nav class="left">
        <a href="#menu"><span>Menu</span></a>
    </nav>
    <a href="/home" class="logo">English with Mary</a>
    <nav class="right">
        <security:authorize access="isAuthenticated()">
            <a href="/logout" class="button alt">Log out</a>
        </security:authorize>
        <security:authorize access="isAnonymous()">
            <a href="/login" class="button alt">Log in</a>
        </security:authorize>
    </nav>
</header>

<!-- Menu -->
    <nav id="menu">
        <ul class="links">
            <li><a href="/home">Home</a></li>
            <li><a href="/departments">Departments</a></li>
            <security:authorize access="hasRole('ROLE_ADMIN')">
            <li><a href="/users">Users</a></li>
            </security:authorize>
        </ul>
        <ul class="actions vertical">
            <li><a href="#" class="button fit">Login</a></li>
        </ul>
    </nav>
<%--<div align="right">--%>
<%--<security:authorize access="isAuthenticated()">--%>
<%--User:<security:authentication property="principal.username"/>--%>
<%--</security:authorize>--%>
<%--<security:authorize access="isAnonymous()">--%>
<%--<a href="/login">Login</a>--%>
<%--to be authorized user--%>
<%--</security:authorize>--%>
<%--</div>--%>

<%--<table>--%>
<%--<td><a href="/home">Home</a></td>--%>
<%--<td><a href="/dep">Departments</a></td>--%>
<%--<security:authorize access="isAnonymous()">--%>
<%--<td><a href="/login">Login</a></td>--%>
<%--</security:authorize>--%>
<%--<security:authorize access="isAuthenticated()">--%>
<%--<td>--%>
<%--<a href="/logout" >Logout</a>--%>
<%--</td>--%>
<%--</security:authorize>--%>
<%--<security:authorize access="hasRole('ROLE_ADMIN')">--%>
<%--<td><a href="/users">Users</a></td>--%>
<%--</security:authorize>--%>
<%--</table>--%>
<%--</header>--%>

<!-- Banner -->
<section id="banner">
    <div class="content">
        <h1>Enjoy your english with Mary! :)</h1>
        <p>English with Mary is your new way to improve your skills!!!
        <ul class="actions">
            <li><a href="#" class="button scrolly">Try out it</a></li>
        </ul>
    </div>
</section>

<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery.scrolly.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/util.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>
</body>
</html>
