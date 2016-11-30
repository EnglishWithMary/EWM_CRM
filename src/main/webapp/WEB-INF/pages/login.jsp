<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="container">
    <form class="form-signin" name='loginForm' action='/security_check' id="formLogin" method='POST'>
        <h3 class="form-signin-heading">Enter your login</h3>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <hr class="colorgraph">
        <br>
        <input type="text" class="form-control" id="username" name="username" placeholder="Login" required="" autofocus=""/>
        <input type="password" class="form-control" id="pass" name="password" placeholder="Password" required=""/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
    </form>
</div>
