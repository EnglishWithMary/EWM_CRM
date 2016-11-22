<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
<header>
    <div align="right">User:<security:authentication property="principal.username"/></div>
    <table>
        <td><a href="/home">Home</a></td>
        <td><a href="/dep">Departments</a></td>
        <security:authorize access="isAnonymous()">
            <td><a href="/login">Login</a></td>
        </security:authorize>
        <security:authorize access="isAuthenticated()">
            <td><a href="/logout">Logout</a></td>
        </security:authorize>
        <security:authorize access="hasRole('ROLE_ADMIN')">
            <td><a href="/users">Users</a></td>
        </security:authorize>
    </table>
</header>

<script>
    window.onload = function () {
        document.getElementById('username_or_email').focus();
    };
</script>
<div>
    <h2>Sign in to proceed</h2>
    <p>Authentication</p>

    <form method="post" class="signin" action="/login_security_chek">
        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th><label for="username_or_email">Username or Email</label></th>
                    <td><input id="username_or_email" name="j_username" type="text"/></td>
                </tr>
                <tr>
                    <th><label for="password">Password</label></th>
                    <td><input id="password" name="j_password" type="password"/>
                        <small><a href="/account/resend_password">Restore password</a></small>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td><input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
                        <label for="remember_me" class="inline">Remember me</label></td>
                </tr>
                <tr>
                    <th></th>
                    <td><input name="commit" type="submit" value="Sign In"/></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>