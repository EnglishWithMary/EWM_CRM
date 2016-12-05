<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
                            <input type="hidden" value="${pipeType.id}" name="pipeTypeId">
                            <button type="submit" class="btn btn-default btn-xs" id="submitCardName"><span
                                    class="glyphicon glyphicon-pencil"></span></button>
                        </form>

                        <form method="post" action="/deleteCard" id="deleteCardForm">
                            <button type="submit" class="btn btn-default btn-xs"><span
                                    class="glyphicon glyphicon-remove"></span></button>
                            <input type="hidden" value="${card.id}" name="cardId">
                            <input type="hidden" name="pipeTypeId" value="${pipeType.id}">
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
                                <input type="hidden" value="${pipeType.id}" name="pipeTypeId">
                                <button type="submit" class="btn btn-default btn-xs">
                                    <span class="glyphicon glyphicon-pencil"></span>
                                </button>
                            </form>


                            <form method="post" action="/deleteLeadFromPipe" class="deletePersonForm">
                                <button type="submit" class="btn btn-default btn-xs">
                                    <span class="glyphicon glyphicon-remove"></span>
                                </button>
                                <input type="hidden" name="cardId" value="${card.id}">
                                <input type="hidden" name="pipeTypeId" value="${pipeType.id}">
                            </form>

                        </div> <%-- end person --%>

                    </c:forEach>

                    <input type="hidden" id="destination" name="destination" value="${card.id}">
                </div>

                <form method="post" action="/leadAdd">
                    <input type="hidden" name="cardId" value="${card.id}">
                    <input type="hidden" name="pipeTypeId" value="${pipeType.id}">
                    <button type="submit" class="add">
                        <span>Add Lead</span>
                    </button>
                </form>

            </div>
        </c:forEach>
        </c:if>

        <c:if test="${pipeType.id > 0 || pipeType.id != null}">
            <div class="pipe_wrapper">
                <form class="pipe" method="post" action="/addCard">
                    <input type="submit" value="Add Card" class="add_pipe">
                    <input type="hidden" name="pipeTypeId" value="${pipeType.id}">
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