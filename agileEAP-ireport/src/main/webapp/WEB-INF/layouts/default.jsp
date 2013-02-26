<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title><sitemesh:title /></title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="${ctx}/content/images/favicon.ico"	rel="shortcut icon">
<link href="${ctx}/content/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/content/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="${ctx}/content/themes/default/site.css" rel="stylesheet">
<script type="text/javascript" src="${ctx}/scripts/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/content/bootstrap/js/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="${ctx}/scripts/angular/angular.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/angular/angular-strap.js"></script> --%>
<script type="text/javascript" src="${ctx}/scripts/util.js"></script>
<sitemesh:head />
</head>
<body>
	<div class="container">
		<%@ include file="/WEB-INF/layouts/header.jsp"%>
		<div id="content">
			<sitemesh:body />
		</div>
		<%@ include file="/WEB-INF/layouts/footer.jsp"%>
	</div>
</body>
</html>