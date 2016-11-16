<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<script>
    window.onload = function () {
        window.history.pushState(null, '', 'leadAdd');
    };
</script>
<sf:form method="post" modelAttribute="lead" action="/leadSave">
    <fieldset>
        <table>
            <tr>
                <th><sf:label path="firstName">First Name:</sf:label></th>
                <td><sf:input path="firstName"/><br/>
                    <sf:errors path="firstName"/></td>
            </tr>
            <tr>
                <th><sf:label path="lastName">Last Name:</sf:label></th>
                <td><sf:input path="lastName"/><br/>
                    <sf:errors path="lastName"/></td>
            </tr>
            <tr>
                <th><sf:label path="middleName">Middle Name:</sf:label></th>
                <td><sf:input path="middleName"/><br/>
                    <sf:errors path="middleName"/></td>
            </tr>

            <%--tr>
                <th><sf:label path="email">Email:</sf:label></th>
                <td><sf:input path="email"/><br/>
                    <sf:errors path="email"/></td>
            </tr>

            <tr>
                <th><sf:label path="phone">Phone:</sf:label></th>
                <td><sf:input path="phone"/><br/>
                    <sf:errors path="phone"/></td>
            </tr--%>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add lead"/>
                </td>
            </tr>
        </table>
    </fieldset>
</sf:form>