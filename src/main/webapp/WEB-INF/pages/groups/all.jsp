<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">Groups</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>All Groups</strong>
            </div>
            <div class="panel-body">
                <div class="row">
                    <sf:form method="post" modelAttribute="groupFilter" action="/groupFilter">
                        <div class="col-sm-5">
                            <div class="input-group">
                                <span class="input-group-addon">By teacher:</span>
                                <sf:select path="teacherId" class="form-control">
                                    <sf:option value=""></sf:option>
                                    <c:forEach items="${teachers}" var="teach">
                                        <sf:option value="${teach.id}">
                                            ${teach.user.login} (
                                            ${teach.person.firstName}
                                            ${teach.person.middleName}
                                            ${teach.person.lastName}
                                            )</sf:option>
                                    </c:forEach>
                                </sf:select>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <input type="submit" class="btn btn-default" value="Filter">
                        </div>
                    </sf:form>
                </div>
                <div class="row padding-bot"></div>
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>Group Name</th>
                                <th>Group's Teacher</th>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <th>Delete Group</th>
                                </security:authorize>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="group" items="${groups}">
                                <tr>
                                    <td>${group.name}</td>
                                    <td>
                                            ${group.teacher.person.firstName}${" "}
                                            ${group.teacher.person.middleName}${" "}
                                            ${group.teacher.person.lastName}${" "}
                                    </td>
                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <td>
                                            <a href="/teacherDelete?id=${teacher.id}">Delete</a>
                                        </td>
                                    </security:authorize>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <p><a class="button alt" href="/groupAdd">Add Group</a></p>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Tools</strong>
            </div>
            <div class="panel-body">
                Kitten was here
            </div>
        </div>
    </div>
</div>
