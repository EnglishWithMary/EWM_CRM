    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
        <head>
            <meta charset="UTF-8">
            <link href="/resources/assets/css/bootstrap-3.3.5/css/bootstrap-theme.min.css" rel="stylesheet">
            <link href="/resources/assets/css/bootstrap-3.3.5/css/styles.css" rel="stylesheet">
        </head>

<div class="wrapper">
            <p>Persons</p>
            <form method="post" action="/personSortByDate">
                <div class="form-group">
                    <input type="submit" value="Sort by Registration Date">
                </div>
            </form>
    <p>Leads</p>
    <table>
        <tr>
            <td>First name</td>
            <td>Last name</td>
            <td>Middle name</td>
            <td>Registration Date</td>
            <td> </td>
        </tr>
        <c:forEach var="lead" items="${leads}">
            <tr>
                <td><label>${lead.person.firstName}</label></td>
                <td><label>${lead.person.lastName}</label></td>
                <td><label>${lead.person.middleName}</label></td>
                <td><label>${lead.person.registrationDate}</label></td>
                <td><a href="/leadDelete?id=${lead.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
        <p><a href="/leadAdd">Add Lead</a></p>
</div>