<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
<%--<h1>Employee ID: ${employee.id}</h1>--%>
<sf:form method="post" action="/emplEditSave" modelAttribute="employee">
    <table>
        <tr>
            <td><input type="hidden" name="id" value="${employee.id}"/></td>
        </tr>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="secondName" value="${employee.secondName}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Edit Employee"/>
            </td>
        </tr>
    </table>
</sf:form>
</body>
</html>
