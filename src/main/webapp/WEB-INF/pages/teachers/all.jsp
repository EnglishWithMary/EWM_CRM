
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="12u">
<h3>Teachers list</h3>
    <div class="table-wrapper">
        <table class="alt">
            <thead>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Middle name</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="teacher" items="${teachers}">
                    <tr>
                        <td>${teacher.firstName}</td>
                        <td>${teacher.lastName}</td>
                        <td>${teacher.middleName}</td>


                        <td>
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="/teacherDelete?id=${teacher.id}">Delete</a>
                            </security:authorize>
                        </td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <p><a href="/teacherAdd">Add Teacher</a></p>
</div >