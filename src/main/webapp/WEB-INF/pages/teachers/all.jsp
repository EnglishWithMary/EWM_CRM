<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="12u">
    <h3>Teachers list</h3>
    <form method="post" action="/teacherSortByDate">
        <div class="form-group">
            <input type="submit" value="Sort by Registration Date">
        </div>
    </form>
    <div class="table-wrapper">
        <table class="alt">
            <tr>
                <td>First name</td>
                <td>Last name</td>
                <td>Middle name</td>
                <td>Registration Date</td>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <td>Delete Teacher</td>
                </security:authorize>
            </tr>
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td>${teacher.firstName}</td>
                    <td>${teacher.lastName}</td>
                    <td>${teacher.middleName}</td>
                    <td>${teacher.registrationDate}</td>
                    <td>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <a href="/teacherDelete?id=${teacher.id}">Delete</a>
                        </security:authorize>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <p><a href="/teacherAdd">Add Teacher</a></p>
</div>