<div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>Managers</p>
<table>
    <tr>
        <td>First name</td>
        <td>Last name</td>
        <td>Middle name</td>
    </tr>
    <c:forEach var="manager" items="${managers}">
        <tr>
            <td><label>${manager.person.firstName}</label></td>
            <td><label>${manager.person.lastName}</label></td>
            <td><label>${manager.person.middleName}</label></td>
        </tr>
    </c:forEach>
</table>
<p><a href="/managerAdd">Add Manager</a></p>
</div>