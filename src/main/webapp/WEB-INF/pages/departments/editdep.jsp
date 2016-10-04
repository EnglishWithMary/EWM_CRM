<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p></p>
<sf:form method="post" action="/depEditSave" modelAttribute="department">
<fieldset>
    <table>
        <tr>
            <th><sf:label path="id">Department ID: ${department.id}</sf:label></th>
            <td><sf:hidden path="id" /></td>
        </tr>
        <tr>
            <th><sf:label path="name">Name</sf:label></th>
            <td><sf:input path="name" value="${department.name}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</fieldset>
</sf:form>
</body>
</html>