<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<security:authorize access="isAuthenticated()">
<nav class="left">
    <a href="#menu"><span>Menu</span></a>
</security:authorize>

</nav>
<a href="/home" class="logo">Mary</a>