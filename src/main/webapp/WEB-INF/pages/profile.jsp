<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script src="${pageContext.request.contextPath}/resources/assets/css/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/css/bootstrap/js/bootstrap-select.min.js"></script>

<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>


<h3 class="text-center">Update profile</h3>

<sf:form method="post" modelAttribute="person" action="/personUpdate" enctype="multipart/form-data">
    <div class="file_upload">
        <c:choose>
            <c:when test="${person.avatarURL == null}">
                <img width="20%" class="img-circle center-block" alt="Responsive image"
                     src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
            </c:when>
            <c:otherwise>
                <img width="20%" class="img-circle center-block" alt="Responsive image"
                     src="${person.avatarURL}">
            </c:otherwise>
        </c:choose>

        <input type="file"
               class="center-block"
               accept="image/png,image/jpeg"
               name="image">
    </div>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <fieldset>
        <div class="row">
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:label path="firstName">First Name:</sf:label>
            </div>
            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:input path="firstName"/>
                <sf:errors path="firstName"/>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:label path="lastName">Last Name:</sf:label>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:input path="lastName"/>
                <sf:errors path="lastName"/>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:label path="middleName">Middle Name:</sf:label>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:input path="middleName"/>
                <sf:errors path="middleName"/>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:label path="birthdayDate">Birthday:</sf:label>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:input path="birthdayDate" type="date"/>
                <sf:errors path="birthdayDate"/>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:label path="comments">Comment:</sf:label>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:input path="comments"/>
                <sf:errors path="comments"/>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:label path="email">Email:</sf:label>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:input path="email"/>
                <sf:errors path="email"/>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:label path="organization">Organization:</sf:label>
            </div>

            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center">
                <sf:input path="organization"/>
                <sf:errors path="organization"/>
            </div>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 text-center divider">
            <button type="submit" class="btn btn-success btn-md">Update profile</button>
        </div>

    </fieldset>

</sf:form>