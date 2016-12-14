<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">Teachers list</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>List of Rooms</strong>
            </div>
            <div class="panel-body">
                <form method="get" action="">
                    <div class="form-group">
                        <input type="submit" value="Sort ... In Developement" class="btn btn-default">
                    </div>
                </form>

                <%--<div class="table-wrapper">--%>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Room</th>
                        <th>Info</th>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <th>Delete Room</th>
                        </security:authorize>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="room" items="${rooms}">
                        <tr>
                            <td>${room.name}</td>
                            <td><a href="/rooms/info?id=${room.id}">info</a></td>
                            <td>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <a href="">Delete (does nothing)</a>
                                </security:authorize>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


                <%--PAGINATION MIGHT BE NESSECARY--%>
                <%--<div class="row">--%>
                <%--<div class="col-sm-2 col-sm-offset-5">--%>
                <%--<c:if test="${pages > 1}">--%>
                <%--<ul class="pagination">--%>
                <%--<c:forEach var="page" begin="1" end="${pages}">--%>
                <%--<li class="${(page eq param.page) or ((param.page eq null) and (page eq 1))? 'active' : ''}">--%>
                <%--<a href="/teachers?page=${page}&flagSorted=${flagSorted}">--%>
                <%--${page}--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--</c:forEach>--%>
                <%--</ul>--%>
                <%--</c:if>--%>
                <%--</div>--%>
                <%--</div>--%>
            </div>

            <%--</div>--%>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Tools</strong>
            </div>
            <div class="panel-body">
                <p><a href="/rooms/add" class="btn btn-success">Add Room</a></p>
            </div>
        </div>
    </div>
</div>
