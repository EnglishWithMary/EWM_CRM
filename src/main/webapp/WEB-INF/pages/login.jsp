<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
            <input type="text" class="form-control" name="username" placeholder="Login" required="" autofocus="" />
            <input type="password" class="form-control" name="password" placeholder="Password" required=""/>
            <%--<label class="checkbox">--%>
            <%--&lt;%&ndash;<input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> Remember me&ndash;%&gt;--%>
            <%--</label>--%>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </div>
</div>
</body>
</html>