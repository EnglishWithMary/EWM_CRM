<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Edit Room's values</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="room" action="/rooms/${room.id}/edit" id="form">
                    <fieldset class="form-group">

                        <input type="hidden" class="hidden-xs-up" name="id" value="${room.id}"/>

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="name">Room's Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <input id="name" name="name" class="form-control" value="${room.name}"/>
                                <sf:errors path="name" cssClass=""/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="Color">Pick Color:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <div id="color-picker" class="input-group colorpicker-component">
                                    <input name="Color" type="text" value="${room.color}" class="form-control"/>
                                    <span class="input-group-addon"><i></i></span>
                                </div>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="submit" value="Save" class="btn btn-success"/>
                            </div>
                        </div>
                    </fieldset>
                </sf:form>
            </div>
        </div>
    </div>
</div>
