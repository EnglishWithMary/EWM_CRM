
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="12u">
<h3>Managers list</h3>
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
                <c:forEach var="manager" items="${managers}">
                    <tr>
                        <td>${manager.firstName}</td>
                        <td>${manager.lastName}</td>
                        <td>${manager.middleName}</td>
                        <td>
                            <security:authorize access="hasRole('ROLE_ADMIN')">
                                <a href="/managerDelete?id=${manager.id}">Delete</a>
                            </security:authorize>
                        </td>
                    </tr>
                </c:forEach>
            </tbod>
        </table>
    </div>
    <p><a href="/managerAdd">Add Manager</a></p>
</div >