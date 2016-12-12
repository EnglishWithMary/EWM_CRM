<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="12u">
    <p>Persons</p>

    <form method="post" action="/personSortByDate">
        <div class="form-group">
            <input type="submit" value="Sort by Registration Date">
        </div>
    </form>

    <table>
        <tr>
            <td>Person Full Name</td>
            <td>Persons Registration Date</td>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <td>Delete Person</td>
            </security:authorize>
        </tr>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td>
                        ${person.firstName}
                        ${person.middleName}
                        ${person.lastName}
                </td>
                <td>
                        ${person.registrationDate}
                </td>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <td>
                        <a href="/personDelete?id=${person.id}">Delete</a>
                    <td>
                </security:authorize>
            </tr>
        </c:forEach>
    </table>
</div>


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
                            <div class="col-sm-4    ">
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
                                <th>Status</th>
                                <th>Reg. Date</th>
                                <th>Mod. Date</th>
                                <th>Last login</th>
                                <th>Age</th>
                                <th>Email</th>
                                <th>Role</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th>Strange J..</th>
                                <th><a href="TeacherInfo.html">jojoaa</a></th>
                                <th>active</th>
                                <th>Jan 01, 2016</th>
                                <th>Jan 01, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>24</th>
                                <th>jojoishere@jojo.com</th>
                                <th>teacher</th>
                            </tr>
                            <tr>
                                <th>Johnson J.O.</th>
                                <th><a href="ManagerInfo.html">johnjohn</a></th>
                                <th>active</th>
                                <th>Aug 24, 2016</th>
                                <th>Aug 24, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>28</th>
                                <th>johnsjohhn@yo.com</th>
                                <th>manager</th>
                            </tr>
                            <tr>
                                <th>Vasyl Z.I.</th>
                                <th>vaszar1</th>
                                <th>active</th>
                                <th>Sep 16, 2016</th>
                                <th>Sep 16, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>78</th>
                                <th>vasyl1964@mail.nowhere</th>
                                <th>admin</th>
                            </tr>
                            <tr>
                                <th>Vasyl Z.I.</th>
                                <th>vaszar1</th>
                                <th>active</th>
                                <th>Sep 16, 2016</th>
                                <th>Sep 16, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>78</th>
                                <th>vasyl1964@mail.nowhere</th>
                                <th>admin</th>
                            </tr>
                            <tr>
                                <th>Vasyl Z.I.</th>
                                <th>vaszar1</th>
                                <th>active</th>
                                <th>Sep 16, 2016</th>
                                <th>Sep 16, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>78</th>
                                <th>vasyl1964@mail.nowhere</th>
                                <th>admin</th>
                            </tr>
                            <tr>
                                <th>Vasyl Z.I.</th>
                                <th>vaszar1</th>
                                <th>active</th>
                                <th>Sep 16, 2016</th>
                                <th>Sep 16, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>78</th>
                                <th>vasyl1964@mail.nowhere</th>
                                <th>admin</th>
                            </tr>
                            <tr>
                                <th>Vasyl Z.I.</th>
                                <th>vaszar1</th>
                                <th>active</th>
                                <th>Sep 16, 2016</th>
                                <th>Sep 16, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>78</th>
                                <th>vasyl1964@mail.nowhere</th>
                                <th>admin</th>
                            </tr>
                            <tr>
                                <th>Vasyl Z.I.</th>
                                <th>vaszar1</th>
                                <th>active</th>
                                <th>Sep 16, 2016</th>
                                <th>Sep 16, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>78</th>
                                <th>vasyl1964@mail.nowhere</th>
                                <th>admin</th>
                            </tr>
                            <tr>
                                <th>Vasyl Z.I.</th>
                                <th>vaszar1</th>
                                <th>active</th>
                                <th>Sep 16, 2016</th>
                                <th>Sep 16, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>78</th>
                                <th>vasyl1964@mail.nowhere</th>
                                <th>admin</th>
                            </tr>
                            <tr>
                                <th>Vasyl Z.I.</th>
                                <th>vaszar1</th>
                                <th>active</th>
                                <th>Sep 16, 2016</th>
                                <th>Sep 16, 2016</th>
                                <th>Nov 30, 2016</th>
                                <th>78</th>
                                <th>vasyl1964@mail.nowhere</th>
                                <th>admin</th>
                            </tr>
                            </tbody>
                        </table>
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

