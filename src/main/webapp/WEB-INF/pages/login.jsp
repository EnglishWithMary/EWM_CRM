<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <meta charset="UTF-8">
    <link rel='stylesheet prefetch' href="/resources/assets/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/assets/css/style.css">
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
                <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe" > Remember me
            </label>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>

                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
    </div>
    </form>
</div>
</body>
</html>