<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="12u">
<h3>Update profile</h3>
    <div id="avatar">
        <form enctype="multipart/form-data" method="post" action="/uploadAvatar">
            <label class="file_upload">
                <c:choose>
                    <c:when test="${person.avatarURL == null}">
                        <img width="20em" class="img-circle" alt="Responsive image"
                             src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                    </c:when>
                    <c:otherwise>
                        <img width="200px" class="img-circle" alt="Responsive image"
                             src="${person.avatarURL}">
                    </c:otherwise>
                </c:choose>
            </label>
            <input type="file"
                   accept="image/png,image/jpeg"
                   name="image">
            <input type="submit" value="Upload File"/>
        </form>
    </div>
<sf:form method="post" modelAttribute="person" action="/personUpdate">
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

            <div class="12u$">
                    <input type="submit" value="Update Profile"/>
            </div>
        </div>
    </fieldset>
</sf:form>
</div>
