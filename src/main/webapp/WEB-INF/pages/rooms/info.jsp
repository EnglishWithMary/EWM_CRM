<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">Teachers list</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>List of Events in ${room.name}</strong>
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
                <p><a href="/rooms/${room.id}/add-event" class="btn btn-success">Add Event</a></p>
                <p><a href="/rooms/${room.id}/edit" class="btn btn-success">Edit Room</a></p>
            </div>
        </div>
    </div>
</div>
