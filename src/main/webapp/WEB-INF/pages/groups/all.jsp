<div>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

    <p>Leads</p>
    <table>
        <tr>
            <td>Group name</td>
            <!--td>Last name</td>
            <td>Middle name</td>
            <td>Registration Date</td>
            <td>Emails</td>
            <td>Phones</td-->

        </tr>
        <c:forEach var="group" items="${groups}">
            <tr>
                <td><label>${group.name}</label></td>
            </tr>
        </c:forEach>
    </table>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <p><a href="/groupAdd">Add Group</a></p>
    </security:authorize>
</div>


<%--td>
                    <c:forEach var="email" items="${lead.person.emails}">
                        <label>${email.email}</label></br>
                    </c:forEach>
                </td>
                <td>
                    <c:forEach var="phone" items="${lead.person.phones}">
                        <label>${phone.phone}</label></br>
                    </c:forEach>
                </td--%>