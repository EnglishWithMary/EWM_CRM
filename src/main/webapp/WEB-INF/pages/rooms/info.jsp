<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">${room.name}</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Calendar for room</strong>
            </div>
            <div class="panel-body">
                <div id="calendar"></div>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Tools</strong>
            </div>
            <div class="panel-body">
                <p>
                    <select id="change-room-select" class="form-control">
                        <option value="">Click to choose room</option>
                        <c:forEach var="roomItem" items="${rooms}">
                            <option value="rooms/${roomItem.id}/info">${roomItem.name}</option>
                        </c:forEach>
                    </select>
                </p>
                <p><a href="/rooms/${room.id}/edit" class="btn btn-success">Edit Room</a></p>
            </div>
        </div>
    </div>
</div>
