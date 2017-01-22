<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>List of Teachers</strong>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-3">
                        <form method="post" action="/teacherSortByDate">
                            <div class="form-group">
                                <input type="submit" value="Sort by Registration Date" class="btn btn-default">
                            </div>
                        </form>
                    </div>
                    <div class="col-sm-6">
                        <div class="row">
                            <form method="get" action="/students">
                                <div class="col-sm-7">
                                    <select name="teacher_id" class="selectpicker form-control"
                                            data-actions-box="true" data-size="5">
                                        <option value="">All teachers</option>
                                        <option value="-1">Students without teachers</option>
                                        <c:forEach var="teacher" items="${teachers}">
                                            <option value="${teacher.id}">${teacher.person.firstName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-5">
                                    <input type="submit" class="btn btn-default" value="Find"/>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <%--<div class="table-wrapper">--%>
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Registration Date</th>
                        <th>Comments</th>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <th>Delete</th>
                            <th>Save</th>
                        </security:authorize>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Name</th>
                        <th>Registration Date</th>
                        <th>Comments</th>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <th>Delete</th>
                            <th>Save</th>
                        </security:authorize>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="teacher" items="${teachers}">
                        <tr>
                            <td>
                                <a href="/teacher/info?teacher_id=${teacher.id}">
                                    ${teacher.person.firstName}
                                    ${teacher.person.middleName}
                                    ${teacher.person.lastName}
                                </a>
                            </td>
                            <td>${teacher.person.registrationDate}</td>
                            <td><textarea name="comments" cols="16" disabled>${teacher.person.comments}</textarea></td>
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                            <td>
                                <a href="/teacherTrash?id=${teacher.id}">Delete</a>
                            </td>
                            <td>
                                <a href="/teacherSave?id=${teacher.id}">Save</a>
                            </td>
                            </security:authorize>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="text-center">
                        <c:if test="${pages > 1}">
                            <ul class="pagination">
                                <c:forEach var="page" begin="1" end="${pages}">
                                    <li class="${(page eq param.page) or ((param.page eq null) and (page eq 1))? 'active' : ''}">
                                        <a href="/teachers?page=${page}&flagSorted=${flagSorted}">
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

                <%--</div>--%>
            </div>
        </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Tools</strong>
            </div>
            <div class="panel-body">
                <p><a href="/teacherAdd" class="btn btn-success">Add Teacher</a></p>
            </div>
        </div>
    </div>
</div>
