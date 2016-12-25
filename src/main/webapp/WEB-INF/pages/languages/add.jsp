<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-sm-12">
        <h2 class="page-header">Create Language</h2>
    </div>
</div>
<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Add new Language</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="language" action="/languageSave">
                    <fieldset class="form-group">
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="language">Language:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="language" cssClass="form-control"/>
                                <sf:errors path="language" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="submit" value="Add student" class="btn btn-success"/>
                            </div>
                        </div>
                    </fieldset>
                </sf:form>
            </div>
        </div>
    </div>
</div>
