<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script>
    window.onload = function () {
        window.history.pushState(null, '', 'leadAddOnPipe');
    };
</script>
<sf:form method="post" modelAttribute="lead" action="/leadSaveOnPipe">
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

            <c:if test="${lead.cardId!=null}">
                <tr>
                    <td><sf:label path="cardId">Pipe card:</sf:label></td>
                    <td>
                        <sf:select path="cardId" class="form-control">
                            <c:forEach items="${cards}" var="card">
                                <option value="${card.id}" <c:if test="${card.id == card_id}">selected</c:if>>
                                    ${card.cardName} (id=${card.id})
                                </option>
                            </c:forEach>
                        </sf:select>
                        <br/>
                    </td>
                </tr>
            </c:if>
            <c:if test="${lead.cardId==null}">
                <sf:hidden path="cardId" value="${card_id}"/>
            </c:if>

            <tr>
                <td colspan="2">
                    <input type="hidden" name="cardPersonId" value="${cardPersonId}" />
                    <input type="hidden" name="card_id" value="${card_id}" />
                    <input type="hidden" name="pt_id" value="${pt_id}"/>
                    <input type="submit" value="Add lead"/>
                </td>
            </tr>
        </table>
    </fieldset>
</sf:form>