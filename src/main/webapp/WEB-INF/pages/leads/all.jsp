<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="12u">
    <p>Leads</p>
    <form method="post" action="/leadSortByDate">
        <div class="form-group">
            <input type="submit" value="Sort by Registration Date">
        </div>
    </form>
    <table>
        <tr>
            <td>First name</td>
            <td>Last name</td>
            <td>Middle name</td>
            <td>Registration Date</td>
            <security:authorize access="hasRole('ROLE_ADMIN') || hasRole('ROLE_MANAGER')">
                <td>Edit Lead</td>
                <td>Delete Lead</td>
            </security:authorize>
        </tr>
        <c:forEach var="lead" items="${leads}">
            <tr>
                <td><label>${lead.person.firstName}</label></td>
                <td><label>${lead.person.lastName}</label></td>
                <td><label>${lead.person.middleName}</label></td>
                <td><label>${lead.person.registrationDate}</label></td>
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
    </table>
    <form method="post" action="/leadAdd">
        <input type="hidden" value="${pipeType.id}" name="pipeTypeId">
        <input type="hidden" value="${card.id}" name="cardId">
        <%--input type="hidden" value="${pt.id}" name="pipeTipeId">
        <input type="hidden" value="${card.id}" name="cardId"--%>
        <button type="submit" class="button alt">Add Lead</button>
    </form>
</div>

