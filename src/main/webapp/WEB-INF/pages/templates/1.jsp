<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Enjoy your English with Mary! :)</h1>
<p>English with Mary is your new way to improve your skills!!!
    <style>



    </style>

    <link rel="stylesheet" type="text/css" href="/resources/assets/css/bootstrap/css/bootstrap.css">




    <%--<link rel="shortcut icon" href="../favicon.ico">--%>
    <%--<link rel="stylesheet" type="text/css" href="css/default.css" />--%>
    <%--<link rel="stylesheet" type="text/css" href="css/component.css" />--%>
    <%--<script src="js/modernizr.custom.js"></script>--%>

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
        </div >
    </div>

</div>





<%--<div class="container">--%>
    <%--<header class="clearfix">--%>
        <%--<span>Blueprint <span class="bp-icon bp-icon-about" data-content="The Blueprints are a collection of basic and minimal website concepts, components, plugins and layouts with minimal style for easy adaption and usage, or simply for inspiration."></span></span>--%>
        <%--<h1>View Mode Switch</h1>--%>
    <%--</header>--%>
    <%--<div class="main">--%>
        <%--<div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">--%>
            <%--<div class="cbp-vm-options">--%>
                <%--<a href="#" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected" data-view="cbp-vm-view-grid">Grid View</a>--%>
                <%--<a href="#" class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list">List View</a>--%>
            <%--</div>--%>








            <%--<ul>--%>
                <%--<li>--%>
                    <%--<a class="cbp-vm-image" href="#"><img src="images/1.png"></a>--%>
                    <%--<h3 class="cbp-vm-title">Silver beet</h3>--%>
                    <%--<div class="cbp-vm-price">$19.90</div>--%>
                    <%--<div class="cbp-vm-details">--%>
                        <%--Silver beet shallot wakame tomatillo salsify mung bean beetroot groundnut.--%>
                    <%--</div>--%>
                    <%--<a class="cbp-vm-icon cbp-vm-add" href="#">Add to cart</a>--%>
                <%--</li>--%>

                <%--<li>--%>
                    <%--<a class="cbp-vm-image" href="#"><img src="images/2.png"></a>--%>
                    <%--<h3 class="cbp-vm-title">Yarrow leek</h3>--%>
                    <%--<div class="cbp-vm-price">$22.50</div>--%>
                    <%--<div class="cbp-vm-details">--%>
                        <%--Yarrow leek cabbage amaranth onion salsify caulie kale desert raisin prairie turnip garlic.--%>
                    <%--</div>--%>
                    <%--<a class="cbp-vm-icon cbp-vm-add" href="#">Add to cart</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</div>--%>
    <%--</div><!-- /main -->--%>
<%--</div><!-- /container -->--%>
<%--<script src="js/classie.js"></script>--%>
<%--<script src="js/cbpViewModeSwitch.js"></script>--%>