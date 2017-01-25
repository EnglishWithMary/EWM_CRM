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
                            <img class="img-size-sm" alt="Manager John"
                                 src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Full Name</h4>
                            <p>${manager.person.lastName}
                                ${fn:substring(manager.person.firstName,0,1)}.
                                ${fn:substring(manager.person.middleName,0,1)}.</p>
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
                                    <strong>Information About Manager</strong>
                                </div>
                                <div class="panel-body">

                                    <p><strong>First Name: </strong><input type="text" value="${manager.person.firstName}"></p>
                                    <p><strong>Last Name: </strong><input type="text" value="${manager.person.lastName}"></p>
                                    <p><strong>Middle Name: </strong><input type="text" value="${manager.person.middleName}"></p>
                                    <p><strong>Phone: </strong><input type="text" value=""></p>
                                    <p><strong>email: </strong><input type="text" value="${manager.person.email.email}"></p>
                                    <p><strong>web : </strong><a href=""></a><input type="text"></p>
                                    <p><strong>Date of Birth: </strong><input type="date" value="${manager.person.birthdayDate}"></p>
                                    <p><strong>Comment: </strong></p>

                                    <p><textarea name="comments" form="comments" cols="30">${manager.person.comments}</textarea>
                                    <form id=comments method="post" modelAttribute="manager.person" action="/managers/UpdateComments">
                                        <input name="id" type=hidden value="${manager.id}">
                                        <%--<input name="role" type=hidden value="2">--%>
                                        <security:authorize access="hasRole('ROLE_ADMIN')">
                                            <input type="submit" value="Submit comment"/>
                                        </security:authorize>
                                    </form></p>

                                    <p><strong>State: </strong>${manager.person.state.state}</p>
                                    <p><strong>Last modified: </strong>${manager.person.modifyDate}</p>
                                    <p><strong>Registration date: </strong>${manager.person.registrationDate}</p>
                                    <p><strong>Organization: </strong><input type="text"></p>

                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <p><strong>Salary: </strong><input type="text"></p>
                                    </security:authorize>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="btn-group btn-group-md">
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <a href="/managers/trash?id=${manager.id}" class="btn btn-danger">Delete Manager</a>
                                        <a href="" class="btn btn-success" type="button">Update Manager</a>
                                        <a href="" class="btn btn-warning" type="button">Create New Manager</a>
                                </security:authorize>
                            </div>
                        </div>
                    </div>
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

