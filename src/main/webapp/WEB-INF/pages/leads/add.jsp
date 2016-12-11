<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--<div class="row">--%>
    <%--<div class="col-sm-12">--%>
        <%--<h2 class="page-header">Create lead</h2>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<div class="row">--%>
    <%--<div class="col-sm-5 col-sm-offset-3">--%>
        <%--<div class="panel panel-default">--%>
            <%--<div class="panel-heading">--%>
                <%--<strong>Add new Lead</strong>--%>
            <%--</div>--%>
            <%--<div class="panel-body">--%>
                <%--<sf:form method="post" modelAttribute="lead" action="/leadSave">--%>
                    <%--<fieldset class="form-group">--%>

                        <%--<div class="row padding-bot">--%>
                            <%--<div class="col-sm-1"></div>--%>
                            <%--<div class="col-sm-4">--%>
                                <%--<sf:label path="firstName">First Name:</sf:label>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-6">--%>
                                <%--<sf:input path="firstName" cssClass="form-control"/>--%>
                                <%--<sf:errors path="firstName" cssClass="has-error"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="row padding-bot">--%>
                            <%--<div class="col-sm-1"></div>--%>
                            <%--<div class="col-sm-4">--%>
                                <%--<sf:label path="lastName">Last Name:</sf:label>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-6">--%>
                                <%--<sf:input path="lastName" cssClass="form-control"/>--%>
                                <%--<sf:errors path="lastName" cssClass="has-error"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="row padding-bot">--%>
                            <%--<div class="col-sm-1"></div>--%>
                            <%--<div class="col-sm-4">--%>
                                <%--<sf:label path="middleName">Middle Name:</sf:label>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-6">--%>
                                <%--<sf:input path="middleName" cssClass="form-control"/>--%>
                                <%--<sf:errors path="middleName" cssClass="has-error"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="row padding-bot">--%>
                            <%--<div class="col-sm-1"></div>--%>
                            <%--<div class="col-sm-4">--%>
                                <%--<sf:label path="email">Email:</sf:label>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-6">--%>
                                <%--<sf:input path="email" type="email" cssClass="form-control"/>--%>
                                <%--<sf:errors path="email" cssClass="has-error"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>

                        <%--<div class="row padding-bot">--%>
                            <%--<div class="col-sm-1"></div>--%>
                            <%--<div class="col-sm-4">--%>
                                <%--<sf:label path="comments">Comments:</sf:label>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-6">--%>
                                <%--<sf:textarea path="comments" rows="5"/>--%>
                                <%--<sf:errors path="comments"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-sm-4 col-sm-offset-4">--%>
                                <%--<input type="submit" value="Add lead" class="btn btn-success"/>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</fieldset>--%>
                <%--</sf:form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>


<%--<script>--%>
    <%--window.onload = function () {--%>
        <%--window.history.pushState(null, '', 'leadAdd');--%>
    <%--};--%>
<%--</script>--%>
<sf:form method="post" modelAttribute="lead" action="/leadSave">
    <fieldset>
        <table>
            <tr>
                <td><sf:label path="firstName">First Name:</sf:label></td>
                <td><sf:input path="firstName"/><br/>
                    <sf:errors path="firstName"/></td>
            </tr>
            <tr>
                <td><sf:label path="lastName">Last Name:</sf:label></td>
                <td><sf:input path="lastName"/><br/>
                    <sf:errors path="lastName"/></td>
            </tr>
            <tr>
                <td><sf:label path="middleName">Middle Name:</sf:label></td>
                <td><sf:input path="middleName"/><br/>
                    <sf:errors path="middleName"/></td>
            </tr>
            <tr>
                <td><sf:label path="email">Email:</sf:label></td>
                <td><sf:input path="email"/><br/>
                    <sf:errors path="email"/></td>
            </tr>

            <c:if test="${lead.cardId!=null || card_id==null}">
                <tr>
                    <td><sf:label path="cardId">Pipe card:</sf:label></td>
                    <td>
                        <sf:select path="cardId" class="form-control">
                            <c:forEach items="${cards}" var="card">
                                <option value="${card.id}" <c:if test="${card.id == lead.cardId}">selected</c:if>>
                                    ${card.cardName} (id=${card.id})
                                </option>
                            </c:forEach>
                        </sf:select>
                        <br/>
                    </td>
                </tr>
            </c:if>

            <div class="12u$">
            <tr>
                <td colspan="2">
                    <input type="hidden" name="personId" value="${personId}"/>
                    <input type="submit" value="Add lead"/>
                </td>
            </tr>

            </div>
        </table>
    </fieldset>
</sf:form>
