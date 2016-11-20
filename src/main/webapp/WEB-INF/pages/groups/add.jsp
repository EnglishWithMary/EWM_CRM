<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<script>
    window.onload = function () {
        window.history.pushState(null, '', 'groupAdd');
    };
</script>
<sf:form method="post" modelAttribute="group" action="/groupSave">
    <fieldset>
        <table>
            <tr>
                <th><sf:label path="name">First Name:</sf:label></th>
                <td><sf:input path="name"/><br/>
                    <sf:errors path="name"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add group"/>
                </td>
            </tr>
        </table>
    </fieldset>
</sf:form>