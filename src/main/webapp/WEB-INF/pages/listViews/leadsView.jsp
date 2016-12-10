<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap/css/bootstrap.css">


<div class="12u">
    <h3>LEADS</h3>

    <ul class="mainmenu">
        <li><a href="/home" class="button alt">Back to home</a></li>
    </ul>

    <div class="main">
        <div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-list">
            <div class="cbp-vm-options">
                <a class="cbp-vm-icon cbp-vm-grid" href="#" data-view="cbp-vm-view-grid">Grid View</a>
                <a class="cbp-vm-icon cbp-vm-list cbp-vm-selected" href="#" data-view="cbp-vm-view-list">List View</a>
            </div>
            <div class="table-wrapper">
                <table class="alt">
                    <thead>
                    <tr>
                        <td>First name</td>
                        <td>Last name</td>
                        <td>Middle name</td>
                        <td>Registration Date</td>
                    </tr>
                    </thead>
                    <c:forEach var="lead" items="${leads}">
                        <tr>
                            <td>${lead.person.firstName}</td>
                            <td>${lead.person.lastName}</td>
                            <td>${lead.person.middleName}</td>
                            <td>${lead.person.registrationDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>