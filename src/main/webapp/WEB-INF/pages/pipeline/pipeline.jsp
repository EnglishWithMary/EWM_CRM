<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="pipe_line_canvas">
    <div class="scroll row row-horizon">
        <c:if test="${not empty cards}">

            <c:forEach items="${cards}" var="card">
                <div class="pipe_wrapper col-lg-2 col-md-3 col-sm-4 col-xs-12">

                <div class="pipe scrollbox">

                        <div class="editToolbar container-fluid">
                            <div class="row">
                                <div class="editCardForm col-lg-10 col-md-10 col-sm-8 col-xs-8">
                                <form method="post" action="/editCardName" id="cardNameForm" >
                                    <input type="text" class="form-control" value="${card.cardName}" name="cardName"
                                           id="cardName">
                                    <input type="hidden" value="${card.id}" name="cardId">
                                    <input type="hidden" value="${pipeType.id}" name="pipeTypeId">
                                    <button type="submit" class="btn btn-default btn-xs" id="submitCardName"><span
                                            class="glyphicon glyphicon-pencil"></span></button>
                                </form>
                                </div>
                                    <div class="deleteCardForm col-lg-2 col-md-2 col-sm-2 col-xs-2">
                                <form method="post" action="/deleteCard" id="deleteCardForm">
                                    <button type="submit" class="btn btn-default btn-xs"><span
                                            class="glyphicon glyphicon-remove"></span></button>
                                    <input type="hidden" value="${card.id}" name="cardId">
                                    <input type="hidden" name="pipeTypeId" value="${pipeType.id}">
                                </form>
                                </div>
                            </div>
                        </div>

                    <c:forEach items="${card.persons}" var="person">

                            <div class="person container-fluid">
                                <div class="row">

                                    <input type="hidden" id="from" name="from" value="${card.id}">

                                    <div class="avatar col-lg-2 col-md-2 col-sm-2 col-xs-2">
                                        <c:if test="${person.avatarURL==null}">
                                            <img class="img-rounded img-responsive" alt="Responsive image"
                                                 src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                                        </c:if>
                                        <c:if test="${person.avatarURL!=null}">
                                            <img src="${person.avatarURL}" class="img-responsive"/>
                                        </c:if>
                                    </div>
                                    <div class="personData ol-lg-7 col-md-7 col-sm-7 col-xs-7">
                                        <input type="hidden" id="personId" name="personId" value="${person.id}">
                                        <p>
                                                ${person.lastName}
                                                ${fn:substring(person.firstName,0,1)}.${fn:substring(person.middleName,0,1)}.
                                        </p>
                                    </div>

                            <div class="person-edit-tool-bar col-lg-3 col-md-3 col-sm-3 col-xs-3">
                                <form method="post" action="/leadAdd" class="editPersonFrom btn-xs">
                                    <input type="hidden" name="personId" value="${person.id}">
                                    <button type="submit" class="pipe-button btn btn-default btn-xs">
                                        <span class="glyphicon glyphicon-pencil"></span>
                                    </button>
                                </form>

                                <button type="button" class="btn btn-default btn-xs"
                                        data-toggle="modal" data-target="#modal${person.id}">
                                    <span class="glyphicon glyphicon-remove"></span>
                                </button>
                            </div>

                            </div> <%-- end person --%>

                        <div class="modal fade" id="modal${person.id}">
                            <div class="modal-dialog" >
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
                                        <div class="col-md-3">
                                            <form method="post" action="/leadDeleteFromPipe"
                                                  class="deletePersonForm">
                                                <button type="submit" class="btn btn-default btn-xs">
                                                    Reset position
                                                </button>
                                                <input type="hidden" name="personId" value="${person.id}">
                                            </form>
                                        </div>
                                        <div class="col-md-3">
                                            <form method="post" action="/deleteLead" class="deletePersonForm">
                                                <button type="submit" class="btn btn-default btn-xs">
                                                    Delete
                                                </button>
                                                <input type="hidden" name="personId" value="${person.id}">
                                            </form>
                                        </div>
                                        <div class="col-md-3">
                                            <form method="post" action="/leadTrash" class="deletePersonForm">
                                                <button type="submit" class="btn btn-default btn-xs">
                                                    Move to trash
                                                </button>
                                                <input type="hidden" name="personId" value="${person.id}">
                                            </form>
                                        </div>
                                        <div class="col-md-3">
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

                    <input type="hidden" id="destination" name="destination" value="${card.id}">
                </div>

                <c:if test="${pipeType.id==1}">
                    <form method="post" action="/leadAdd">
                        <input type="hidden" name="cardId" value="${card.id}">
                        <button type="submit" class="btn btn-success">
                            <span>Add Lead</span>
                        </button>
                    </form>
                </c:if>

                <c:if test="${pipeType.id==2}">
                    <form method="post" action="/studentAdd">
                        <input type="hidden" name="cardId" value="${card.id}">
                        <input type="hidden" name="pipeTypeId" value="${pipeType.id}">
                        <button type="submit" class="btn btn-success">
                            <span>Add Student</span>
                        </button>
                    </form>
                </c:if>

            </div>
        </c:forEach>
    </c:if>

        <c:if test="${pipeType.id > 0 || pipeType.id != null}">
            <div class="pipe_wrapper col-lg-2 col-md-3 col-sm-4 col-xs-12">
                <form class="pipe" method="post" action="/addCard">
                    <input type="submit" value="Add Card" class="add_pipe btn btn-success">
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

