<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<div class="pipe_line_canvas">
    <c:if test="${not empty cards}">
    <div class="scroll">
        <c:forEach items="${cards}" var="card">
            <div class="pipe_wrapper">

                <div class="pipe ui-widget ui-helper-clearfix ui-helper-reset ">

                    <div class="editToolbar">
                        <form method="post" action="/editCardName" id="cardNameForm">
                            <input type="text" value="${card.cardName}" name="cardName" id="cardName">
                            <input type="hidden" value="${card.id}" name="cardId">
                            <input type="hidden" value="${pt.id}" name="pipeTypeId">
                            <button type="submit" class="btn btn-default btn-xs" id="submitCardName"><span
                                    class="glyphicon glyphicon-pencil"></span></button>
                        </form>

                        <form method="post" action="/deleteCard" id="deleteCardForm">
                            <button type="submit" class="btn btn-default btn-xs"><span
                                    class="glyphicon glyphicon-remove"></span></button>
                            <input type="hidden" value="${card.id}" name="cardId">
                            <input type="hidden" name="pipeTypeId" value="${pt.id}">
                        </form>
                    </div>

                    <c:forEach items="${card.persons}" var="person">

                        <div class="person ui-widget-content ui-corner-tr">
                            <div class="avatar">
                                <c:if test="${person.avatarURL==null}">
                                    <span class="glyphicon glyphicon-picture"/>
                                </c:if>
                                <c:if test="${person.avatarURL!=null}">
                                    <img src="${person.avatarURL}" class="img-responsive"/>
                                </c:if>
                            </div>
                            <div class="personData">
                                <p>
                                        ${person.lastName}
                                        ${fn:substring(person.firstName,0,1)}.${fn:substring(person.middleName,0,1)}.
                                </p>
                            </div>


                            <form method="post" action="/leadAdd" class="editPersonFrom">
                                <input type="hidden" value="${card.id}" name="cardId">
                                <input type="hidden" value="${pt.id}" name="pipeTypeId">
                                <button type="submit" class="btn btn-default btn-xs">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </button>
                            </form>


                            <form method="post" action="/deleteLeadFromPipe" class="deletePersonForm">
                                <button type="submit" class="btn btn-default btn-xs">
                                    <span class="glyphicon glyphicon-remove"></span>
                                </button>
                                <input type="hidden" name="cardId" value="${card.id}">
                                <input type="hidden" name="pipeTypeId" value="${pt.id}">
                            </form>

                        </div> <%-- end person --%>

                    </c:forEach>
                </div>

                <form method="post" action="/leadAdd">
                    <input type="hidden" name="cardId" value="${card.id}">
                    <input type="hidden" name="pipeTypeId" value="${pt.id}">
                    <button type="submit" class="add">
                        <span>Add Lead</span>
                    </button>
                </form>

            </div>
        </c:forEach>
        </c:if>

        <c:if test="${pt.id > 0 || pt.id != null}">
            <div class="pipe_wrapper">
                <form class="pipe" method="post" action="/addCard">
                    <input type="submit" value="Add Card" class="add_pipe">
                    <input type="hidden" name="pipeTypeId" value="${pt.id}">
                </form>
            </div>
        </c:if>
    </div>
</div>
<style media="screen" type="text/css">
    body {
        overflow-y: hidden;
    }

    .editToolbar {
        margin: 0;
        padding: 0;

        height: 50px;
        border: solid #0f0f0f;
    }

    .editToolbar from {
        height: 50px;
        margin: 0px;
        padding: 0px;
    }

    .editToolbar #cardNameForm {
        width: 90%;
        float: left;
    }

    .editToolbar #cardName {
        width: 83%;
        float: left;
        height: 44px;
    }

    .editToolbar #submitCardName {
        width: 12%;
    }

    .editToolbar #deleteCardForm {
        width: 9%;
        float: right;
        margin-right: 1%
    }


    .pipe .person {
        float: left;
        width: 100%;
        height: 10%;
        border: solid #0f0f0f;
        margin-bottom: 10px;
        margin-top: 10px;
    }

    .editPersonFrom {
        width: 12%;
        margin: 0%;
        padding: 0%;
        float: left;
    }

    .deletePersonForm {
        width: 12%;
        margin: 0%;
        padding: 0%;
    }

    .avatar {
        width: 10%;
        float: left;
    }

    .personData {
        float: left;
    }

</style>
<script>
    $(document).ready(function () {
        $("#cardName").datepicker();

        $(".pipe .person").draggable({
            cancel: "a.ui-icon",
            revert: "invalid",
            containment: "document",
            helper: "clone",
            cursor: "move"
        });

        $(".pipe").droppable({
            accept: ".pipe .person",

            classes: {
                "ui-droppable-active": "ui-state-highlight"
            },



            drop: function (event, ui) {
                movePerson(ui.draggable, $(event.target));
            }
        });

        function movePerson($item, $target) {
            $item.appendTo($target).fadeIn();
        }

        $(".person").css("width", $(".pipe").css("width"));

        $('.pipe_wrapper #deleteCardForm').first().remove();

    });
</script>