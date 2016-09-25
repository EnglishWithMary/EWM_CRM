<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<form:form method="post" action="/saveEmpl">
    <table>
        <tr>
            <td><input type="hidden" name="id" value="${id}"/></td>
        </tr>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="secondName"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add Employee"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
