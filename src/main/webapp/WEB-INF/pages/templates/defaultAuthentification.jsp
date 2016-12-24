<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="right">
    <security:authorize access="isAnonymous()">
        <a href="/login" style="float: right;" class="button alt">Log in</a>
    </security:authorize>
    <security:authorize access="isAuthenticated()">
        <ul class="mainmenu">
            <li style="float: right;"><a href="/logout" class="button alt">Log out</a></li>
            <li style="float: right;"><a href="/personProfile" class="button alt" >Profile</a></li>
            <li><a href="#" class="button alt">Pipeline</a><!--/pipeline-->
                <ul class="submenu">
                <li><a href="/takeLeadtpipe" class="button alt">Leads</a></li>
                <li><a href="/takeStudentpipe" class="button alt">Students</a></li>
                </ul>
            </li>
        </ul>
    </security:authorize>
</nav>
