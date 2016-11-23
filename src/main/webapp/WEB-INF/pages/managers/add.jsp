<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="12u">
<h3>Create manager</h3>
<sf:form method="post" modelAttribute="manager" action="/managerSave">
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
                <sf:label path="email">Email:</sf:label>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:input path="email" type="email"/>
                <sf:errors path="email"/>
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
                <sf:password path="password" />
                <sf:errors path="password"/>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:label path="confirmPassword">Confirm password:</sf:label>
            </div>

            <div class="6u 12u$(xsmall)">
                <sf:password path="confirmPassword" />
                <sf:errors path="confirmPassword"/>
            </div>

            <div class="12u$">
                    <input type="submit" value="Add manager"/>
            </div>

        </div>
    </fieldset>
</sf:form>
</div>
