<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h1>Enjoy your English with Mary! :)</h1>
 <p>English with Mary is your new way to improve your skills!!!





                <div id="containerListPersons">
                    <div class="buttons">
                        <button class="grid">Grid View</button>
                        <button class="list">List View</button>
                    </div>
                    <ul class="list">
                        <c:forEach var="person" items="${persons}">
                        <li>

                               <span class="firstName">${person.firstName} </span>
                               <span class="lastName">${person.lastName} </span>

                            <c:choose>
                            <c:when test="${person.avatarURL == null}">
                                <img class="img-size-vsm" alt="Responsive image"
                                     src="${pageContext.request.contextPath}/resources/img/defaultAvatar.jpg">
                            </c:when>
                            <c:otherwise>
                                <img class="img-size-vsm" alt="Responsive image"
                                     src="${person.avatarURL}">
                            </c:otherwise>
                        </c:choose>
                        </li>

                        </c:forEach>

                    </ul>
                </div>

<%--<span class="firstName">--%>
 <%--<span class="lastName">--%>


                <%----%>
                        <%--<c:forEach var="person" items="${persons}">--%>
                            <%--<h3 class="cbp-vm-title">${person.firstName}</h3>--%>
                        <%--</c:forEach>--%>




