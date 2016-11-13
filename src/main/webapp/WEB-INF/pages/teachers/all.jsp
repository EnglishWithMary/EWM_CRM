<div>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <p>Teachers</p>
    <table>
        <tr>
            <td>First name</td>
            <td>Last name</td>
            <td>Middle name</td>
        </tr>
        <c:forEach var="teacher" items="${teachers}">
            <tr>
                <td><label>${teacher.person.firstName}</label></td>
                <td><label>${teacher.person.lastName}</label></td>
                <td><label>${teacher.person.middleName}</label></td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="/teacherAdd">Add Teacher</a></p>
</div>