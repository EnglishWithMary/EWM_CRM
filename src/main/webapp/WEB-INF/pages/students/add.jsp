<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-sm-12">
        <h2 class="page-header">Create student</h2>
    </div>
</div>
<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Add new Student</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="student" id="form" action="/studentSave">
                    <fieldset class="form-group">

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="firstName">First Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="firstName" cssClass="form-control"/>
                                <sf:errors path="firstName" cssClass="has-error"/>
                            </div>
                        </div>

                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="lastName">Last Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="lastName" cssClass="form-control"/>
                                <sf:errors path="lastName" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="middleName">Middle Name:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="middleName" cssClass="form-control"/>
                                <sf:errors path="middleName" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="email">Email:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="email" type="email" cssClass="form-control"/>
                                <sf:errors path="email" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="login" name="login">Login:</sf:label><span></span>
                            </div>
                            <div class="col-sm-6">
                                <sf:input path="login" name="login" cssClass="form-control"/>
                                <sf:errors path="login" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="password">Password:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:password path="password" cssClass="form-control"/>
                                <sf:errors path="password" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="confirmPassword">Confirm password:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:password path="confirmPassword" cssClass="form-control"/>
                                <sf:errors path="confirmPassword" cssClass="has-error"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <sf:label path="comments">Comments:</sf:label>
                            </div>
                            <div class="col-sm-6">
                                <sf:textarea path="comments" rows="5"/>
                                <sf:errors path="comments"/>
                            </div>
                        </div>
                        <div class="row padding-bot">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                            <label path="teacher_id">Teacher:</label>
                            </div>
                            <div class="col-sm-6">
                                        <select path="teacher_id" class="form-control">
                                            <option value="">Set teacher later...</option>
                                            <c:forEach items="${teachers}" var="teacher">
                                                <option value="${teacher.id}">${teacher.person.firstName}</option>
                                            </c:forEach>
                                        </select>
                                <%--<select name="teacher_id" class="form-control">--%>
                                    <%--<option value="">Set teacher later...</option>--%>
                                    <%--<c:forEach var="teacher" items="${teachers}">--%>
                                        <%--<option value="${teacher.id}">${teacher.person.firstName}</option>--%>
                                    <%--</c:forEach>--%>
                                <%--</select>--%>
                            </div>
                        </div>
                        <div class="row padding-bot ">
                            <div class="col-sm-1"></div>
                            <div class="col-sm-4">
                                <label path="group_id">Group:</label>
                            </div>
                            <div class="col-sm-6">
                                <select path="group_id" class="form-control">
                                    <option value="">Set group later...</option>
                                    <c:forEach items="${groups}" var="group">
                                        <option value="${group.id}">${group.name}</option>
                                    </c:forEach>
                                </select>
                                <br/>
                            <%--<div class="col-sm-6">--%>
                                <%--<select name="group_id" class="form-control">--%>
                                    <%--<option value="">Set group later...</option>--%>
                                    <%--<c:forEach var="group" items="${groups}">--%>
                                        <%--<option value="${group.id}">${group.name}</option>--%>
                                    <%--</c:forEach>--%>
                                <%--</select>--%>
                            <%--</div>--%>
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

<script type="text/javascript">

    $("#login").change(function(){
        login =  $("#login").val();
        var expLogin = /^[a-zA-Z0-9_]+$/g;
        var resLogin =  login.search(expLogin);
        if(resLogin ==  -1){
            $("#login").next().hide().text("Неверный  логин").css("color","red").
            fadeIn(400);
            $("#login").removeClass().addClass("inputRed");
            loginStat  = 0;
            buttonOnAndOff();
        }else{
            $.ajax({
                url:  "/studentAdd",
                type:  "GET",
                data:  "login=" + login,
                cache:  false,
                success:  function(response){
                    if(response  == "no"){
                        $("#login").next().hide().
                        text("Логин  занят").css("color","red").fadeIn(400);
                        $("#login").removeClass().
                        addClass("inputRed");
                    }else{
                        $("#login").removeClass().
                        addClass("inputGreen");
                        $("#login").next().text("");
                    }
                }
            });
            loginStat  = 1;
            buttonOnAndOff();
        }
    });
    $("#login").keyup(function(){
        $("#login").removeClass();
        $("#login").next().text("");
    });
    function  buttonOnAndOff(){
        if(loginStat  == 1){
            $("#submit").removeAttr("disabled");
        }else{
            $("#submit").attr("disabled","disabled");
        }
    }
</script>