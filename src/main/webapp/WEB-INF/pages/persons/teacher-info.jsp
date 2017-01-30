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
                            <c:forEach var="lang" items="${teacher.languages}" >
                                <p>${lang.language}</p>
                            </c:forEach>
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
                                    <p><strong>First Name: </strong><input type="text"
                                                                           value="${teacher.person.firstName}"></p>
                                    <p><strong>Last Name: </strong><input type="text"
                                                                          value="${teacher.person.lastName}"></p>
                                    <p><strong>Middle Name: </strong><input type="text"
                                                                            value="${teacher.person.middleName}"></p>
                                    <p><strong>Phone: </strong><input type="text"></p>
                                    <p><strong>Address: </strong><input type="text"></p>
                                    <p><strong>email: </strong><input type="text" value="${teacher.person.email.email}">
                                    </p>
                                    <p><strong>web : </strong><a href=""></a><input type="text"></p>
                                    <p><strong>Date of Birth: </strong><input type="date"></p>

                                    <p><strong>Comment: </strong></p>

                                    <p><textarea name="comments" form="comments"
                                                 cols="30">${teacher.person.comments}</textarea>
                                    <form id=comments method="post" modelAttribute="teacher.person"
                                          action="/teachers/UpdateComments">
                                        <input name="id" type=hidden value="${teacher.id}">
                                        <%--<input name="role" type=hidden value="2">--%>
                                        <security:authorize access="hasRole('ROLE_ADMIN')">
                                            <input type="submit" value="Submit comment"/>
                                        </security:authorize>
                                    </form>
                                    </p>

                                    <p><strong>Groups: </strong>
                                        <select name="groups" onchange="location = this.value;">
                                            <option value="Groups" checked>Groups</option>
                                            <c:forEach items="${groups}" var="group">
                                                <option value="/groups/info?group_id=${group.id}">${group.name}</option>
                                            </c:forEach>
                                        </select>
                                    </p>

                                    <div class="row padding-bot">
                                        <div class="col-sm-3">
                                            <label>Languages:</label>
                                        </div>
                                        <div class="col-sm-9">
                                            <select class="form-control" multiple>
                                                <c:forEach var="lang" items="${languages}" >
                                                    <option value="${lang.id}">${lang.language}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <p><strong>Referral: </strong><input type="text"></p>
                                    <p><strong>Color: </strong><input type="color"></p>

                                    <p><strong>State: </strong>${teacher.person.state.state}</p>
                                    <p><strong>Last modified: </strong>${teacher.person.modifyDate}</p>
                                    <p><strong>Registration date: </strong>${teacher.person.registrationDate}</p>
                                    <p><strong>Organization: </strong><input type="text"></p>

                                    <p><strong>Knowledge level: </strong>${teacher.level}</p>

                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <div class="row padding-bot">
                                            <div class="col-sm-1"></div>
                                            <div class="col-sm-4">
                                                <label>Set knowledge level:</label>
                                            </div>
                                            <div class="col-sm-6">
                                                <select class="form-control" multiple>
                                                    <c:forEach var="level" items="${languages}" >
                                                        <option value="${level}">${level}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </security:authorize>

                                    <%--<c:forEach var="lang" items="${languages}" >--%>
                                        <%--<option value="${lang.id}">${lang.language}</option>--%>
                                    <%--</c:forEach>--%>

                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <p><strong>Set knowledge level: </strong></p>
                                        <form action="/teachers/setTeacherLevel" method="get">
                                            <input type="hidden" name="teacher_id" value="${teacher.id}">
                                            <tr>
                                                <td><input type="radio" name="level" value="0" checked>JUNIOR_1</td>
                                                <td></td>
                                                <td><input type="radio" name="level" value="3">MIDDLE_1</td>
                                                <td></td>
                                                <td><input type="radio" name="level" value="6">SENIOR_1</td>
                                                <td></td>
                                            </tr>
                                            <br>
                                            <tr>
                                                <td><input type="radio" name="level" value="1">JUNIOR_2</td>
                                                <td></td>
                                                <td><input type="radio" name="level" value="4">MIDDLE_2</td>
                                                <td></td>
                                                <td><input type="radio" name="level" value="7">SENIOR_2</td>
                                                <td></td>
                                            </tr>
                                            <br>
                                            <tr>
                                                <td><input type="radio" name="level" value="2">JUNIOR_3</td>
                                                <td><input type="radio" name="level" value="5">MIDDLE_3</td>
                                                <td><input type="radio" name="level" value="8">SENIOR_3</td>
                                            </tr>
                                            <br>
                                            <input type="submit">
                                        </form>
                                    </security:authorize><br>

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
                                    <a href="/teachers/trash?id=${teacher.id}" class="btn btn-danger">Delete Teacher</a>

                                    <a href="/teacherSave" class="btn btn-success" type="submit">Update Teacher</a>

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

