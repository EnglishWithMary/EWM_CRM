<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<nav class="left">
    <a href="#menu"><span>Menu</span></a>

</nav>
<a href="/home" class="logo">Mary</a>

<nav class="listButton">
            <a href="/listView" class="button alt">List view</a>
</nav>


    <security:authorize access="isAuthenticated()">
        <security:authentication var="user" property="principal"/>
        <p>${user.username}</p>
    </security:authorize>