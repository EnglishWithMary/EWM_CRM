<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <div class="row">
                <div class="col-md-2">
                    <div class="row">
                        <div class="col-md-12">
                            <img class="img-size-sm" alt="Manager John"
                                 src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Full Name</h4>
                            <p>Johnson J.O.</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h3>Some Information</h3>
                            <p>(In development)</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Information About Manager</strong>
                                </div>
                                <div class="panel-body">

                                    <p><strong>First Name: </strong><input type="text" value="${manager.person.firstName}"></p>
                                    <p><strong>Last Name: </strong><input type="text" value="${manager.person.lastName}"></p>
                                    <p><strong>Middle Name: </strong><input type="text" value="${manager.person.middleName}"></p>
                                    <p><strong>Phone: </strong><input type="text" value=""></p>
                                    <p><strong>email: </strong><input type="text" value="${manager.person.email.email}"></p>
                                    <p><strong>web : </strong><a href=""></a></p>
                                    <p><strong>Date of Birth: </strong><input type="date" value="${manager.person.birthdayDate}"></p>
                                    <p><strong>Comment: </strong><input type="text" value="${manager.person.comments}"></p>

                                    <p><strong>State: </strong><input type="text" value="${manager.person.state.state}"></p>
                                    <p><strong>Last modified: </strong>${manager.person.modifyDate}</p>
                                    <p><strong>Registration date: </strong>${manager.person.registrationDate}</p>
                                    <p><strong>Organization: </strong><input type="text"></p>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="btn-group btn-group-md">
                                <a href="" class="btn btn-default" type="button">Some buttons</a>
                                we can use groups
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Calendar</strong>
                                </div>
                                <div class="panel-body">
                                    <!--Calendar-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

