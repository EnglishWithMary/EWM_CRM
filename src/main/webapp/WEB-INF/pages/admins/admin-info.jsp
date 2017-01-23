<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-2">
                    <div class="row">
                        <div class="col-md-12">
                            <img class="img-size-sm" alt="Admin John"
                                 src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Full Name</h4>
                            <p>${admin.person.lastName}
                                ${fn:substring(lead.admin.firstName,0,1)}.
                                ${fn:substring(lead.admin.middleName,0,1)}.</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h3>Some Information</h3>
                            <p>(In development)</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Information About Administrator</strong>
                                </div>
                                <div class="panel-body">

                                    <p><strong>First Name: </strong><input type="text" value="${admin.person.firstName}"></p>
                                    <p><strong>Last Name: </strong><input type="text" value="${admin.person.lastName}"></p>
                                    <p><strong>Middle Name: </strong><input type="text" value="${admin.person.middleName}"></p>
                                    <p><strong>Phone: </strong><input type="text" value=""></p>
                                    <p><strong>email: </strong><input type="text" value="${admin.person.email.email}"></p>
                                    <p><strong>web : </strong><a href=""></a></p>
                                    <p><strong>Date of Birth: </strong><input type="date" value="${admin.person.birthdayDate}"></p>

                                </div>
                            </div>
                        </div>
                    </div>
                    <%--<div class="row">--%>
                        <%--<div class="col-md-12">--%>
                            <%--<div class="btn-group btn-group-md">--%>
                                <%--<a href="" class="btn btn-default" type="button">Some buttons</a>--%>
                                <%--we can use groups--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                </div>
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Calendar</strong>
                                </div>
                                <div class="panel-body">
                                    <div id="calendar"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

