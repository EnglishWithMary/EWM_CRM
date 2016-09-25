<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>Employees</p>
<p>Department ID: ${department.id}, Department Name: ${department.name}</p>
<table width="600px">
    <tr>
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>Actions</b></td>
    </tr>
    <c:forEach var="employee" items="${department.employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
                <%--<td><a href="/depAdd?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a></td>--%>
            <td>
                <form:form method="post" action="/emplDelete">
                    <input type="hidden" name="id" value="${employee.id}"/>
                    <input type="hidden" name="dep" value="${department.id}"/>
                    <input type="submit" value = "Delete" />
                </form:form>
            </td>
            <td>
                <form:form method="get" action="/emplEdit">
                    <input type="hidden" name="id" value="${employee.id}"/>
                    <input type="submit" value = "Edit" />
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
<form:form method="post" action="/emplAdd">
    <input type="hidden" name="id" value="${department.id}"/>
    <input type="submit" value="Add Employee"/>
</form:form>
<tr>
    <td colspan="5">
        <a href="/dep">See Departments</a>
    </td>
</tr>
</body>
</html>
