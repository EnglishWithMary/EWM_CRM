<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="12u">
    <h3>Create group</h3>
    <sf:form method="post" modelAttribute="group" action="/groupSave">
        <fieldset>
            <div class="row uniform">
                <div class="6u 12u$(xsmall)">
                    <sf:label path="name">Group Name:</sf:label>
                </div>
                <div class="6u 12u$(xsmall)">
                    <sf:input path="name"/>
                    <sf:errors path="name"/>
                </div>
            </div>
            <div class="row uniform">
                <div class="6u 12u$(xsmall)">
                    <sf:label path="teacherId"> Teacher: </sf:label>
                </div>
                <div class="6u 12u$(xsmall)">
                    <sf:select path="teacherId">
                        <c:forEach items="${teachers}" var="teach">
                            <sf:option value="${teach.id}"
                            label="${teach.user.login} (${teach.person.firstName} ${teach.person.middleName} ${teach.person.lastName})"/>
                        </c:forEach>
                    </sf:select>
                </div>
            </div>
            <div class="12u$">
                    <input type="submit" value="Add group"/>
            </div>
        </fieldset>
    </sf:form>
</div>
