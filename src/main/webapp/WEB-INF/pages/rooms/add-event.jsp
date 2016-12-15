<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-sm-12">
        <h2 class="page-header">Add event</h2>
    </div>
</div>
<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Add Event</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="RoomEvent" action="/rooms/${room_id}/add-event">
                    <fieldset class="form-group">

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="Title">First Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="Title" cssClass="form-control"/>
                                <sf:errors path="Title" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="Start">Start Time:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <div class="input-group date" id="date-start">
                                        <sf:input path="Start" cssClass="form-control"/>
                                        <span class="input-group-addon">
                                            <span class="fa fa-calendar"></span>
                                        </span>
                                    </div>
                                    <sf:errors path="Start" cssClass="has-error"/>
                                </div>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="End">Start Time:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <div class="form-group">
                                    <div class="input-group date" id="date-end">
                                        <sf:input path="End" cssClass="form-control"/>
                                        <span class="input-group-addon">
                                            <span class="fa fa-calendar"></span>
                                        </span>
                                    </div>
                                    <sf:errors path="Start" cssClass="has-error"/>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="submit" value="Add Event" class="btn btn-success"/>
                            </div>
                        </div>
                    </fieldset>
                </sf:form>
            </div>
        </div>
    </div>
</div>
