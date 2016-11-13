<%--
  Created by IntelliJ IDEA.
  User: oleksiy
  Date: 10.11.16
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<script>
    window.onload = function () {
        window.history.pushState(null, '', 'studentAdd');
    };
</script>
<sf:form method="post" modelAttribute="student" action="/studentSave">
    <fieldset>
        <table>
            <tr>
                <th><sf:label path="personId">Person:</sf:label></th>
                <td><sf:input path="personId"/><br/>
                    <sf:errors path="personId"/></td>
            </tr>
            <tr>
                <th><sf:label path="teacherId">Teacher:</sf:label></th>
                <td><sf:input path="teacherId"/><br/>
                    <sf:errors path="teacherId"/></td>
            </tr>
            <tr>
                <th><sf:label path="groupId">Group:</sf:label></th>
                <td><sf:input path="groupId"/><br/>
                    <sf:errors path="groupId"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add student"/>
                </td>
            </tr>
        </table>
    </fieldset>
</sf:form>

<%--
--%>
</body>
</html>
