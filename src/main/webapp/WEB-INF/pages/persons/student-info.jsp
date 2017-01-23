<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-2">

                    <%--Avatar Image--%>
                    <div class="row">
                        <div class="col-md-12">
                            <img alt="Student --Name--"
                                 src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg"
                                 class="img-size-sm">
                        </div>
                    </div>

                    <%--Student's name from request--%>
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Full Name</h4>
                            <p>${student.person.lastName}
                                ${fn:substring(student.person.firstName,0,1)}.
                                ${fn:substring(student.person.middleName,0,1)}.</p>
                        </div>
                    </div>

                    <%--Pipeline Position--%>
                    <div class="row">
                        <div class="col-md-12">
                            <h3>Pipeline position</h3>
                            <div class="btn-group btn-group-vertical btn-group-sm">

                                <c:forEach var="personCard" items="${personCardList}">
                                    <%--<c:set var="personCardId" value="${personCard.id}"/>--%>
                                    <%--<c:set var="currentCardId" value="${currentCard.id}"/>--%>

                                    <c:if test="${personCard.id==currentCard.id}">
                                        <button class="btn btn-default" type="button"><h4>${personCard.cardName}</h4>
                                        </button>
                                    </c:if>
                                    <c:if test="${personCard.id != currentCard.id}">
                                        <button class="btn btn-default" type="button">${personCard.cardName}</button>
                                    </c:if>
                                </c:forEach>

                            </div>
                        </div>
                    </div>

                </div>


                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Information About Student</strong>
                                </div>

                                <%--Information from request--%>
                                <div class="panel-body">
                                    <p><strong>First Name: </strong><input type="text"
                                                                           value="${student.person.firstName}"></p>
                                    <p><strong>Last Name: </strong><input type="text"
                                                                          value="${student.person.lastName}"></p>
                                    <p><strong>Middle Name: </strong><input type="text"
                                                                            value="${student.person.middleName}"></p>
                                    <p><strong>Phone: </strong><input type="text"></p>
                                    <p><strong>email: </strong><input type="text" value="${student.person.email.email}">
                                    </p>
                                    <p><strong>web : </strong><a href="">null</a></p>
                                    <p><strong>Date of Birth: </strong><input type="date" name="" id=""></p>
                                    <p><strong>Comment: </strong></p>
                                    <%--<input type="text" value="${student.person.comments}">--%>
                                    <p><textarea name="comments" form="comments"
                                                 cols="30">${student.person.comments}</textarea>
                                    <form id=comments method="post" modelAttribute="student.person"
                                          action="/students/UpdateComments">
                                        <input name="id" type=hidden value="${student.id}">
                                        <%--<input name="role" type=hidden value="4">--%>
                                        <security:authorize access="hasRole('ROLE_ADMIN')">
                                            <input type="submit" value="Submit comment"/>
                                        </security:authorize>
                                    </form>
                                    </p>

                                    <p><strong>State: </strong><input type="text" value="${student.person.state.state}">
                                    </p>
                                    <p><strong>Last modified: </strong>${student.person.modifyDate}</p>
                                    <p><strong>Registration date: </strong>${student.person.registrationDate}</p>
                                    <p><strong>Organization: </strong><input type="text"></p>

                                    <p><strong>Group: </strong><a
                                            href="/groups/info?group_id=${student.group.id}">${student.group.name}</a>
                                    </p>
                                    <p><strong>Last Groups: </strong><a href="">link to other groups</a>
                                        (status) </p>
                                    <p><strong>Teacher: </strong><a
                                            href="/teachers/info?teacher_id=${student.teacher.id}">${student.teacher.person.firstName}</a>
                                    </p>
                                    <p><strong>Referral: </strong><input type="text"></p>
                                    <p><strong>Student's contacts: </strong><input type="text"></p>
                                    <p><strong>Schedule: </strong><input type="text"></p>
                                    <p><strong>Something from his questionnaire: </strong><input type="text"></p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--Buttons--%>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="btn-group btn-group-md">
                                <a href="" class="btn btn-success" type="button">Become Graduate</a>
                                <security:authorize access="hasRole('ROLE_ADMIN')">
                                    <a href="/students/trash?id=${student.id}" class="btn btn-danger">Delete Student</a>
                                    <a href="/students/${student.id}/add-testing-result" class="btn btn-success"
                                       type="button">Set level</a>
                                </security:authorize>

                            </div>
                        </div>
                    </div>

                </div>


                <div class="col-md-5">

                    <%--Panel with Activities--%>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Last test results</strong>
                                </div>
                                <div class="panel-body">
                                    <p><strong>Date:</strong> <fmt:formatDate value="${level.checkpointDate}"
                                                                              type="date"></fmt:formatDate></p>
                                    <p><strong>Test:</strong> ${level.testType}</p>
                                    <p><strong>Grammar:</strong> ${level.grammar}</p>
                                    <p><strong>Speaking:</strong> ${level.speaking}</p>
                                    <p><strong>Listening:</strong> ${level.listening}</p>
                                    <p><strong>Reading:</strong> ${level.reading}</p>
                                    <p><strong>Vocabulary:</strong> ${level.vocabulary}</p>
                                    <p><strong>Pronunciation:</strong> ${level.pronunciation}</p>
                                    <p><strong>Writing:</strong> ${level.writing}</p>
                                    <p><strong>Fluency:</strong> ${level.fluency}</p>
                                    <p><strong>Spelling:</strong> ${level.spelling}</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--Panel with Payments--%>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Payments</strong>
                                </div>
                                <div class="panel-body">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>PayName</th>
                                            <th>ExpirationDate</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Payment1</td>
                                            <td>Oct-16-2017</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        <tr class="active">
                                            <td>2</td>
                                            <td>Payment2</td>
                                            <td>Oct-16-2017</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        <tr class="success">
                                            <td>3</td>
                                            <td>Payment3</td>
                                            <td>Oct-16-2017</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        <tr class="warning">
                                            <td>4</td>
                                            <td>Payment4</td>
                                            <td>Oct-16-2017</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        <tr class="danger">
                                            <td>5</td>
                                            <td>Payment5</td>
                                            <td>Oct-16-2017</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Calendar</strong>
                                </div>
                                <div class="panel-body">
                                    <div id="calendar"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

