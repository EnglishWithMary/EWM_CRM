<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="12u">
<h3>Create student</h3>
<sf:form method="post" modelAttribute="student" action="/studentSave">
    <fieldset>
        <div class="row uniform">
            <div class="6u 12u$(xsmall)">
                <sf:label path="firstName">First Name:</sf:label>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:input path="firstName"/>
                <sf:errors path="firstName"/>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:label path="lastName">Last Name:</sf:label>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:input path="lastName"/>
                <sf:errors path="lastName"/>
            </div>
            <div class="6u 12u$(xsmall)">
                <sf:label path="middleName">Middle Name:</sf:label>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:input path="middleName"/>
                <sf:errors path="middleName"/>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:label path="login">Login:</sf:label>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:input path="login"/>
                <sf:errors path="login"/>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:label path="password">Password:</sf:label>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:password path="password"/>
                <sf:errors path="password"/>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:label path="confirmPassword">Confirm password:</sf:label>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:password path="confirmPassword"/>
                <sf:errors path="confirmPassword"/>
            </div>


            <div class="6u 12u$(xsmall)">
                 <sf:label path="comments">Comments:</sf:label>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:textarea path="comments" rows="5"/>
                <sf:errors path="comments"/>
            </div>

            <div class="12u$">
                <div class="select-wrapper">
                    <select name="teacher_id">
                        <option value="">Set teacher later...</option>
                        <c:forEach var="teacher" items="${teachers}">
                            <option value="${teacher.id}">${teacher.person.firstName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="12u$">
                <div class="12u$">
                    <div class="select-wrapper">
                        <select name="group_id">
                            <option value="">Set group later...</option>
                            <c:forEach var="group" items="${groups}">
                                <option value="${group.id}">${group.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            <div class="12u$">
                    <input type="submit" value="Add student"/>
            </div>

        </div>
    </fieldset>
</sf:form>
</div>
