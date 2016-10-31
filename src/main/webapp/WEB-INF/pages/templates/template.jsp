<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Here is spring and jsp taglibs--%>

<tiles:insertAttribute name="libs"/>

<html>
<head>
    <%--Title from tiles--%>
    <title><tiles:getAsString name="title"/></title>

    <%--CSS, JS, Fonts--%>
    <tiles:insertAttribute name="resourses"/>
</head>

<body>

<header id="header">
    <nav class="left">
        <a href="#menu"><span>Menu</span></a>
    </nav>
    <a href="index.html" class="logo">Mary</a>
    <tiles:insertAttribute name="authentication"/>
</header>

<%--As it is named below--%>

<tiles:insertAttribute name="navbar"/>
<tiles:insertAttribute name="context"/>
<tiles:insertAttribute name="footer"/>
<tiles:insertAttribute name="scripts"/>

</body>
</html>
