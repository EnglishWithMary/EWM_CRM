<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Enjoy your English with Mary! :)</h1>
<p>English with Mary is your new way to improve your skills!!!
    <style>
    </style>

    <link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap/css/bootstrap.css">

<div class="12u">
    <h3>List persons</h3>

    <ul class="mainmenu">
        <li><a href="#" class="button alt">List view</a>
            <ul class="submenu">
                <li><a href="/leadsView" class="button alt">Leads</a></li>
                <li><a href="/teachersView" class="button alt">Teachers</a></li>
                <li><a href="/studentsView" class="button alt">Students</a></li>
            </ul>
        </li>
    </ul>
    <%--<div class="main">--%>
        <%--<div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-list">--%>
            <%--<div class="cbp-vm-options">--%>
                <%--<a class="cbp-vm-icon cbp-vm-grid" href="#" data-view="cbp-vm-view-grid">Grid View</a>--%>
                <%--<a class="cbp-vm-icon cbp-vm-list cbp-vm-selected" href="#" data-view="cbp-vm-view-list">List View</a>--%>
            <%--</div>--%>
            <%--<div class="table-wrapper">--%>
                <table class="alt">
                    <thead>
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Middle name</th>
                        <th>Role</th>
                    </tr>
                    </thead>
                    <tbod>
                        <c:forEach var="person" items="${persons}">
                            <tr>
                                <td>${person.firstName}</td>
                                <td>${person.lastName}</td>
                                <td>${person.middleName}</td>
                                <td>${person.role}</td>

                            </tr>
                        </c:forEach>
                    </tbod>
                </table>
            </div>
        <%--</div >--%>
    <%--</div>--%>

<%--</div>--%>