<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="12u">
    <h3>Update profile</h3>

    <sf:form method="post" modelAttribute="person" action="/personUpdate" enctype="multipart/form-data">
        <div class="file_upload">

            <c:choose>
                <c:when test="${person.avatarURL == null}">
                    <img width="25%" class="img-circle" alt="Responsive image"
                         src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                </c:when>
                <c:otherwise>
                    <img width="25%" class="img-circle" alt="Responsive image"
                         src="${person.avatarURL}">
                </c:otherwise>
            </c:choose>

            <input type="file"
                   accept="image/png,image/jpeg"
                   name="image">
        </div>

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
                    <sf:label path="birthdayDate">Birthday:</sf:label>
                </div>

                <div class="6u 12u$(xsmall)">
                    <sf:input path="birthdayDate" type="date"/>
                    <sf:errors path="birthdayDate"/>
                </div>

                <div class="6u 12u$(xsmall)">
                    <sf:label path="comments">Comment:</sf:label>
                </div>

                <div class="6u 12u$(xsmall)">
                    <sf:input path="comments"/>
                    <sf:errors path="comments"/>
                </div>

                <div class="6u 12u$(xsmall)">
                    <sf:label path="email">Email:</sf:label>
                </div>

                <div class="6u 12u$(xsmall)">
                    <sf:input path="email"/>
                    <sf:errors path="email"/>
                </div>

                <div class="6u 12u$(xsmall)">
                    <sf:label path="organization">Organization:</sf:label>
                </div>

                <div class="6u 12u$(xsmall)">
                    <sf:input path="organization"/>
                    <sf:errors path="organization"/>
                </div>

                <div class="12u$">
                    <input type="submit" value="Update Profile"/>
                </div>
            </div>
        </fieldset>
    </sf:form>
</div>
