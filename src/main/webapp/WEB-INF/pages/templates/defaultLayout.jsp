<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <title>Hello world</title>

    <tiles:insertAttribute name="resources" />
  <%--<link href="${pageContext.request.contextPath}/resources/assets/css/all.css" rel="stylesheet" type="text/css" />--%>
</head>
<body>
    <header id="header">
        <tiles:insertAttribute name="header"/>

        <nav class="right">
        <tiles:insertAttribute name="authentification"/>
        </nav>
    </header>
    <nav id="menu">
        <tiles:insertAttribute name="menu"/>
    </nav>
    <section id="banner">
        <div class="content">
            <tiles:insertAttribute name="body"/>
        </div>
    </section>
    <footer id="footer">
        <tiles:insertAttribute name="footer"/>
    </footer>
    <tiles:insertAttribute name="scripts"/>
</body>
</html>