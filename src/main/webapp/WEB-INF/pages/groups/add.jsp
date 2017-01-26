<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-sm-4 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Enter Details:</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="group" action="/groups/save">
                    <fieldset>
                        <div class="row pad ding-bot">
                            <div class="col-sm-3">
                                <sf:label path="name">Group Name:</sf:label>
                            </div>
                            <div class="col-sm-9">
                                <sf:input path="name" cssClass="form-control"/>
                                <sf:errors path="name" cssClass="has-error"/>
                            </div>
                        </div>
                        <br>
                        <div class="row padding-bot">
                            <div class="col-sm-3">
                                <sf:label path="teacherId"> Teacher: </sf:label>
                            </div>
                            <div class="col-sm-9">
                                <sf:select path="teacherId" cssClass="form-control">
                                    <c:forEach items="${teachers}" var="teach">
                                        <sf:option value="${teach.id}"
                                                   label="${teach.person.lastName} ${teach.person.firstName} ${teach.person.middleName}"/>
                                    </c:forEach>
                                </sf:select>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-3">
                                <sf:label path="languageId">Languages:</sf:label>
                            </div>
                            <div class="col-sm-9">
                                <sf:select path="languageId" class ="form-control">
                                    <c:forEach var="lang" items="${languages}" >
                                        <option value="${lang.id}">${lang.language}</option>
                                    </c:forEach>
                                </sf:select>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="submit" class="btn btn-success" value="Add group"/>
                            </div>
                        </div>
                    </fieldset>
                </sf:form>
            </div>
        </div>
    </div>
</div>