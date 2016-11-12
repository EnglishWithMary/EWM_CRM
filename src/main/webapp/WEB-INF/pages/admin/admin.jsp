<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Admin is here!</h1>
<a href="/userAdd">Add User</a>
<a href="/managerAdd">Add manager</a>
<a href="/adminAdd">Add admin</a>

<div>
    <table>
        <tr>
            <td>First Name</td>
            <td>Last Name</td>
        </tr>
        <c:forEach var="admin" items="${admins}">
            <tr>
                <td><c:out value="${admin.person.firstName}"/></td>
                <td><c:out value="${admin.person.lastName}"/></td>
            </tr>
        </c:forEach>
    </table>

</div>