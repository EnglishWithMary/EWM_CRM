<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<script>
    window.onload = function () {
        window.history.pushState(null,'','empl?id=${department.id}');
    };
</script>
<p>Employees</p>
<p>Department ID: ${department.id}, Department Name: ${department.name}</p>
<table width="600px">
    <tr>
        <td><b>Employee Id:</b></td>
        <td><b>Name:</b></td>
        <td><b>Actions:</b></td>
    </tr>
    <c:forEach var="employee" items="${department.employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
                <%--<td><a href="/depAdd?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a></td>--%>
            <td>
                <a href="/emplDelete?id=${employee.id}">Delete</a>
            </td>
            <td>
                <a href="/emplEdit?id=${employee.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
<tr>
    <td colspan="5">
        <a href="/emplAdd?id=${department.id}">Add Employee</a>
    </td>
</tr>
<tr>
    <td colspan="5">
        <a href="/dep">See Departments</a>
    </td>
</tr>
</body>
</html>
