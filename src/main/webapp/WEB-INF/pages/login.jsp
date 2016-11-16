<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/styles.css" rel="stylesheet">
</head>
<body onload='document.loginForm.username.focus();'>
<div id="container">
    <div class="wrapper">
        <form class="form-signin" name='loginForm'
              action='/security_check' method='POST'>
            <h3 class="form-signin-heading">Enter your login</h3>

            <c:if test="${not empty error}">
            <div class="error">${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
            </c:if>

            <hr class="colorgraph"><br>
            <input type="text" class="form-control" name="username" placeholder="Email Address" required="" autofocus="" />
            <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
            <%--<label class="checkbox">--%>
                <%--&lt;%&ndash;<input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me&ndash;%&gt;--%>
            <%--</label>--%>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>

    </div>
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