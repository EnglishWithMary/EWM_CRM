<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/styles.css" rel="stylesheet">
</head>

<div class="wrapper">
    <p>Persons</p>
    <form method="post" action="/personFilter">
        <div class="form-group">
            <!--input type="checkbox" name="sorted" value="ASC"/-->
            <%--sf:checkbox path="sorted" cssClass="checkbox" /--%>
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

