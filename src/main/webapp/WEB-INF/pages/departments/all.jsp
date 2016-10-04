<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Departments</title>
</head>
<body>
<script>
    window.onload = function () {
        window.history.pushState(null,'','dep');
    };
</script>
<p>Departments</p>
<table width="600px" var="violations" item="violations">
    <tr>
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>Actions</b></td>
        <td>Total violations = ${violations.size}</td>
    </tr>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
            <td>
                <a href = "/depDelete?id=${department.id}">Delete</a>
            </td>
            <td>
                <a href = "/depEdit?id=${department.id}">Edit</a>
            </td>
            <td>
                <a href = "/empl?id=${department.id}">Employees</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href = "/depAdd">Add department</a>
</body>
</html>