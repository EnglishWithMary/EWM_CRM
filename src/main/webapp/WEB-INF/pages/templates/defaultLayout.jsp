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
<div id="wrapper">
    <tiles:insertAttribute name="header"/>
    <div class="container">
        <tiles:insertAttribute name="body"/>
    </div>
</div>
<tiles:insertAttribute name="scripts"/>
<tiles:insertAttribute name="formValidationScripts"/>
</body>
</html>