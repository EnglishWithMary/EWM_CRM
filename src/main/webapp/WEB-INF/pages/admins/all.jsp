<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">Admins</h1>
    </div>
</div>
<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>List of Admins</strong>
            </div>
            <div class="panel-body">
                <div class="row padding-bot">
                    <div class="col-sm-12">
                        <form method="get" action="/admins">
                            <input type="hidden" name="flagSorted" value="${!flagSorted}" class="hidden">
                            <input value="${flagSorted == true ? 'Common  order' : 'Sort by Registration Date'}"
                                   type="submit" class="btn btn-default"/>
                        </form>
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
                                <th>Registration Date</th>
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
                                <th>Registration Date</th>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <th>Delete</th>
                                    <th>Save</th>
                                </security:authorize>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="admin" items="${admins}">
                                <tr>
                                    <td><a href="/admin/info?admin_id=${admin.id}">${admin.person.firstName}</a></td>
                                    <td>${admin.person.lastName}</td>
                                    <td>${admin.person.middleName}</td>
                                    <td>${admin.person.registrationDate}</td>
                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <td>
                                            <a href="/adminTrash?id=${manager.id}">Delete</a>
                                        </td>
                                        <td>
                                            <a href="/adminSave?id=${manager.id}">Save</a>
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
                                        <a href="/admins?page=${page}&flagSorted=${flagSorted}">
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
                <a href="/adminAdd" class="btn btn-success">Add Admin</a>
            </div>
        </div>
    </div>
</div>
