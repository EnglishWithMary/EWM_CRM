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
                            <img class="img-size-sm" alt="Teacher Jojo"
                                 src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h4>Full Name</h4>
                            <p>Strange J..</p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <h3>Language</h3>
                            <p>(In development)</p>
                            <h5>English</h5>
                            <h5>German</h5>
                            <h5>French</h5>
                            <h5>Italian</h5>
                        </div>
                    </div>
                </div>
                <div class="col-md-5">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <strong>Information About Teacher</strong>
                                </div>
                                <div class="panel-body">
                                    <p><strong>First Name: </strong>${teacher.person.firstName}</p>
                                    <p><strong>Last Name: </strong>${teacher.person.lastName}</p>
                                    <p><strong>Middle Name: </strong>${teacher.person.middleName}</p>
                                    <p><strong>Phone: </strong>null</p>
                                    <p><strong>email: </strong>${teacher.person.email.email}</p>
                                    <p><strong>web : </strong><a href="">null</a></p>
                                    <p><strong>Date of Birth: </strong>null</p>
                                    <p><strong>Comment: </strong>${teacher.person.comments}</p>
                                    <p><strong>Groups: </strong><a href="">null</a> </p>
                                    <p><strong>Languages: </strong>English, Italian(null, need add filed)</p>
                                    <p><strong>Referral: </strong>null</p>
                                    <p><strong>Color: </strong>Kinda racism(ahhhahah)</p>

                                    <p><strong>State: </strong>${teacher.person.state.state}</p>
                                    <p><strong>Last modified: </strong>${teacher.person.modifyDate}</p>
                                    <p><strong>Registration date: </strong>${teacher.person.registrationDate}</p>
                                    <p><strong>Organization: </strong>null</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="btn-group btn-group-md">
                                <button class="btn btn-danger" type="button">Delete Teacher</button>
                            </div>
                            Why not "fire teacher"?
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
                                    <!--Calendar    -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

