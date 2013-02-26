<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>登录页</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

<link type="image/x-icon" href="${ctx}/content/images/favicon.ico"
	rel="shortcut icon">

<link href="${ctx}/content/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${ctx}/content/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link href="${ctx}/content/themes/default/site.css" rel="stylesheet">

<script type="text/javascript" src="${ctx}/scripts/jquery.min.js"></script>
<script type="text/javascript"
	src="${ctx}/content/bootstrap/js/bootstrap.min.js"></script>

</head>

<body>
	<h3>用户登陆</h3>
	<form id="loginForm" action="/ireport/login" method="post"
		class="form-horizontal">
		<%
			String error = (String) request
					.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
			if (error != null) {
		%>
		<div class="alert alert-error input-medium controls">
			<button class="close" data-dismiss="alert">×</button>
			登录失败，请重试.
		</div>
		<%
			}
		%>
		<div class="control-group">
			<label for="username" class="control-label">名称:</label>
			<div class="controls">
				<input type="text" id="username" name="username"
					class="input-medium required" />
			</div>
		</div>
		<div class="control-group">
			<label for="password" class="control-label">密码:</label>
			<div class="controls">
				<input type="password" id="password" name="password"
					class="input-medium required" />
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
				<label class="checkbox" for="rememberMe"><input
					type="checkbox" id="rememberMe" name="rememberMe" /> 记住我</label> <input
					id="submit_btn" class="btn btn-primary" type="submit" value="登录" />
				<a class="btn" href="/ireport/register">注册</a> <span
					class="help-block">(管理员: <b>admin/suntek</b>, 普通用户: <b>suntek/suntek</b>)
				</span>
			</div>
		</div>
	</form>
</body>
</html>
