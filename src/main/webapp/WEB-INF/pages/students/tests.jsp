<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-sm-8">
        <div class="panel panel-default">

            <div class="panel-heading">
                <strong>Tests</strong>
            </div>

            <div class="panel-body">

                <div class="row">
                    <div class="col-sm-12">
                        <table class="table table-striped table-bordered">
                            <thead>
                            <tr>
                                <th>Student</th>
                                <th>Test</th>
                                <th>Grammar</th>
                                <th>Speaking</th>
                                <th>Listening</th>
                                <th>Reading</th>
                                <th>Vocabulary</th>
                                <th>Pronunciation</th>
                                <th>Writing</th>
                                <th>Fluency</th>
                                <th>Spelling</th>
                                <th>Edit</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="level" items="${levels}">
                                <tr>
                                    <td>
                                        <a href="/students/info?student_id=${level.student.id}">
                                                ${level.student.person.firstName}
                                                ${level.student.person.middleName}
                                                ${level.student.person.lastName}
                                        </a>
                                    </td>
                                    <td>${level.testType}</td>
                                    <td>${level.grammar}</td>
                                    <td>${level.speaking}</td>
                                    <td>${level.listening}</td>
                                    <td>${level.reading}</td>
                                    <td>${level.vocabulary}</td>
                                    <td>${level.pronunciation}</td>
                                    <td>${level.writing}</td>
                                    <td>${level.fluency}</td>
                                    <td>${level.spelling}</td>
                                    <td>
                                        <%--<button class="btn btn-default" href="#" role="button">--%>
                                            <%--Edit--%>
                                        <%--</button>--%>
                                        <form method="post" action="/students/${level.student.id}/add-testing-result" class="btn-xs">
                                            <input type="hidden" name="levelId" value="${level.id}">
                                            <button type="submit" class="btn btn-default btn-xs">
                                                Edit
                                            </button>
                                        </form>
                                        <%--<button type="button" class="bnt btn-default bnt-sm">--%>
                                            <%--Edit--%>
                                            <%--<a href="/student/info?student_id=${level.student.id}">--%>
                                                    <%--${level.student.person.firstName}--%>
                                                    <%--${level.student.person.middleName}--%>
                                                    <%--${level.student.person.lastName}--%>
                                            <%--</a>--%>
                                            <%--</button>--%>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <%--<div class="row">--%>
                <%--<div class="col-sm-2 col-sm-offset-5">--%>
                <%--<c:if test="${pages > 1}">--%>
                <%--<ul class="pagination">--%>
                <%--<c:forEach var="page" begin="1" end="${pages}">--%>
                <%--<li class="${(page eq param.page) or ((param.page eq null) and (page eq 1))? 'active' : ''}">--%>
                <%--<a href="/students?page=${page}&flagSorted=${flagSorted}">--%>
                <%--${page}--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--</c:forEach>--%>
                <%--</ul>--%>
                <%--</c:if>--%>
                <%--</div>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Tools</strong>
            </div>
            <div class="panel-body">
                <p><a href="" class="btn btn-success">Nothing</a></p>
            </div>
        </div>
    </div>
</div>