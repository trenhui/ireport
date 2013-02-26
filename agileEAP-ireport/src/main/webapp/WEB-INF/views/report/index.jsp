<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>智服报表</title>
<link rel="stylesheet"
	href="${ctx}/scripts/jsTree/themes/default/style.css">
<script type="text/javascript"
	src="${ctx}/scripts/jsTree/jquery.jstree.js"></script>
<script type="text/javascript">
	$(function() {
		$("#navTree2").jstree({
			"json_data" : {
				"data" : [ {
					"data" : "A node",
					"metadata" : {
						id : 23
					},
					"children" : [ "Child 1", "A Child 2" ]
				}, {
					"attr" : {
						"id" : "li.node.id1"
					},
					"data" : {
						"title" : "Long format demo",
						"attr" : {
							"href" : "#"
						}
					}
				} ]
			},
			"plugins" : [ "themes", "json_data", "ui" ]
		}).bind("select_node.jstree", function(e, data) {
			alert(data.rslt.obj.data("id"));
		});

		$("#navTree")
				.jstree(
						{
							"json_data" : {
								"data" : [ {
									"data" : "智能报表",
									"state" : "opened"
								}, {
									"attr" : {
										"id" : "ireport_node"
									}
								} ],
								"ajax" : {
									"url" : "http://www.jstree.com/static/v.1.0pre/_docs/_json_data.json"
								}
							},
							"plugins" : [ "themes", "json_data" ]
						});
	});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				报表树
				<div id="navTree"></div>
				<!--Sidebar content-->
			</div>
			<div class="span10">
				<!--Body content-->
				报表目录
				<div id="navTree2"></div>
			</div>
		</div>
	</div>

</body>
</html>