<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
                            <p>Name I.I.</p>
                        </div>
                    </div>

                    <%--Pipeline Position--%>
                    <div class="row">
                        <div class="col-md-12">
                            <h3>Pipeline position</h3>
                            <p>(In development)</p>
                            <div class="btn-group btn-group-vertical btn-group-sm">
                                <button class="btn btn-default" type="button"><h4>Level1(PASS)</h4></button>
                                <button class="btn btn-default" type="button"><h4>Level2(CUR)</h4></button>
                                <button class="btn btn-default" type="button">Level3</button>
                                <button class="btn btn-default" type="button">Level4</button>
                                <button class="btn btn-default" type="button">Level5</button>
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
                                    <p><strong>First Name: </strong>fName</p>
                                    <p><strong>Last Name: </strong>lName</p>
                                    <p><strong>Middle Name: </strong>mName</p>
                                    <p><strong>Phone: </strong>phone</p>
                                    <p><strong>email: </strong>email</p>
                                    <p><strong>web : </strong><a href="">vk/fb/twitter</a></p>
                                    <p><strong>Date of Birth: </strong>date</p>
                                    <p><strong>Comment: </strong>Great Student</p>
                                    <p><strong>Groups: </strong><a href="">link to his group</a></p>
                                    <p><strong>Last Groups: </strong><a href="">link to other groups</a>
                                        (status) </p>
                                    <p><strong>Teachers: </strong><a href="">link to his teacher</a></p>
                                    <p><strong>Referral: </strong>some info</p>
                                    <p><strong>Student's contacts: </strong>Some Persons</p>
                                    <p><strong>Schedule: </strong>Tue(18:00-20:00), Thu(18:00-20:00), Sun(12:00-14:00)
                                        (common)
                                    </p>
                                    <p><strong>Something from his questionnaire: </strong>Additional info</p>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--Buttons--%>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="btn-group btn-group-md">
                                <a href="" class="btn btn-success" type="button">Become Graduate</a>
                                <a href="" class="btn btn-danger" type="button">Delete Student</a>
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
                                    <strong>Activities</strong>
                                </div>
                                <div class="panel-body">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Activity</th>
                                            <th>Edit</th>
                                            <th>Delete</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>1</td>
                                            <td>Activity1</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        <tr class="active">
                                            <td>1</td>
                                            <td>Activity2</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        <tr class="success">
                                            <td>2</td>
                                            <td>Activity3</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        <tr class="warning">
                                            <td>4</td>
                                            <td>Activity4</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        <tr class="danger">
                                            <td>5</td>
                                            <td>Activity5</td>
                                            <td>edit</td>
                                            <td>delete</td>
                                        </tr>
                                        </tbody>
                                    </table>
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
                </div>
            </div>
        </div>
    </div>
</div>

