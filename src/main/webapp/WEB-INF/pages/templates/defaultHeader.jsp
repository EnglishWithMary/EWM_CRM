<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<security:authorize access="isAuthenticated()">
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container-fluid">
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

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
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
                <!--Logo and log out-->

                <ul class="nav navbar-nav navbar-right">
                    <li class="minimize-it">
                        <a href="#" >
                            <img class="img-size-vsm" alt="Vasyl Zaratustra" src="img/default.avatar.png" />
                            Vasyl Zaratustra
                        </a>
                    </li>
                    <li>
                        <form class=" navbar-form">
                            <%--<div class="form-group">--%>
                            <%--</div>--%>
                            <button type="submit" class="btn btn-default">Log Out</button>
                        </form>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</security:authorize>