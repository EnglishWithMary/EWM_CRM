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

                                    <sf:form method="post" modelAttribute="teacherDTO" id="form" action="/students/save">
                                        <fieldset class="form-group">

                                            <div class="row padding-bot">
                                                <%--<div class="col-sm-1"></div>--%>
                                                    <div class="col-sm-4">
                                                        <sf:label path="firstName">First Name:</sf:label>
                                                    </div>
                                                    <div class="col-sm-8">
                                                        <sf:input path="firstName" cssClass="form-control"/>
                                                        <sf:errors path="firstName" cssClass="has-error"/>
                                                    </div>
                                            </div>
                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="lastName">Last Name:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:input path="lastName" cssClass="form-control"/>
                                                    <sf:errors path="lastName" cssClass="has-error"/>
                                                </div>
                                            </div>
                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="middleName">Middle Name:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:input path="middleName" cssClass="form-control"/>
                                                    <sf:errors path="middleName" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="phone">Phone:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:input path="phone" cssClass="form-control"/>
                                                    <sf:errors path="phone" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="address">Address:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:input path="address" cssClass="form-control"/>
                                                    <sf:errors path="address" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="email">email:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:input path="email" cssClass="form-control"/>
                                                    <sf:errors path="email" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="web">web:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <a href="${teacherDTO.web}">
                                                    <sf:input path="web" cssClass="form-control"/>
                                                    </a>
                                                    <sf:errors path="web" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="birthdayDate">Date of Birth:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:input path="birthdayDate" cssClass="form-control" type="date"/>
                                                    <sf:errors path="birthdayDate" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="comments">Comments:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:textarea path="comments" cssClass="form-control"/>
                                                    <sf:errors path="comments" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <label>Groups:</label>
                                                </div>
                                                <div class="col-sm-8">

                                                    <select class="form-control" multiple>
                                                        <c:forEach var="group" items="${groups}" >
                                                            <option value="/groups/info?group_id=${group.id}">${group.name}</option>
                                                        </c:forEach>
                                                    </select>

                                                    <%--<select name="groups" onchange="location = this.value;">--%>
                                                        <%--<option value="Groups" checked>Groups</option>--%>
                                                        <%--<c:forEach items="${groups}" var="group">--%>
                                                            <%--<option value="/groups/info?group_id=${group.id}">${group.name}</option>--%>
                                                        <%--</c:forEach>--%>
                                                    <%--</select>--%>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <label>Languages:</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <select class="form-control" multiple>
                                                        <c:forEach var="lang" items="${languages}" >
                                                            <option value="${lang.id}">${lang.language}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="referral">Referral:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:input path="referral" cssClass="form-control"/>
                                                    <sf:errors path="referral" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="color">Color:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:input path="color" cssClass="form-control" type="color"/>
                                                    <sf:errors path="color" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <label>State:</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <c:out value="${teacherDTO.state}"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <label>Last modified:</label>
                                                </div>
                                                    <div class="col-sm-8">
                                                        <c:out value="${teacherDTO.modifyDate}"/>
                                                    </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <label>Registration date:</label>
                                                </div>
                                                    <div class="col-sm-8">
                                                        <c:out value="${teacherDTO.registrationDate}"/>
                                                    </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <sf:label path="organization">Organization:</sf:label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <sf:input path="organization" cssClass="form-control"/>
                                                    <sf:errors path="organization" cssClass="has-error"/>
                                                </div>
                                            </div>

                                            <div class="row padding-bot">
                                                <div class="col-sm-4">
                                                    <label>Knowledge level:</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <c:out value="${teacherDTO.teacherLevel}"/>
                                                </div>
                                            </div>

                                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                                <div class="row padding-bot">
                                                    <div class="col-sm-4">
                                                        <label>Set knowledge level:</label>
                                                    </div>
                                                    <div class="col-sm-8">
                                                        <select class="form-control">
                                                            <c:forEach var="level" items="${levels}">
                                                                <option value="${level}">${level}</option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            </security:authorize>
                                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                                <div class="row padding-bot">
                                                    <div class="col-sm-4">
                                                        <sf:label path="salary">Salary:</sf:label>
                                                    </div>
                                                    <div class="col-sm-8">
                                                        <sf:input path="salary" cssClass="form-control"/>
                                                        <sf:errors path="salary" cssClass="has-error"/>
                                                    </div>
                                                </div>
                                            </security:authorize>

                                        </fieldset>
                                    </sf:form>

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

