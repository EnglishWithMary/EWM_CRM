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
                        <a href="/leadDelete?id=${lead.id}">Delete</a>
                    </td>
                </security:authorize>
            </tr>
        </c:forEach>
    </table>
    <p><a class="button alt" href="/leadAdd">Add Lead</a></p>
</div>