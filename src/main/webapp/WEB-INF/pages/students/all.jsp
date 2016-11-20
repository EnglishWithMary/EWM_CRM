
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="12u">
<h3>Students list</h3>
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
            <tbod>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.middleName}</td>

                        <td>
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="/studentDelete?id=${student.id}">Delete</a>
                            </security:authorize>
                        </td>

                    </tr>
                </c:forEach>
            </tbod>
        </table>
    </div>
    <p><a href="/studentAdd">Add Student</a></p>
</div >