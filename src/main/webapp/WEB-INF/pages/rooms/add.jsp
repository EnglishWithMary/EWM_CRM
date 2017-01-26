<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Add Room</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="room" action="/rooms/add" id="form">
                    <fieldset class="form-group">

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="name">Room's Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="name" cssClass="form-control"/>
                                <sf:errors path="name" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="color">Pick Color:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <div id="color-picker" class="input-group colorpicker-component">
                                    <input name="color" type="text" value="${room.color==null?"#00AABB":room.color}" class="form-control" />
                                    <span class="input-group-addon"><i></i></span>
                                </div>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="submit" value="Add Room" class="btn btn-success"/>
                            </div>
                        </div>
                    </fieldset>
                </sf:form>
            </div>
        </div>
    </div>
</div>
