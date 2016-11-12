<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
<h1>Add Admin:</h1>
    
    <sf:form action="/adminAdd" modelAttribute="admin" method="post">
        <sf:label path="${person.firstName}">First Name:</sf:label>
        <sf:input path="${person.firstName}"/>
        <sf:errors path="${person.firstName}"/>

        <sf:label path="${person.lastName}">First Name:</sf:label>
        <sf:input path="${erson.lastName}"/>
        <sf:errors path="${person.lastName}"/>
        
        <input type="submit" value="Save Admin"/>
    </sf:form>
    
</div>