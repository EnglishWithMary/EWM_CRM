<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>

    <title><tiles:getAsString name="title"/></title>
    <tiles:insertAttribute name="resources"/>

</head>
<body class="subpage">
<div id="wrapper">
    <tiles:insertAttribute name="header"/>
    <div class="container-fluid">
        <tiles:insertAttribute name="body"/>
    </div>
</div>
<tiles:insertAttribute name="scripts"/>
<tiles:insertAttribute name="formValidationScripts"/>
</body>
</html>