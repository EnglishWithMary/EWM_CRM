<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
<body>
<form:form modelAttribute="role" >
    <label for="role">Role:</label>
    <form:select path="role">
        <form:option value="ROLE_ADMIN"/>
        <form:option value="ROLE_DIRECTOR"/>
        <form:option value="ROLE_TEACHER"/>
        <form:option value="ROLE_USER"/>
    </form:select>

    <input type="submit" value="Set Role"/>

    <p>User id for role: ${user_id}</p>
</form:form>

</body>
</html>
