<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-sm-12">
        <h2 class="page-header">Create group</h2>
    </div>
</div>
<div class="row">
    <div class="col-sm-4 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Enter Details:</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="group" action="/groupSave">
                    <fieldset>
                        <div class="row padding-bot">
                            <div class="col-sm-12">
                                <sf:label path="name">Group Name:</sf:label>
                                <sf:input path="name"/>
                                <sf:errors path="name"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-12">
                                <sf:label path="teacherId"> Teacher: </sf:label>
                                <sf:select path="teacherId">
                                    <c:forEach items="${teachers}" var="teach">
                                        <sf:option value="${teach.id}"
                                                   label="${teach.user.login} (${teach.person.firstName} ${teach.person.middleName} ${teach.person.lastName})"/>
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