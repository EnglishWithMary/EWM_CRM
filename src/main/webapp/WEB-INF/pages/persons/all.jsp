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

