<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>


<link rel="stylesheet"
	href="../bootstrap-cerulean-theme/bootstrap.min.css">
<link rel="stylesheet"
	href="../jquery-ui-1.11.4.custom/jquery-ui.theme.min.css">
<link rel="stylesheet"
	href="../jquery-ui-1.11.4.custom/jquery-ui.structure.min.css">
<script src="../jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
<script src="../jquery-ui-1.11.4.custom/jquery-ui.js"></script>
<script src="../jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
<script src="../angular/angular.js"></script>
<script src="../controller/UserController.js"></script>

<head>
<title></title>
</head>
<body>
	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />
</body>
</html>