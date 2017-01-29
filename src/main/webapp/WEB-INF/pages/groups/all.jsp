<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>All Groups</strong>
            </div>
            <div class="panel-body">
                <div class="row">
                    <sf:form method="post" modelAttribute="groupFilter" action="/groups/filter">
                        <div class="col-sm-5">
                            <div class="input-group">
                                <span class="input-group-addon">By teacher:</span>
                                <sf:select path="teacherId" class="form-control">
                                    <sf:option value=""></sf:option>
                                    <c:forEach items="${teachers}" var="teach">
                                        <sf:option value="${teach.id}">
                                            ${teach.person.lastName}
                                            ${teach.person.firstName}
                                            ${teach.person.middleName}
                                            </sf:option>
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
                                <th>Language</th>
                                <th>Status</th>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <th>Delete Group</th>
                                </security:authorize>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="group" items="${groups}">
                                <tr>
                                    <td><a href="/groups/${group.id}/info" alt="Group Profile">${group.name}</a></td>
                                    <td>
                                        <a href="/teachers/info?teacher_id=${group.teacher.id}" alt="Teacher Profile">
                                                ${group.teacher.person.firstName}${" "}
                                                ${group.teacher.person.middleName}${" "}
                                                ${group.teacher.person.lastName}${" "}
                                        </a></td>
                                    <td>${group.language}</td>
                                    <td>!add status</td>
                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <td>
                                            <a href="/teachers/delete?id=${teacher.id}">Delete</a>
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
                <p><a class="btn btn-success" href="/groups/add">Add Group</a></p>
            </div>
        </div>
    </div>
</div>
