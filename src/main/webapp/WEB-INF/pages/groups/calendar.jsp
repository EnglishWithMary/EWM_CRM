<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">Group "${group.name}'s" Calendar</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>List of Events in ${group.name}</strong>
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
                <p><a href="/group/${group.id}/add-event" class="btn btn-success">Add Event</a></p>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <form class="form-horizontal" role="form">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add Event</h4>
                </div>

                <div class="modal-body">

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="title">Title:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="title"
                                   id="title" placeholder="title"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="room">Room:</label>
                        <div class="col-sm-10">
                            <select id="room" class="form-select-button">
                                <c:forEach var="room" items="${rooms}">
                                    <option value="${room.id}">${room.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="date-start">Start Time</label>
                        <div class="col-sm-10">
                            <div class="input-group date" id="date-start">
                                <input type="text" placeholder="start" class="form-control"/>
                                <span class="input-group-addon">
                                    <span class="fa fa-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="date-end">End Time</label>
                        <div class="col-sm-10">
                            <div class="input-group date" id="date-end">
                                <input type="text" placeholder="end" class="form-control"/>
                                <span class="input-group-addon">
                                    <span class="fa fa-calendar"></span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <input type="hidden" id="eventId" value="0" class="hidden">
                    <div class="form-group col-sm-10">
                        <button id="success" type="button" class="btn btn-success">Add/Update Event</button>
                    </div>

                    <div class="form-group col-sm-10">
                        <button id="delete" type="button" class="btn btn-success">Delete Event</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>
