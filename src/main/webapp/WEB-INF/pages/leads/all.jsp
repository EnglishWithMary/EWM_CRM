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
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <td>Delete Lead</td>
            </security:authorize>
        </tr>
        <c:forEach var="lead" items="${leads}">
            <tr>
                <td><label>${lead.person.firstName}</label></td>
                <td><label>${lead.person.lastName}</label></td>
                <td><label>${lead.person.middleName}</label></td>
                <td><label>${lead.person.registrationDate}</label></td>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <td>

                        <form method="post" action="/leadTrash">
                            <input type="hidden" name="id" value="${lead.id}">
                            <button type="submit" class="btn btn-default btn-xs">
                                Delete
                            </button>
                        </form>
                    </td>
                </security:authorize>
            </tr>
        </c:forEach>
    </table>
    <form method="post" action="/leadAdd">
        <input type="hidden" value="${pipeType.id}" name="pipeTypeId">
        <input type="hidden" value="${card.id}" name="cardId">
        <button type="submit" class="button alt">Add Lead</button>
    </form>
</div>
