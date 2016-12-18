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
                            <img class="img-size-sm" alt="Teacher Jojo"
                                 src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Full Name</h4>
                            <p>${teacher.person.lastName}
                                ${fn:substring(teacher.person.firstName,0,1)}.
                                ${fn:substring(teacher.person.middleName,0,1)}.</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h3>Language</h3>
                            <p>(In development)</p>
                            <h5>English</h5>
                            <h5>German</h5>
                            <h5>French</h5>
                            <h5>Italian</h5>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Information About Teacher</strong>
                                </div>
                                <div class="panel-body">
                                    <p><strong>First Name: </strong><input type="text" value="${teacher.person.firstName}"></p>
                                    <p><strong>Last Name: </strong><input type="text" value="${teacher.person.lastName}"></p>
                                    <p><strong>Middle Name: </strong><input type="text" value="${teacher.person.middleName}"></p>
                                    <p><strong>Phone: </strong><input type="text"></p>
                                    <p><strong>Address: </strong><input type="text"></p>
                                    <p><strong>email: </strong><input type="text" value="${teacher.person.email.email}"></p>
                                    <p><strong>web : </strong><a href=""></a><input type="text"></p>
                                    <p><strong>Date of Birth: </strong><input type="date"></p>

                                    <p><strong>Comment: </strong><input type="text" value="${teacher.person.comments}"></p>
                                    <p><strong>Groups: </strong>
                                        <select name="gropus" onchange="location = this.value;">
                                            <option value="Groups" checked>Groups</option>
                                            <c:forEach items="${groups}" var="group">
                                                <option value="/group/info?group_id=${group.id}">${group.name}</option>
                                            </c:forEach>
                                        </select>
                                    </p>

                                    <p><strong>Languages: </strong>
                                        <select name="languages">
                                            <option>English</option>
                                            <option>Spanish</option>
                                            <option>French</option>
                                        </select>
                                    </p>
                                    <p><strong>Referral: </strong><input type="text"></p>
                                    <p><strong>Color: </strong><input type="color"></p>

                                    <p><strong>State: </strong>${teacher.person.state.state}</p>
                                    <p><strong>Last modified: </strong>${teacher.person.modifyDate}</p>
                                    <p><strong>Registration date: </strong>${teacher.person.registrationDate}</p>
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
                                <security:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_MANAGER')">
                                    <a href="/teacherTrash?id=${teacher.id}" class="btn btn-danger">Delete Teacher</a>

                                    <a href="" class="btn btn-success" type="button">Update Teacher</a>

                                    <a href="" class="btn btn-warning" type="button">Create New Teacher</a>
                                </security:authorize>
                            </div>
                            Why not "fire teacher"?
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

