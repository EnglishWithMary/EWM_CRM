<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <p>Groups</p>
    <table>
        <tr>
            <td>Group Name</td>
            <td>Group's Teacher</td>
        </tr>
        <c:forEach var="group" items="${groups}">
        <tr>
            <td>${group.name}</td>
            <td>${group.teacher.user.login}</td>
        </tr>
        </c:forEach>
    </table>
    <p><a href="/groupAdd">Add Group</a></p>
</div>
