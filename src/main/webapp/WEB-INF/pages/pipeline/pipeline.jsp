<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

    .card
    {
        height: 150px;
        border: solid #25a2c3;
        width: 150px;
        margin: 10px;
        float: left;
    }
</style>

<div class="12u">
    <div class="row uniform">

    <div class="6u 12u$(xsmall)">
        <a href="/takeLeadtpipe" class="button">Leads</a>
    </div>

    <div class="6u 12u$(xsmall)">
        <a href="/takeStudentpipe" class="button">Students</a>
    </div>

        <c:if test="${pt.id > 0 || pt.id != null}">
            <div class="6u 12u$(xsmall)">
                <form method="post" action="/addCard">
                    <input type="submit" value="Add Card" class="button">
                    <input type="hidden" name="pt_id" value="${pt.id}">
                </form>
            </div>
        </c:if>


        <c:forEach items="${cards}" var="card">
            <div class="card">
                ${card.id}
            </div>
        </c:forEach>
</div>
</div>