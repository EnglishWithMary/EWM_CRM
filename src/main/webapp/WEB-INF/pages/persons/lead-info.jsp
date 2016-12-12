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
                                    <p><strong>First Name: </strong>Matilda</p>
                                    <p><strong>Last Name: </strong>Smith</p>
                                    <p><strong>Middle Name: </strong>Fergus'es daughter</p>
                                    <p><strong>Phone: </strong>+38(055)444-33-99</p>
                                    <p><strong>email: </strong>matilda@goo.com</p>
                                    <p><strong>web : </strong><a href="">vk.com/matilda</a></p>
                                    <p><strong>Date of Birth: </strong>Jul 17, 1991</p>
                                    <p><strong>Comment: </strong>Wants to enroll into C2 classes</p>
                                    <p><strong>Referral: </strong>Some info</p>
                                    <p><strong>Groups he wants to try: </strong>Group Name?</p>
                                    <p><strong>Language: </strong>English</p>
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

