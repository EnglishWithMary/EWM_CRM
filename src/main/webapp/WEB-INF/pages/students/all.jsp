<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">

            <div class="panel-heading">
                <strong>List of Students</strong>
            </div>

            <div class="panel-body">
                <div class="row">
                    <div class="col-sm-3">
                        <form method="post" action="/studentSortByDate">
                            <div class="form-group">
                                <input type="submit" value="Sort by Registration Date" class="btn btn-default">
                            </div>
                        </form>
                    </div>
                    <div class="col-sm-9">
                        <div class="row">
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
                            <div class="col-sm-6">
                                <div class="row">
                                    <form action="/studentsSortedByGroup" method="post">
                                        <div class="col-sm-7">
                                            <select name="groupIdList"  class="selectpicker form-control"
                                                    multiple title="Select group">
                                                <option value="0">All groups</option>
                                                <option value="-1">Students without group</option>
                                                <c:forEach var="group" items="${groups}">
                                                    <option value="${group.id}">${group.name}</option>
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
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-striped table-bordered">                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Group</th>
                                <th>Registration Date</th>
                                <th>Comments</th>
                                <th>Testing results</th>
                                <th>Teacher</th>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <th>Delete</th>
                                    <th>Save</th>
                                </security:authorize>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Name</th>
                                <th>Group</th>
                                <th>Registration Date</th>
                                <th>Comments</th>
                                <th>Testing results</th>
                                <th>Teacher</th>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <th>Delete</th>
                                    <th>Save</th>
                                </security:authorize>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="student" items="${students}">
                                <tr>
                                    <td>
                                        <a href="/student/info?student_id=${student.id}">
                                            ${student.person.firstName}
                                            ${student.person.middleName}
                                            ${student.person.lastName}
                                        </a>
                                    </td>
                                    <td><a href="/group/info?group_id=${student.group.id}">${student.group.name}</a></td>
                                    <td>${student.person.registrationDate}</td>
                                    <td><textarea name="comments" cols="16" disabled>${student.person.comments}</textarea></td>
                                    <td>
                                        <a href="/studentTestingResults?id=${student.id}">Testing results</a>
                                    </td>
                                    <td>
                                        <a href="/teacher/info?teacher_id=${student.teacher.id}">${student.teacher.person.firstName}</a>
                                    </td>
                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <td>
                                            <a href="/studentTrash?id=${student.id}">Delete</a>
                                        </td>
                                        <td>
                                            <a href="/studentSave?id=${student.id}">Save</a>
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
                                        <a href="/students?page=${page}&flagSorted=${flagSorted}">
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
                <p><a href="/studentAdd" class="btn btn-success">Add Student</a></p>
            </div>
        </div>
    </div>
</div>
</div>