<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<script>
    window.onload = function () {
        window.history.pushState(null, '', 'userAdd');
    };
</script>
<sf:form method="post" modelAttribute="user" action="/userSave">
    <fieldset>
        <table>
            <tr>
                <th><sf:label path="login">Login:</sf:label></th>
                <td><sf:input path="login"/><br/>
                    <sf:errors path="login"/>
                </td>
            </tr>

            <tr>
                <th><sf:label path="password">Password:</sf:label></th>
                <td><sf:input path="password"/><br/>
                    <sf:errors path="password"/>
                </td>
            </tr>

            <tr>
                <th><sf:label path="email">Email:</sf:label></th>
                <td><sf:input path="email"/><br/>
                    <sf:errors path="email"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Add user"/>
                </td>
            </tr>
        </table>
    </fieldset>
</sf:form>