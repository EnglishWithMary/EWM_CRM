<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <strong>Information about Group</strong>
                        </div>
                        <div class="panel-body">
                            <p><strong>Group Name: </strong>${group.name}</p>

                            <p><strong>Group Teacher:</strong>
                                <a href="/teacher/info?${group.teacher.id}">${group.teacher.person.firstName}</a></p>

                            <p><strong>Studying Language:</strong>English(null)</p>

                            <p><strong>Common Schedule:</strong>Tue(18:00-20:00), Wed(18:00-20:00)...</p>

                            <p><strong>Students:</strong></p>

                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>Full Name</th>
                                    <th>Age</th>
                                    <th>Language</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <c:forEach items="${group.students}" var="student">
                                        <th><a href="/student/info?student_id=${student.id}">
                                                    ${student.person.lastName}
                                                    ${fn:substring(student.person.firstName,0,1)}.
                                                    ${fn:substring(student.person.middleName,0,1)}.
                                            </a>
                                        </th>
                                        <th>null</th>
                                        <th>null</th>
                                    </c:forEach>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Tools
                        </div>
                        <div class="panel-body">
                            <p>
                                <a href="" class="btn btn-success" type="button">Add Student</a>
                                <a href="" class="btn btn-warning" type="button">Change Teacher</a>
                                <a href="" class="btn btn-danger" type="button">Close Group</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-6">

            <!--Here goes calendar for group-->

            <%--WARNING!!!--%>
            <%--DO NOT CHANGE ANYTHING!!!--%>
            <div class="row">
                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <strong>Group's Schedule</strong>
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

