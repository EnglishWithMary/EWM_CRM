<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <tiles:insertAttribute name="resources"/>
    <tiles:insertAttribute name="additionalResources"/>
</head>
<%--<body class="subpage">--%>
<body>
<%--<div id="wrapper">--%>
<%--<div class="container-fluid">--%>
    <tiles:insertAttribute name="header"/>
<%--</div>--%>
<div class="container-fluid">
    <tiles:insertAttribute name="body"/>
</div>
<%--</div>--%>
<tiles:insertAttribute name="scripts"/>
<tiles:insertAttribute name="additionalScripts"/>
<tiles:insertAttribute name="formValidationScripts"/>
</body>
</html>