<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>






<div class="container">
    <header class="clearfix">
        <span>Blueprint <span class="bp-icon bp-icon-about" data-content="The Blueprints are a collection of basic and minimal website concepts, components, plugins and layouts with minimal style for easy adaption and usage, or simply for inspiration."></span></span>
        <h1>View Mode Switch</h1>
    </header>
    <div class="main">
        <div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">
            <div class="cbp-vm-options">
                <a href="#" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected" data-view="cbp-vm-view-grid">Grid View</a>
                <a href="#" class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list">List View</a>
            </div>
            <ul>
                <c:forEach var="person" items="${persons}">
                <li>
                    <a class="cbp-vm-image" >  <c:choose>
                        <c:when test="${person.avatarURL == null}">
                            <img class="cbp-vm-image" alt="Responsive image"
                                 src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                        </c:when>
                        <c:otherwise>
                            <img class="cbp-vm-image" alt="Responsive image"
                                 src="${person.avatarURL}">
                        </c:otherwise>
                    </c:choose> </a>
                    <h3 class="cbp-vm-title">${person.firstName}</h3>
                    <div class="cbp-vm-price">${person.lastName}</div>
                    <div class="cbp-vm-details">${person.middleName}</div>
                    <%--<a class="cbp-vm-icon cbp-vm-add">Add to cart</a></li>--%>
                    </c:forEach>

    </div><!-- /main -->
</div><!-- /container -->




