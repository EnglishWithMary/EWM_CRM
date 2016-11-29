<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="12u">
    <p>Groups</p>
    <sf:form method="post" modelAttribute="groupFilter" action="/groupFilter">
        <div class="form-group">
            <label for="sel1">By teacher:</label>
            <sf:select path="teacherId" class="form-control" id="sel1">
                <c:forEach items="${teachers}" var="teach">
                    <sf:option value=""></sf:option>
                    <sf:option value="${teach.id}">
                    ${teach.user.login} (
                    ${teach.person.firstName}
                    ${teach.person.middleName}
                    ${teach.person.lastName}
                        )</sf:option>
                </c:forEach>
            </sf:select>
            <input type="submit" value="filter">
        </div>
    </sf:form>
    <table>
        <tr>
            <td>Group Name</td>
            <td>Group's Teacher</td>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <td>Delete Group</td>
            </security:authorize>
        </tr>
        <c:forEach var="group" items="${groups}">
        <tr>
            <td>${group.name}</td>
            <td>
                ${group.teacher.person.firstName}
                ${group.teacher.person.middleName}
                ${group.teacher.person.lastName}
            </td>
            <security:authorize access="hasRole('ROLE_ADMIN')">
                <td>
                    <a href="/teacherDelete?id=${teacher.id}">Delete</a>
                </td>
            </security:authorize>
        </tr>
        </c:forEach>
    </table>
    <p><a class="button alt" href="/groupAdd">Add Group</a></p>
</div>
