<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
                                            <select name="teacher_id" class="form-control">
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
                                    <form action="/studentsSortedByGroup" method="get">
                                        <div class="col-sm-7">
                                            <select name="group_id" class="form-control">
                                                <option value="">All groups</option>
                                                <option value="-1">Students without group</option>
                                                <c:forEach var="group" items="${groups}">
                                                    <option value="${group.id}">
                                                            ${group.name}</option>
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
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Middle name</th>
                                <th>Student group</th>
                                <th>Registration Date</th>
                                <th>Comments</th>
                                <th>Testing results</th>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <th>Delete Student</th>
                                </security:authorize>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="student" items="${students}">
                                <tr>
                                    <td>${student.person.firstName}</td>
                                    <td>${student.person.lastName}</td>
                                    <td>${student.person.middleName}</td>
                                    <td>${student.group.name}</td>
                                    <td>${student.person.registrationDate}</td>
                                    <td>${student.person.comments}</td>
                                    <td>
                                        <a href="/studentTestingResults?id=${student.id}">Testing results</a>
                                    </td>
                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <td>
                                            <a href="/studentTrash?id=${student.id}">Delete</a>
                                        </td>
                                    </security:authorize>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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