<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <%--<link rel='stylesheet prefetch' href="/resources/assets/css/bootstrap/css/bootstrap.min.css">--%>
    <%--<link rel="stylesheet" href="/resources/assets/css/style.css">--%>
</head>
<body onload='document.loginForm.username.focus();'>

<div id="login-box">
    <div class="wrapper">
        <form class="form-signin" name='loginForm'
              action='/security_check' method='POST'>
            <h2 class="form-signin-heading">Please login</h2>

            <c:if test="${not empty error}">
            <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
            </c:if>
            <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
            <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
            <label class="checkbox">
                <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me
            </label>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>

    </div>
    </form>
</div>
</body>
</html>






















<%--<html>--%>
<%--<head>--%>
    <%--<meta charset="utf-8">--%>
    <%--<link href="css/bootstrap.css" rel="stylesheet">--%>
    <%--<title>Login page</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1>Introduce yourself</h1>--%>






<%--<form class="form-inline">--%>
    <%--<input type="text" class="input-small" placeholder="Email">--%>
    <%--<input type="password" class="input-small" placeholder="Password">--%>
    <%--<label class="checkbox">--%>
        <%--<input type="checkbox"> Запомнить--%>
    <%--</label>--%>
    <%--<button type="submit" class="btn">Отправить</button>--%>
<%--</form>--%>

<%--<c:if test="${not empty error}">--%>
    <%--<div class="error">${error}</div>--%>
<%--</c:if>--%>
<%--<c:if test="${not empty msg}">--%>
    <%--<div class="msg">${msg}</div>--%>
<%--</c:if>--%>
<%--<form name='loginForm'--%>
      <%--action="<c:url value='j_spring_security_check' />" method='POST'>--%>


<%--</body>--%>
<%--</html>--%>

<%--<html>--%>
<%--<head>--%>
    <%--<title>Login Page</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<script>--%>
    <%--window.onload = function () {--%>
        <%--window.history.pushState(null, '', 'login');--%>
    <%--};--%>
<%--</script>--%>
<%--<header>--%>
    <%--<div align="right">--%>
        <%--<security:authorize access="isAuthenticated()">--%>
            <%--User:<security:authentication property="principal.username"/>--%>
        <%--</security:authorize>--%>
        <%--<security:authorize access="isAnonymous()">--%>
            <%--<a href="/login">Login</a>--%>
            <%--to be autorized user--%>
        <%--</security:authorize>--%>
    <%--</div>--%>
    <%--<table>--%>
        <%--<td><a href="/home">Home</a></td>--%>
        <%--<td><a href="/dep">Departments</a></td>--%>
        <%--<security:authorize access="isAnonymous()">--%>
            <%--<td><a href="/login">Login</a></td>--%>
        <%--</security:authorize>--%>
        <%--<security:authorize access="isAuthenticated()">--%>
            <%--<td><a href="/logout">Logout</a></td>--%>
        <%--</security:authorize>--%>
        <%--<security:authorize access="hasRole('ROLE_ADMIN')">--%>
            <%--<td><a href="/users">Users</a></td>--%>
        <%--</security:authorize>--%>
    <%--</table>--%>
<%--</header>--%>
<%--<p>Login page</p>--%>





<%--</body>--%>
<%--</html>--%>