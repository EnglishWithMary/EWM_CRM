<div>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

    <p>Leads</p>
    <table>
        <tr>
            <td>First name</td>
            <td>Last name</td>
            <td>Middle name</td>
            <td>Registration Date</td>
            <!--td>Emails</td>
            <td>Phones</td-->
            <td> </td>
        </tr>
        <c:forEach var="lead" items="${leads}">
            <tr>
                <td><label>${lead.person.firstName}</label></td>
                <td><label>${lead.person.lastName}</label></td>
                <td><label>${lead.person.middleName}</label></td>
                <td><label>${lead.person.registrationDate}</label></td>


                <td>
                    <security:authorize access="hasRole('ROLE_ADMIN')">
                        <a href="/leadDelete?id=${lead.id}">Delete</a>
                    </security:authorize>

                </td>
            </tr>
        </c:forEach>
    </table>
    <security:authorize access="hasRole('ROLE_ADMIN')">
        <p><a href="/leadAdd">Add Lead</a></p>
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