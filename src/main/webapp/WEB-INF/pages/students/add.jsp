<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Add new Student</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="student" id="form" action="/students/save">
                    <fieldset class="form-group">

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="firstName">First Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="firstName" cssClass="form-control"/>
                                <sf:errors path="firstName" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="lastName">Last Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="lastName" cssClass="form-control"/>
                                <sf:errors path="lastName" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="middleName">Middle Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="middleName" cssClass="form-control"/>
                                <sf:errors path="middleName" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="email">Email:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="email" type="email" cssClass="form-control"/>
                                <sf:errors path="email" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="login">Login:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="login" cssClass="form-control"/>
                                <sf:errors path="login" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="password">Password:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:password path="password" cssClass="form-control"/>
                                <sf:errors path="password" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="confirmPassword">Confirm password:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:password path="confirmPassword" cssClass="form-control"/>
                                <sf:errors path="confirmPassword" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="comments">Comments:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:textarea class="form-control" id="comment" path="comments" rows="5"/>
                                <sf:errors path="comments"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <label>Set teacher:</label>
                            </div>
                            <div class="col-sm-6">
                                <select name="teacher_id" class="form-control">
                                    <option value="">Set teacher later...</option>
                                    <c:forEach var="teacher" items="${teachers}">
                                        <option value="${teacher.id}">${teacher.person.firstName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row padding-bot ">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <label>Set group:</label>
                            </div>
                            <div class="col-sm-6">
                                <select name="group_id" class="form-control">
                                    <option value="">Set group later...</option>
                                    <c:forEach var="group" items="${groups}">
                                        <option value="${group.id}">${group.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <c:if test="${student.cardId!=null || card_id==null}">
                            <div class="row padding-bot">
                                <div class="col-sm-1"></div>
                                <div class="col-sm-4"><sf:label path="cardId">Pipe card:</sf:label></div>
                                <div class="col-sm-6">
                                    <sf:select path="cardId" class="form-control">
                                        <c:forEach items="${cards}" var="card">
                                            <option value="${card.id}"
                                                    <c:if test="${card.id == student.cardId}">selected</c:if>>
                                                    ${card.cardName}
                                            </option>
                                        </c:forEach>
                                    </sf:select>
                                </div>
                            </div>
                        </c:if>
                        <div class="row padding-bot">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="submit" value="Add student" class="btn btn-success"/>
                            </div>
                        </div>
                    </fieldset>
                </sf:form>
            </div>
        </div>
    </div>
</div>