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

                <form method="post" action="/leadSortByDate">
                    <div class="form-group">
                        <input type="submit" value="Sort by Registration Date" class="btn btn-default">
                    </div>
                </form>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Middle name</th>
                        <th>Registration Date</th>
                        <security:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_MANAGER')">
                            <td>Edit Lead</td>
                            <td>Delete Lead</td>
                        </security:authorize>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="lead" items="${leads}">
                        <tr>
                            <td>${lead.person.firstName}</td>
                            <td>${lead.person.lastName}</td>
                            <td>${lead.person.middleName}</td>
                            <td>${lead.person.registrationDate}</td>
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <td>
                                    <form method="post" action="/leadTrash">
                                        <input type="hidden" name="id" value="${lead.id}">
                                        <button type="submit" class="btn btn-default btn-sm">
                                            Delete
                                        </button>
                                    </form>
                                </td>
                            </security:authorize>
                            <security:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_MANAGER')">
                                <td>
                                    <form method="post" action="/leadAdd">
                                        <button type="submit" class="btn btn-default btn-xs">
                                            Edit
                                        </button>
                                        <input type="hidden" name="personId" value="${lead.person.id}">
                                    </form>
                                </td>
                                <td>
                                    <div>
                                        <button type="button" class="btn btn-default btn-xs"
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
                                                            <button type="submit" class="btn btn-default btn-xs">
                                                                Delete
                                                            </button>
                                                            <input type="hidden" name="personId" value="${lead.person.id}">
                                                        </form>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <form method="post" action="/leadTrash">
                                                            <button type="submit" class="btn btn-default btn-xs">
                                                                Move to trash
                                                            </button>
                                                            <input type="hidden" name="personId" value="${lead.person.id}">
                                                        </form>
                                                    </div>
                                                    <div class="col-md-4">
                                                        <button class="btn btn-default btn-xs" type="button"
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
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Tools</strong>
            </div>
            <div class="panel-body">
                <form method="post" action="/leadAdd">
                    <input type="hidden" value="${pipeType.id}" name="pipeTypeId" class="hidden">
                    <input type="hidden" value="${card.id}" name="cardId" class="hidden">
                    <button type="submit" class="btn btn-success">Add Lead</button>
                </form>
                <form method="post" action="/leadAdd">
                    <%--input type="hidden" value="${pipeType.id}" name="pipeTypeId">
                    <input type="hidden" value="${card.id}" name="cardId"--%>
                    <button type="submit" class="button alt">Add Lead</button>
                </form>
            </div>
        </div>
    </div>
</div>
