<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    window.onload = function () {
        window.history.pushState(null, '', 'leadAdd');
    };
</script>
<sf:form method="post" modelAttribute="lead" id="form" action="/leadSave">
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
            <tr>
                <td><sf:label path="comments">Comments:</sf:label></td>
                <td><sf:textarea path="comments" rows="5"/><br/>
                    <sf:errors path="comments"/>
                </td>
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

            <tr>
                <td colspan="2">
                    <input type="hidden" name="personId" value="${personId}" />
                    <input type="submit" value="Add lead"/>
                </td>
            </tr>
        </table>
    </fieldset>
</sf:form>
