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
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Information about searched persons</strong>
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
                                        <option>Registration Date</option>
                                        <option>Status</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="padding-bot"></div>
                    <div class="col-sm-12">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Full Name</th>
                                <th>State</th>
                                <th>Reg. Date</th>
                                <th>Mod. Date</th>
                                <th>Restore</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>Full Name</th>
                                <th>State</th>
                                <th>Reg. Date</th>
                                <th>Mod. Date</th>
                                <th>Restore</th>
                                <th>Delete</th>
                            </tr>
                            </tfoot>

                            <tbody>
                            <c:forEach var="person" items="${persons}">
                                <tr>
                                    <td>
                                        <input class="hidden personId" value="${person.id}">
                                        ${person.lastName} ${fn:substring(person.firstName, 0, 1)}. ${fn:substring(person.middleName, 0, 1)}
                                    </td>
                                    <td>${person.state.state}</td>
                                    <td>${person.registrationDate}</td>
                                    <td>${person.modifyDate}</td>
                                    <td><button class="restore">Revert</button></td>
                                    <td><button class="delete">Delete</button></td>
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
    </div>
</div>
