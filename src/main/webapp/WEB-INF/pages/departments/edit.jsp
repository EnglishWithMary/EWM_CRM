<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<script>
    window.onload = function () {
        window.history.pushState(null,'','depAdd');
    };
</script>
    <sf:form method="post" modelAttribute="department" action="/depSave">
    <fieldset>
    <table>
        <tr>
            <th><sf:label path="name">Name:</sf:label></th>
            <td><sf:input path="name" /><br/>
                <%--<sf:errors path="name" />--%>
            </td>
        </tr>
        <c:forEach var="violation" items="${violations}">
            <tr>
                    ${violation.message}
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add department" />
            </td>
        </tr>
    </table>
    </fieldset>
</sf:form>
</body>
</html>
