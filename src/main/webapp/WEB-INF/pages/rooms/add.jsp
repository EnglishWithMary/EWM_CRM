<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-sm-12">
        <h2 class="page-header">Create teacher</h2>
    </div>
</div>
<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Add new Teacher</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="room" action="/rooms/add">
                    <fieldset class="form-group">

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="Name">First Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="Name" cssClass="form-control"/>
                                <sf:errors path="Name" cssClass="has-error"/>
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
