<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="pipe_line_canvas">
    <c:if test="${not empty cards}">
    <div class="scroll">
        <c:forEach items="${cards}" var="card">
            <div class="pipe_wrapper">

                <div class="pipe">

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

                        <div class="person">

                            <input type="hidden" id="from" name="from" value="${card.id}">

                            <div class="avatar">
                                <c:if test="${person.avatarURL==null}">
                                    <span class="glyphicon glyphicon-picture"/>
                                </c:if>
                                <c:if test="${person.avatarURL!=null}">
                                    <img src="${person.avatarURL}" class="img-responsive"/>
                                </c:if>
                            </div>
                            <div class="personData">
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
            <%--


                                <div class="col-md-2">
                                    <button type="button" class="btn btn-default btn-xs"
                                            data-toggle="modal" data-target="#modal${person.id}">
                                        <span class="glyphicon glyphicon-remove"></span>
                                    </button>
                                </div>
                            </div>
                            <div class="modal fade" id="modal${person.id}"
                                 tabindex="-1" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button class="close" type="button" data-dismiss="modal">
                                                <i class="fa fa-close"></i>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <p>Are you sure you want to delete the lead?</p>
                                        </div>
                                        <div class="modal-footer row">
                                            <div class="col-md-4">
                                                <form method="post" action="/deleteLead">
                                                    <button type="submit" class="btn btn-default btn-xs">
                                                        Delete
                                                    </button>
                                                    <input type="hidden" name="personId" value="${person.id}">
                                                    <input type="hidden" name="cardId" value="${card.id}">
                                                    <input type="hidden" name="pipeTypeId" value="${pipeType.id}">
                                                </form>
                                            </div>
                                            <div class="col-md-4">
                                                <form method="post" action="/leadTrash">
                                                    <button type="submit" class="btn btn-default btn-xs">
                                                        Move to trash
                                                    </button>
                                                    <input type="hidden" name="personId" value="${person.id}">
                                                    <input type="hidden" name="cardId" value="${card.id}">
                                                    <input type="hidden" name="pipeTypeId" value="${pipeType.id}">
                                                </form>
                                            </div>
                                            <div class="col-md-4">
                                                <button class="btn btn-default btn-xs" type="button"
                                                        data-dismiss="modal">
                                                    Cancel
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        <form method="post" action="/leadAdd">
                            <input type="hidden" name="cardId" value="${card.id}">
                            <input type="hidden" name="pipeTypeId" value="${pipeType.id}">
                            <button type="submit" class="add">
                                <span>Add Lead</span>
                            </button>
                        </form>
                    </div>
                </div>
            </c:forEach>

            --%>
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