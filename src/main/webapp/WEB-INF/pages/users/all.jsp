<div>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<p>Users</p>
<table>
    <tr>
        <td>User login</td>
        <td>User role</td>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <a href="user/${user.id}">${user.login}</a>
            </td>
            <td>
                <a href="#">add role</a>
            </td>
            <td>
                <a href="#">delete user</a>
            </td>
        </tr>
    </c:forEach>
</table>
<p><a href="#">Add User</a></p>
</div>