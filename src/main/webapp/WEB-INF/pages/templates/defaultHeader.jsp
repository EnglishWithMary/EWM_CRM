<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
        <security:authorize access="isAuthenticated()">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a id="logo" class="navbar-brand" href="/home">Mary</a>
            </div>
        </security:authorize>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <security:authorize access="isAuthenticated()">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true"
                           aria-expanded="false">Admin tools <span class="caret"></span> </a>
                        <ul class="dropdown-menu">
                            <li><a href="/users">All Users</a></li>
                            <li><a href="#">...</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true"
                           aria-expanded="false">Managing <span class="caret"></span> </a>
                        <ul class="dropdown-menu">
                            <li><a href="/teachers">Teachers</a></li>
                            <li><a href="/managers">Managers</a></li>
                            <li><a href="/students">Students</a></li>
                            <li><a href="/leads">Leads</a></li>
                            <li><a href="/schedules">Schedules</a></li>
                            <li><a href="/payments">Payments</a></li>
                            <li><a href="/groups">Groups</a></li>
                            <li><a href="/events">Events</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true"
                           aria-expanded="false">Pipelines <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/takeStudentpipe">Students</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/takeLeadtpipe">Leads</a></li>
                        </ul>
                    </li>
                </ul>
                <!--Search in All fields-->
                <form class="navbar-form navbar-left">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Search</button>
                </form>
            </security:authorize>
            <!--Logo and log out-->
            <ul class="nav navbar-nav navbar-right">
                <security:authorize access="isAuthenticated()">
                    <li class="minimize-it">
                        <a href="/personProfile">
                        <c:choose>
                            <c:when test="${person.avatarURL == null}">
                                <img class="img-size-vsm" alt="Responsive image"
                                     src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                            </c:when>
                            <c:otherwise>
                                <img class="img-size-vsm" alt="Responsive image"
                                     src="${person.avatarURL}">
                            </c:otherwise>
                        </c:choose>
                            Profile
                        </a>
                    </li>

                </security:authorize>
                <li>
                    <security:authorize access="isAuthenticated()">
                        <form class=" navbar-form" action="/logout">
                            <button type="submit" class="btn btn-default">Log Out</button>
                        </form>
                    </security:authorize>
                    <security:authorize access="isAnonymous()">
                        <form class=" navbar-form" action="/login">
                            <button type="submit" class="btn btn-default">Log In</button>
                        </form>
                    </security:authorize>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
