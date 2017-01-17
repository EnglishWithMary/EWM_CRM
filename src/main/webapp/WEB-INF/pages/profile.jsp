<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
    <div class="col-sm-12">
        <h3 class="">Profile</h3>
    </div>
</div>

<div class="row">

    <sf:form method="post" modelAttribute="person" action="/persons/updatePerson" enctype="multipart/form-data">
        <div class="col-sm-4">
            <div class="file_upload">

                <c:choose>
                    <c:when test="${person.avatarURL == null}">
                        <img class="img-circle" alt="Responsive image"
                             src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                    </c:when>
                    <c:otherwise>
                        <img class="img-circle" alt="Responsive image"
                             src="${person.avatarURL}">
                    </c:otherwise>
                </c:choose>

                <input type="file"
                       accept="image/png,image/jpeg"
                       name="image">
            </div>
        </div>

        <div class="col-sm-8">

            <fieldset>
                    <%--<div class="row uniform">--%>
                <div class="row">
                    <div class="col-sm-12">

                        <div class="row padding-bot">
                            <div class="col-sm-2">
                                <sf:label path="firstName">First Name:</sf:label>
                            </div>

                            <div class="col-sm-4">
                                <sf:input path="firstName" cssClass="form-control"/>
                                <sf:errors path="firstName" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-2">
                                <sf:label path="lastName">Last Name:</sf:label>
                            </div>
                            <div class="col-sm-4">
                                <sf:input path="lastName" cssClass="form-control"/>
                                <sf:errors path="lastName" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-2">
                                <sf:label path="middleName">Middle Name:</sf:label>
                            </div>
                            <div class="col-sm-4">
                                <sf:input path="middleName" cssClass="form-control"/>
                                <sf:errors path="middleName" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-2">
                                <sf:label path="birthdayDate">Birthday:</sf:label>
                            </div>
                            <div class="col-sm-4">
                                <sf:input path="birthdayDate" type="date" cssClass="form-control"/>
                                <sf:errors path="birthdayDate" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-2">
                                <sf:label path="comments">Comment:</sf:label>
                            </div>
                            <div class="col-sm-4">
                                <sf:input path="comments" cssClass="form-control"/>
                                <sf:errors path="comments" cssClass="has-error"/>
                            </div>
                        </div>


                        <div class="row padding-bot">
                            <div class="col-sm-2">
                                <sf:label path="email">Email:</sf:label>
                            </div>
                            <div class="col-sm-4">
                                <sf:input path="email" type="email" cssClass="form-control"/>
                                <sf:errors path="email" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-2">
                                <sf:label path="organization">Organization:</sf:label>
                            </div>
                            <div class="col-sm-4">
                                <sf:input path="organization" cssClass="form-control"/>
                                <sf:errors path="organization" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-6">
                                <input type="submit" value="Update Profile" class="btn btn-default"/>
                            </div>
                        </div>
                    </div>
                </div>
            </fieldset>
        </div>
    </sf:form>

</div>