<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <h1 class="page-header">Personnel</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Information about personnel</strong>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <span class="input-group-addon">Sort by:</span>
                                    <select class="form-control">
                                        <option></option>
                                        <option>First Name</option>
                                        <option>Last Name</option>
                                        <option>Personnel Role</option>
                                        <option>Registration Date</option>
                                        <option>Age</option>
                                        <option>Status</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-4">
                                <div class="input-group">
                                    <span class="input-group-addon">Personnel's Role:</span>
                                    <select class="form-control">
                                        <option></option>
                                        <option>ADMIN</option>
                                        <option>MANAGER</option>
                                        <option>TEACHER</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-sm-3">
                                <div class="input-group">
                                    <span class="input-group-addon">Status:</span>
                                    <select class="form-control">
                                        <option></option>
                                        <option>ACTIVE</option>
                                        <option>DELETED</option>
                                        <option>BLOCKED</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="padding-bot"></div>
                    <div class="col-sm-12">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>Full Name</th>
                                <th>Login</th>
                                <th>Role</th>
                                <th>State</th>
                                <th>Birth Date</th>
                                <th>Reg. Date</th>
                                <th>Mod. Date</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="person" items="${personnel}">
                                <tr>
                                    <td>
                                            ${person.lastName} ${fn:substring(person.firstName, 0, 1)}. ${fn:substring(person.middleName, 0, 1)}.
                                    </td>
                                    <td>${person.login}</td>
                                    <td>${person.role}</td>
                                    <td>${person.state}</td>
                                    <td>${person.birthdayDate}</td>
                                    <td>${person.registrationDate}</td>
                                    <td>${person.modifyDate}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-sm-2 col-sm-offset-5">
                            <c:if test="${pages > 1}">
                                <ul class="pagination">
                                    <c:forEach var="page" begin="1" end="${pages}">
                                        <li class="${(page eq param.page) or ((param.page eq null) and (page eq 1))? 'active' : ''}">
                                            <a href="/persons?page=${page}">
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
        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Tool's Panel</strong>
                </div>
                <div class="panel-body">
                    <h4>Add person</h4>
                    <p>
                        <button class="btn btn-success" type="button">Add Admin</button>
                        <button class="btn btn-success" type="button">Add Manager</button>
                        <button class="btn btn-success" type="button">Add Teacher</button>
                    </p>
                    <h4>Some Statistics</h4>
                    <p>In development</p>
                </div>
            </div>
        </div>
    </div>
</div>

