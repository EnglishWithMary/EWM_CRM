<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">Students</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">

            <div class="panel-heading">
                <strong>List of Students</strong>
            </div>

            <div class="panel-body">

                <form method="get" action="/students">
                    <div class="row form-group">
                        <div class="col-sm-2">
                            Filter by:
                        </div>
                        <div class="col-sm-3">
                            <select name="studentSortByDate" class="selectpicker form-control"
                                    data-actions-box="true" data-size="5" title="Registration Date">
                                <option value="">Registration Date</option>
                                <option value="ASC" <c:if test="${sortDirection == 'ASC'}">selected</c:if>>Reg Date ASC</option>
                                <option value="DESC" <c:if test="${sortDirection == 'DESC'}">selected</c:if>>Reg Date DESC</option>
                            </select>
                        </div>

                        <div class="col-sm-3">
                            <select name="teacher_id" class="selectpicker form-control"
                                    data-actions-box="true" data-size="5">
                                <option value="">Teacher</option>
                                <option value="-1">Students without teachers</option>
                                <c:forEach var="teacher" items="${teachers}">
                                    <option value="${teacher.id}"
                                            <c:if test="${teacherId == teacher.id}">
                                                selected</c:if>
                                    >${teacher.person.firstName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <select name="group_id_list"  class="selectpicker form-control"
                                    multiple title="Group">
                                <option value="0">All groups</option>
                                <option value="-1">Students without group</option>
                                <c:forEach var="group" items="${groups}">
                                    <option value="${group.id}"
                                            <c:if test="${fn:contains(groupIdList,group.id)}">selected</c:if>
                                    >${group.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-sm-2">
                            <input type="submit" class="btn btn-default" value="Find"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-12">
                            <table class="table table-striped table-bordered">   <!-- id = "table-list"-->                         <thead>
                                <tr>
                                    <th>First name</th>
                                    <th>Last name</th>
                                    <th>Middle name</th>
                                    <th>Student group</th>
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
                                    <th>First name</th>
                                    <th>Last name</th>
                                    <th>Middle name</th>
                                    <th>Student group</th>
                                    <th>Registration Date</th>
                                    <th>Comments</th>
                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <th>Delete</th>
                                        <th>Save</th>
                                    </security:authorize>
                                </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach var="student" items="${students}">
                                    <tr>
                                        <td><a href="/student/info?student_id=${student.id}">${student.person.firstName}</a></td>
                                        <td>${student.person.lastName}</td>
                                        <td>${student.person.middleName}</td>
                                        <td><a href="/group/info?group_id=${student.group.id}">${student.group.name}</a></td>
                                        <td>${student.person.registrationDate}</td>
                                        <td>${student.person.comments}</td>
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
                                <div class="container">
                                    <div class="input-group pagination">
                                        <div class="input-group-btn">
                                            <c:forEach var="page" begin="1" end="${pages}">
                                                <input class="btn btn-default ${(page eq param.page) or ((param.page eq null) and (page eq 1))? 'active' : ''}" type="submit" name="page" value="${page}"/>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </form>
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