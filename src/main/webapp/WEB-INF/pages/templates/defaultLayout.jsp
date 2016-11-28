<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="resources"/>

</head>
<body class="subpage">
<header id="header">
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="authentification"/>
</header>
<security:authorize access="isAuthenticated()">
    <nav id="menu">
        <tiles:insertAttribute name="menu"/>
    </nav>
</security:authorize>
<section id="main" class="wrapper">
    <div class="inner">
        <section id="banner">
            <div class="content">
                <tiles:insertAttribute name="body"/>
            </div>
        </section>
    </div>
</section>
<tiles:insertAttribute name="footer"/>
<tiles:insertAttribute name="scripts"/>
<tiles:insertAttribute name="formValidationScripts"/>
</body>
</html>