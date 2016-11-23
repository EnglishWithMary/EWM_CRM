<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div>
<h1>Add Admin:</h1>
    
    <sf:form action="/adminAdd" modelAttribute="adminDTO" method="post">
        <sf:label path="firstName">First Name:</sf:label>
        <sf:input path="firstName"/>
        <sf:errors path="firstName"/>

        <sf:label path="lastName">First Name:</sf:label>
        <sf:input path="lastName"/>
        <sf:errors path="lastName"/>
        
        <input type="submit" value="Save Admin"/>
    </sf:form>
    
</div>