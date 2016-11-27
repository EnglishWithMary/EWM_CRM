<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <a href="/takeLeadtpipe" class="button">Leads</a>


    <a href="/takeStudentpipe" class="button">Students</a>


    <c:if test="${pt.id > 0 || pt.id != null}">
        <form method="post" action="/addCard">
            <input type="submit" value="Add Card" class="button" style="margin: 10px">
            <input type="hidden" name="pt_id" value="${pt.id}">
        </form>
    </c:if>
</div>


<c:if test="${not empty cards}">
    <div class="scroll">
        <div class="scroll_child">
            <c:forEach items="${cards}" var="card">
                <div class="card">

                    <div class="editToolbar" >
                        <form method="post" action="/editCardName" style="width: 90%; float: left;">
                            <input type="text" value="${card.cardName}" name="cardName" style="width: 83%; float: left; height: 44px" >
                            <input type="hidden" value="${card.id}" name="card_id">
                            <input type="hidden" value="${pt.id}" name="pt_id">
                            <button type="submit" class="btn btn-default btn-xs" style="width: 12%"><span
                                    class="glyphicon glyphicon-pencil"></span></button>
                        </form>

                    <form method="post" action="/deleteCard" style="width: 9%; float: right; margin-right: 1%">
                        <button type="submit" class="btn btn-default btn-xs"><span
                                class="glyphicon glyphicon-remove"></span></button>
                        <input type="hidden" value="${card.id}" name="card_id">
                        <input type="hidden" name="pt_id" value="${pt.id}">
                    </form>
                </div>


                    <button type="submit" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-plus"></span>
                    </button>

                </div>
            </c:forEach>
        </div>
    </div>
</c:if>