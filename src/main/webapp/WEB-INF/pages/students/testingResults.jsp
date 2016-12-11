<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-sm-12">
        <h2 class="page-header">${person.lastName} ${person.firstName} ${person.middleName} </h2>
    </div>
</div>
<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Testing results at</strong>
                <input name="testingDate" type="date" value=${checkpointDate}/>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="studentLevelHistory" action="/saveTestingResults">
                    <fieldset class="form-group">

                        <div class="container">
                            <h4>Speaking</h4>
                            <label class="radio-inline">
                                <input type="radio" name="grammar" id="0" value="Start" checked>Start
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="grammar" id="1" value="A1">A1
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="grammar" id="2" value="A2">A2
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="grammar" id="3" value="B1">B1
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="grammar" id="4" value="B2">B2
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="grammar" id="5" value="C1">C1
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="grammar" id="6" value="C2">C2
                            </label>
                        </div>

                        <div class="container">
                            <h4>Speaking</h4>
                            <label class="radio-inline">
                                <input type="radio" name="speaking" id="0" value="Start" checked>Start
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="speaking" id="1" value="A1">A1
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="speaking" id="2" value="A2">A2
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="speaking" id="3" value="B1">B1
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="speaking" id="4" value="B2">B2
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="speaking" id="5" value="C1">C1
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="speaking" id="6" value="C2">C2
                            </label>
                        </div>

                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="submit" value="Save results" class="btn btn-success"/>
                            </div>
                        </div>
                    </fieldset>
                </sf:form>
            </div>
        </div>
    </div>
</div>