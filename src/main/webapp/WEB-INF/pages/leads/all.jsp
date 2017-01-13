<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">Leads</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>List of Leads</strong>
            </div>
            <div class="panel-body">

                <div class="row padding-bot">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <form method="get" action="/leads">
                            <input type="hidden" name="flagSorted" value="${!flagSorted}" class="hidden">
                            <input value="${flagSorted == true ? 'Common  order' : 'Sort by Registration Date'}"
                            type="submit" class="btn btn-default"/>
                        </form>
                    </div>
                </div>

                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Middle name</th>
                        <th>Registration Date</th>
                        <th>Comments</th>
                        <security:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_MANAGER')">
                            <td>Edit</td>
                            <td>Delete</td>
                        </security:authorize>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Middle name</th>
                        <th>Registration Date</th>
                        <th>Comments</th>
                        <security:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_MANAGER')">
                            <td>Edit</td>
                            <td>Delete</td>
                        </security:authorize>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="lead" items="${leads}">
                        <tr>
                            <td><a href="/lead/info?person_id=${lead.person.id}">${lead.person.firstName}</a></td>
                            <td>${lead.person.lastName}</td>
                            <td>${lead.person.middleName}</td>
                            <td>${lead.person.registrationDate}</td>
                            <td>${lead.person.comments}</td>
                            <security:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_MANAGER')">
                                <td>
                                    <form method="post" action="/">
                                        <button type="submit" class="btn btn-default btn-sm">
                                            Edit
                                        </button>
                                        <input type="hidden" name="personId" value="${lead.person.id}">
                                    </form>
                                </td>
                                <td>
                                    <div>
                                        <button type="button"
                                                data-toggle="modal" data-target="#modal${lead.id}">
                                            Delete
                                        </button>
                                    </div>
                                    <div class="modal fade" id="modal${lead.id}">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button class="close" type="button" data-dismiss="modal">
                                                        <i class="fa fa-close"></i>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Are you sure you want to delete the lead?</p>
                                                </div>
                                                <div class="modal-footer row">
                                                    <div class="col-md-4">
                                                        <form method="post" action="/deleteLead">
                                                            <button type="submit" class="btn btn-default btn-sm">
                                                                Delete
                                                            </button>
                                                            <input type="hidden" name="personId" value="${lead.person.id}">
                                                        </form>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <form method="post" action="/leadTrash">
                                                            <button type="submit" class="btn btn-default btn-sm">
                                                                Move to trash
                                                            </button>
                                                            <input type="hidden" name="personId" value="${lead.person.id}">
                                                        </form>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <button class="btn btn-default btn-sm" type="button"
                                                                data-dismiss="modal">
                                                            Cancel
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
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
                                        <a href="/leads?page=${page}&flagSorted=${flagSorted}">
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
                <form method="post" action="/leadAdd">
                    <button type="submit" class="btn btn-success">Add Lead</button>
                </form>
            </div>
        </div>
    </div>
</div>
