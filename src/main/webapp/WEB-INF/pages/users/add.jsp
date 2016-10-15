<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<form:form commandName="user">
    <label for="login">Login:</label>
    <form:input path="login"/>

    <label for="password">Password:</label>
    <form:password path="password"/>

    <input type="submit" value="Add user"/>
</form:form>

</body>
</html>
