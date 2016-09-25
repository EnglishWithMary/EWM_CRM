<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p></p>
<form:form method="post" action="/depEditSave" var="department" item="${department}">
    <table>
        <tr>Department ID ${department.id}</tr>
        <tr>
            <td><input type="hidden" name="id" value="${department.id}"/></td>
            <td><input type="text" name="param" value="${department.name}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>