<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
        </tr>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td>
                    ${person.firstName}
                    ${person.middleName}
                    ${person.lastName}
                </td>
                <td>${person.registrationDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>

