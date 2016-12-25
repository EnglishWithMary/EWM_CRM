<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-sm-12">
        <h1 class="page-header">Languages</h1>
    </div>
</div>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">

            <div class="panel-heading">
                <strong>List of Languages</strong>
            </div>

            <div class="panel-body">
                <%--<div class="row">--%>
                    <%--<div class="col-sm-9">--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-sm-6">--%>
                                <%--<div class="row">--%>
                                    <%--<form method="post" action="/languages">--%>
                                        <%--<div class="col-sm-7">--%>
                                            <%--<select name="teacher_id" class="selectpicker form-control"--%>
                                                    <%--data-actions-box="true" data-size="5">--%>
                                                <%--<option value="">All languages</option>--%>
                                                <%--<option value="-1">Languages without teachers</option>--%>
                                                <%--<c:forEach var="language" items="${languages}">--%>
                                                    <%--<option value="${language.id}">${language.language}</option>--%>
                                                <%--</c:forEach>--%>
                                            <%--</select>--%>
                                        <%--</div>--%>
                                        <%--<div class="col-sm-5">--%>
                                            <%--<input type="submit" class="btn btn-default" value="Find"/>--%>
                                        <%--</div>--%>
                                    <%--</form>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</div>--%>
                    <div class="row">
                    <div class="col-sm-12">
                        <form method="post" action="/languages">
                            <table id = "table-list" class="table table-striped table-bordered">                            <thead>
                            <tr>
                                <th>Language</th>
                            </tr>
                                <tfoot>
                                    <tr>
                                        <th>Language</th>
                                    </tr>
                                </tfoot>
                                <tbody>
                                <c:forEach var="language" items="${languages}">
                                    <tr>
                                        <td><a${language.id}>${language.language}</a></td>
                                        <%--<td>${language.language.registrationDate}</td>--%>
                                        <td>
                                            <a methods="post" href="/languageDel?id=${language.id}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <div class="col-sm-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <strong>Tools</strong>
                </div>
                <div class="panel-body">
                    <p><a href="/languageAdd" class="btn btn-success">Add Language</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
