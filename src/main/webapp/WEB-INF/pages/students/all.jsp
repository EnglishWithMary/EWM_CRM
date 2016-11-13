<%--
  Created by IntelliJ IDEA.
  User: oleksiy
  Date: 10.11.16
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<div>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <p>Students</p>
    <table>
        <tr>
            <td>First name</td>
            <td>Last name</td>
            <td>Middle name</td>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td><label>${student.person.firstName}</label></td>
                <td><label>${student.person.lastName}</label></td>
                <td><label>${student.person.middleName}</label></td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="/studentAdd">Add Student</a></p>
</div>
