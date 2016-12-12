<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap/css/bootstrap.css">

<div class="12u">
    <h3>STUDENTS</h3>

    <ul class="mainmenu">
        <li><a href="#" class="button alt">List view</a>
            <ul class="submenu">
                <li><a href="/leadsView" class="button alt">Leads</a></li>
                <li><a href="/teachersView" class="button alt">Teachers</a></li>
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
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Middle name</th>
                        <td>Registration Date</td>
                    </tr>
                    </thead>
                    <tbod>
                        <c:forEach var="student" items="${students}">
                            <tr>
                                <td>${student.person.firstName}</td>
                                <td>${student.person.lastName}</td>
                                <td>${student.person.middleName}</td>
                                <td>${student.person.registrationDate}</td>
                            </tr>
                        </c:forEach>
                    </tbod>
                </table>
            </div>
        </div >
    </div>
</div>