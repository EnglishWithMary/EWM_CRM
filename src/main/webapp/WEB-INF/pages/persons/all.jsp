<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<head>
    <meta charset="UTF-8">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/styles.css" rel="stylesheet">
</head>

<div class="wrapper">
    <p>Groups</p>
    <%--sf:form method="post" modelAttribute="groupFilter" action="/groupFilter">
        <div class="form-group">
            <label for="sel1">By teacher:</label>
            <sf:select path="teacherId" class="form-control" id="sel1">
                <c:forEach items="${teachers}" var="teach">
                    <sf:option value=""></sf:option>
                    <sf:option value="${teach.id}">
                        ${teach.user.login} (
                        ${teach.person.firstName}
                        ${teach.person.middleName}
                        ${teach.person.lastName}
                        )</sf:option>
                </c:forEach>
            </sf:select>
            <input type="submit" value="filter">
        </div>
    </sf:form--%>
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

