<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All</title>
</head>
<body>
<p>Departments</p>
<table width="600px">
    <tr>
        <td><b>Id</b></td>
        <td><b>Name</b></td>
        <td><b>Actions</b></td>
    </tr>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>${department.id}</td>
            <td>${department.name}</td>
                <%--<td><a href="/depAdd?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a></td>--%>
            <td>
                <form:form method="post" action="/depDelete">
                    <input type="hidden" name="id" value="${department.id}"/>
                    <input type="submit" value = "Delete" />
                </form:form>
            </td>
            <td>
                <form:form method="get" action="/depEdit">
                    <input type="hidden" name="id" value="${department.id}"/>
                    <input type="submit" value = "Edit" />
                </form:form>
            </td>
            <td>
                <form:form method="post" action="/empl">
                    <input type="hidden" name="id" value="${department.id}"/>
                    <input type="submit" value = "Employees" />
                </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
<form:form method="post" action="/depSave">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add department"/>
            </td>
        </tr>
    </table>
</form:form>
<%--<tr>
    <td colspan="5">
        <a href="/empl">See Employees</a>
    </td>
</tr>
   <td colspan="5">
           <a href="/depDel">Delete existing one</a>
       </td>
   --%>
</body>
</html>