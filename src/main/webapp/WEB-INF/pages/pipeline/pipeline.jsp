<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="pipe_line_canvas">
    <c:if test="${not empty cards}">
        <div class="scroll">
            <c:forEach items="${cards}" var="card">
                <div class="pipe_wrapper">
                    <div class="pipe">
                        <div class="editToolbar">
                            <form method="post" action="/editCardName" style="width: 90%; float: left;">
                                <input type="text" value="${card.cardName}" name="cardName"
                                       style="width: 83%; float: left; height: 44px">
                                <input type="hidden" value="${card.id}" name="cardId">
                                <input type="hidden" value="${pt.id}" name="pipeTypeId">
                                <button type="submit" class="btn btn-default btn-xs" style="width: 12%"><span
                                        class="glyphicon glyphicon-pencil"></span></button>
                            </form>

                            <form method="post" action="/deleteCard" style="width: 9%; float: right; margin-right: 1%">
                                <button type="submit" class="btn btn-default btn-xs"><span
                                        class="glyphicon glyphicon-remove"></span></button>
                                <input type="hidden" value="${card.id}" name="cardId">
                                <input type="hidden" name="pipeTypeId" value="${pt.id}">
                            </form>
                        </div>

                        <c:forEach items="${card.persons}" var="person">
                            <div class="editToolbar">
                                <div class="col-md-2">
                                    <c:if test="${person.avatarURL==null}">
                                        <span class="glyphicon glyphicon-picture"/>
                                    </c:if>
                                    <c:if test="${person.avatarURL!=null}">
                                        <img src="${person.avatarURL}" class="img-responsive"/>
                                    </c:if>
                                </div>
                                <div class="col-md-6">
                                    <p>
                                        ${person.lastName}
                                        ${fn:substring(person.firstName,0,1)}.${fn:substring(person.middleName,0,1)}.
                                    </p>
                                </div>

                                <div class="col-md-2">
                                    <form method="post" action="/leadAdd">
                                        <input type="hidden" value="${person.id}" name="personId"/>
                                        <input type="hidden" value="${card.id}" name="cardId"/>
                                        <input type="hidden" value="${pt.id}" name="pipeTypeId"/>
                                        <button type="submit" class="btn btn-default btn-xs"/>
                                            <span class="glyphicon glyphicon-pencil"></span>
                                        </button>
                                    </form>
                                </div>

                                <div class="col-md-2">
                                    <form method="post" action="/deleteLead">
                                        <button type="submit" class="btn btn-default btn-xs">
                                            <span class="glyphicon glyphicon-remove"></span>
                                        </button>
                                        <input type="hidden" name="personId" value="${person.id}">
                                        <input type="hidden" name="cardId" value="${card.id}">
                                        <input type="hidden" name="pipeTypeId" value="${pt.id}">
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                        <form method="post" action="/leadAdd">
                            <input type="hidden" name="cardId" value="${card.id}">
                            <input type="hidden" name="pipeTypeId" value="${pt.id}">
                            <button type="submit" class="add">
                                <span>Add Lead</span>
                            </button>
                        </form>
                    </div>
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