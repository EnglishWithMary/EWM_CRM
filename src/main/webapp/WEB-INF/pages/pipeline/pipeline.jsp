<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<div class="pipe_line_canvas">
    <c:if test="${not empty cards}">
    <div class="scroll">
        <c:forEach items="${cards}" var="card">
            <div class="pipe_wrapper ui-widget ui-helper-clearfix">

                <div class="pipe ui-helper-clearfix ui-helper-reset">

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

                            <input type="hidden" id="from" name="from" value="${card.id}">

                            <div class="avatar">
                                <c:if test="${person.avatarURL==null}">
                                    <span class="glyphicon glyphicon-picture"/>
                                </c:if>
                                <c:if test="${person.avatarURL!=null}">
                                    <img src="${person.avatarURL}" class="img-responsive"/>
                                </c:if>
                            </div>
                            <div class="personData ui-widget-header">
                                <input type="hidden" id="personId" name="personId" value="${person.id}">
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

                    <input type="hidden" id="destination" name="destination" value="${card.id}">
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
</style>
<script>
    $(document).ready(function () {

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

            drop: function( event, ui ) {
                movePerson( ui.draggable, $(event.target) );

                //personId
                var $draggable_item = ui.draggable;
                //var $from_input = $($draggable_item).find("#from");

                var from = $($draggable_item).find("#from").val(); // Source card number
                var personId = $($draggable_item).find("#personId").val(); // Draggable person

                var $target = $(event.target); // Pipe where we drag person

                var destination = $($target).find("#destination").val(); // Destination card number

                $($draggable_item).find("#from").attr("value", destination);

                var json = { "destination" : destination, "from" : from, "personId" : personId};

                if(destination != from) {
                    $.ajax({
                        url: '/moveLeadAjax',
                        dataType: 'json',
                        type: 'POST',
                        data: JSON.stringify(json),
                        contentType: 'application/json',

                        success: function (data) {
                        }
                    });
                }
            }
        });

        function movePerson($item, $target) {
            $item.appendTo($target).fadeIn();
        }

        $(".person").css("width", $(".pipe").css("width"));

        $('.pipe_wrapper #deleteCardForm').first().remove();



    });

</script>