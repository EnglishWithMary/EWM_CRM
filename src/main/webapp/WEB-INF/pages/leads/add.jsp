<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--<script>--%>
<%--window.onload = function () {--%>
<%--window.history.pushState(null, '', 'leadAdd');--%>
<%--};--%>
<%--</script>--%>

<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <c:if test="${lead.personId==null}">
                    <strong>Add new Lead</strong>
                </c:if>
                <c:if test="${lead.personId!=null}">
                    <strong>Update Lead</strong>
                </c:if>
            </div>
            <div class="panel-body">

                <sf:form method="post" modelAttribute="lead" id="form" action="/leads/save">

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
                                <sf:label path="comments">Comments:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:textarea class="form-control" id="comment" path="comments" rows="5"/>
                                <sf:errors path="comments"/>
                            </div>
                        </div>

                        <c:if test="${lead.cardId!=null || card_id==null}">
                            <div class="row padding-bot">
                                <div class="col-sm-1"></div>
                                <div class="col-sm-4"><sf:label path="cardId">Pipe card:</sf:label></div>
                                <div class="col-sm-6">
                                    <sf:select path="cardId" class="form-control">
                                        <c:forEach items="${cards}" var="card">
                                            <option value="${card.id}"
                                                    <c:if test="${card.id == lead.cardId}">selected</c:if>>
                                                    ${card.cardName}
                                            </option>
                                        </c:forEach>
                                    </sf:select>
                                </div>
                            </div>
                        </c:if>

                        <div class="row padding-bot">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="hidden" value="${personId}" class="hidden" name="personId" />
                                <c:if test="${lead.personId==null}">
                                    <input type="submit" value="Add lead" class="btn btn-success"/>
                                </c:if>
                                <c:if test="${lead.personId!=null}">
                                    <input type="submit" value="Update lead" class="btn btn-success"/>
                                </c:if>


                            </div>
                        </div>
                    </fieldset>
                </sf:form>
            </div>
        </div>
    </div>
</div>
