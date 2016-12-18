<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
                        <table id = "table-list" class="table table-striped table-bordered">                            <thead>
                            <tr>
                                <th>Group Name</th>
                                <th>Group's Teacher</th>
                                <th>Language</th>
                                <th>Status</th>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <th>Delete</th>
                                    <th>Save</th>
                                </security:authorize>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Group Name</th>
                                <th>Group's Teacher</th>
                                <th>Language</th>
                                <th>Status</th>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <th>Delete</th>
                                    <th>Save</th>
                                </security:authorize>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="group" items="${groups}">
                                <tr>
                                    <td><a href="/group/info?group_id=${group.id}" alt="Group Profile">${group.name}</a></td>
                                    <td>
                                        <a href="/teacher/info?teacher_id=${group.teacher.id}" alt="Teacher Profile">
                                                ${group.teacher.person.firstName}${" "}
                                                ${group.teacher.person.middleName}${" "}
                                                ${group.teacher.person.lastName}${" "}
                                        </a>
                                    </td>
                                    <td>!add language</td>
                                    <td>!add status</td>
                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <td>
                                            <a href="/teacherDelete?id=${teacher.id}">Delete</a>
                                        </td>
                                        <td>
                                            <a href="/teacherSave?id=${teacher.id}">Save</a>
                                        </td>
                                    </security:authorize>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2 col-sm-offset-5">
                        <c:if test="${pages > 1}">
                            <ul class="pagination">
                                <c:forEach var="page" begin="1" end="${pages}">
                                    <li class="${(page eq param.page) or ((param.page eq null) and (page eq 1))? 'active' : ''}">
                                        <a href="/groups?page=${page}&flagSorted=${flagSorted}">
                                                ${page}
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Tools</strong>
            </div>
            <div class="panel-body">
                <p><a class="btn btn-success" href="/groupAdd">Add Group</a></p>
            </div>
        </div>
    </div>
</div>
