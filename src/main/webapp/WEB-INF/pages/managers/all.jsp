<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="12u">
<h3>Managers list</h3>
    <form method="get" action="/managers">
        <div class="form-group">
            <input type="hidden" name="flagSorted" value="${!flagSorted}">
            <input type="submit" value="${flagSorted == true ? 'Common  order' : 'Sort by Registration Date'}"/>
        </div>
    </form>
    <div class="table-wrapper">
        <table class="alt">
            <thead>
                <tr>
                    <td>First name</td>
                    <td>Last name</td>
                    <td>Middle name</td>
                    <td>Registration Date</td>
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <td>Delete Manager</td>
                    </security:authorize>
                </tr>
            </thead>
            <tbod>
                <c:forEach var="manager" items="${managers}">
                    <tr>
                        <td>${manager.person.firstName}</td>
                        <td>${manager.person.lastName}</td>
                        <td>${manager.person.middleName}</td>
                        <td>${manager.person.registrationDate}</td>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                        <td>
                            <a href="/managerDelete?id=${manager.id}">Delete</a>
                        </td>
                        </security:authorize>
                    </tr>
                </c:forEach>
            </tbod>
        </table>
    </div>
    <p><a href="/managerAdd" class="button alt">Add Manager</a></p><br>
    <p>Pages</p>

    <table>
        <c:forEach var="page" begin="1" end="${pages}">
            <tr>
                <a href="/managers?page=${page}&flagSorted=${flagSorted}" class="button atl small">${page}</a>
            </tr>
        </c:forEach>
    </table>
</div >