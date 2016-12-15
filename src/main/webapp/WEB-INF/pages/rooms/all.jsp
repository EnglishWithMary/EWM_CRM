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
                <strong>List of Rooms</strong>
            </div>
            <div class="panel-body">
                <form method="get" action="">
                    <div class="form-group">
                        <input type="submit" value="Sort ... In Developement" class="btn btn-default">
                    </div>
                </form>

                <c:forEach var="room" items="${rooms}">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Event Name</th>
                            <th>Start Time</th>
                            <th>End Time</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="event" items="${events}">
                            <tr>
                                <td>${event.getSummary}</td>
                                <td>${event.getStart.getDateTime}</td>
                                <td>${event.getEnd.getDateTime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:forEach>


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
