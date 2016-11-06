<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<nav class="left">
    <a href="#menu"><span>Menu</span></a>
</nav>
<a href="/home" class="logo">English with Mary</a>

    <security:authorize access="isAuthenticated()">
        <security:authentication var="user" property="principal"/>
    <p>${user.username}</p>
    </security:authorize>