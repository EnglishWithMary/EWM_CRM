<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap/css/bootstrap.css">

<div class="12u">
    <h3>TEACHERS</h3>

    <ul class="mainmenu">
        <li><a href="#" class="button alt">List view</a>
            <ul class="submenu">
                <li><a href="/leadsView" class="button alt">Leads</a></li>
                <li><a href="/studentsView" class="button alt">Students</a></li>
                <li><a href="/home" class="button alt">Persons</a></li>
            </ul>
        </li>
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
            <c:forEach var="teacher" items="${teachers}">
                <tr>
                    <td>${teacher.firstName}</td>
                    <td>${teacher.lastName}</td>
                    <td>${teacher.middleName}</td>
                    <td>${teacher.registrationDate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
        </div>
    </div>
</div>