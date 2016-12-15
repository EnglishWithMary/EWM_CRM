<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">List of Rooms</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>List of Rooms</strong>
            </div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Room Name</th>
                        <th>Calendar</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="room" items="${rooms}">
                        <tr>
                            <td>${room.name}</td>
                            <td><a href="/rooms/${room.id}/info" class="btn btn-default btn-sm">Calendar</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Tools</strong>
            </div>
            <div class="panel-body">
                <p><a href="/rooms/add" class="btn btn-success">Add Room</a></p>
            </div>
        </div>
    </div>
</div>
