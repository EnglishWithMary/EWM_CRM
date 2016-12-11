<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">Teachers list</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>List of Teachers</strong>
            </div>
            <div class="panel-body">
                <form method="post" action="/teacherSortByDate">
                    <div class="form-group">
                        <input type="submit" value="Sort by Registration Date" class="btn btn-default">
                    </div>
                </form>

                <%--<div class="table-wrapper">--%>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Middle name</th>
                        <th>Registration Date</th>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <th>Delete Teacher</th>
                        </security:authorize>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="teacher" items="${teachers}">
                        <tr>
                            <td><a href="/teacher/info?teacher_id=${teacher.id}">${teacher.person.firstName}</a></td>
                            <td>${teacher.person.lastName}</td>
                            <td>${teacher.person.middleName}</td>
                            <td>${teacher.person.registrationDate}</td>
                            <td>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <a href="/teacherTrash?id=${teacher.id}">Delete</a>
                                </security:authorize>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <%--</div>--%>
            </div>
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
