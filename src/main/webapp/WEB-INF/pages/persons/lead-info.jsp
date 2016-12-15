<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-2">
                    <div class="row">
                        <div class="col-md-12">
                            <img  class="img-size-sm" alt="Student Name"
                                  src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Full Name</h4>
                            <p>Smith M.F.</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h3>Pipeline position</h3>
                            <p>(In development)</p>
                            <div class="btn-group btn-group-vertical btn-group-sm">
                                <button class="btn btn-default" type="button"><h4>Phase1(PASS)</h4></button>
                                <button class="btn btn-default" type="button"><h4>Phase2(CUR)</h4></button>
                                <button class="btn btn-default" type="button">Phase3</button>
                                <button class="btn btn-default" type="button">Phase4</button>
                                <button class="btn btn-default" type="button">Phase5</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Information About Lead</strong>
                                </div>
                                <div class="panel-body">
                                    <p><strong>First Name: </strong><input type="text" value="${lead.person.firstName}"></p>
                                    <p><strong>Last Name: </strong><input type="text" value="${lead.person.lastName}"></p>
                                    <p><strong>Middle Name: </strong><input type="text" value="${lead.person.middleName}"></p>
                                    <p><strong>Phone: </strong></p>
                                    <p><strong>email: </strong><input type="text" value="${lead.person.email.email}"></p>
                                    <p><strong>web : </strong><a href=""></a></p>
                                    <p><strong>Date of Birth: </strong>
                                        <fmt:formatDate pattern="yyyy-MM-dd'T'HH:mm:ss.SSS" value="${lead.person.birthdayDate}" var="birth"/>
                                        <input type="datetime-local" value= "${birth}" />
                                    </p>
                                    <p><strong>Comment: </strong><input type="text" value="${lead.person.comments}"></p>
                                    <p><strong>Referral: </strong>Some info</p>
                                    <p><strong>Groups he wants to try: </strong>Group Name?</p>
                                    <p><strong>Language: </strong>English</p>

                                    <p><strong>State: </strong><input type="text" value="${lead.person.state.state}"></p>
                                    <p><strong>Last modified: </strong>${lead.person.modifyDate}</p>
                                    <p><strong>Registration date: </strong>${lead.person.registrationDate}</p>
                                    <p><strong>Organization: </strong><input type="text" value="${lead.person.organization}"></p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="btn-group btn-group-md">
                                <a href="" class="btn btn-success" type="button">Enroll as a Student</a>
                                <a href="" class="btn btn-danger" type="button">Delete Lead</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>The UFO is here</strong>
                                </div>
                                <div class="panel-body">
                                    Small kitten sleeps here
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
