<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>List of Managers</strong>
            </div>
            <div class="panel-body">
                <div class="row padding-bot">
                    <div class="col-sm-12">
                        <form method="get" action="/managers">
                            <input type="hidden" name="flagSorted" value="${!flagSorted}" class="hidden">
                            <input value="${flagSorted == true ? 'Common  order' : 'Sort by Registration Date'}"
                                   type="submit" class="btn btn-default"/>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
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
                            <c:forEach var="manager" items="${managers}">
                                <tr>
                                    <td>
                                        <a href="/managers/info?manager_id=${manager.id}">
                                            ${manager.person.firstName}
                                            ${manager.person.middleName}
                                            ${manager.person.lastName}
                                        </a>
                                    </td>
                                    <td>${manager.person.registrationDate}</td>
                                    <td><textarea name="comments" cols="16" disabled>${manager.person.comments}</textarea></td>
                                    <security:authorize access="hasRole('ROLE_ADMIN')">
                                        <td>
                                            <a href="/managers/trash?id=${manager.id}">Delete</a>
                                        </td>
                                        <td>
                                            <a href="/managers/save?id=${manager.id}">Save</a>
                                        </td>
                                    </security:authorize>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="text-center">
                        <c:if test="${pages > 1}">
                            <ul class="pagination">
                                <c:forEach var="page" begin="1" end="${pages}">
                                    <li class="${(page eq param.page) or ((param.page eq null) and (page eq 1))? 'active' : ''}">
                                        <a href="/managers?page=${page}&flagSorted=${flagSorted}">
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
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Tools</strong>
            </div>
            <div class="panel-body">
                <a href="/managers/add" class="btn btn-success">Add Manager</a>
            </div>
        </div>
    </div>
</div>

