<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Authentication</title>
</head>
<body>
<script>
    window.onload = function () {
        document.getElementById('username_or_email').focus();
    };
</script>
<div>
    <h2>Sign in to proceed</h2>
    <p>Authentication</p>

    <%-- WTF IS HERE? NEED TO BE CHANGED--%>
    <%--
    <spring:url var="authUrl" value="/login_security_check" />

    <form method="post" class="signin" action="${authUrl}">
    --%>
    <form method="post" class="signin" action="/login_security_chek">
        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th><label for="username_or_email">Username or Email</label></th>
                    <td><input id="username_or_email" name="j_username" type="text" /></td>
                </tr>
                <tr>
                    <th><label for="password">Password</label></th>
                    <td><input id="password" name="j_password" type="password" />
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
                    <td><input name="commit" type="submit" value="Sign In" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
</div>
</body>
</html>
