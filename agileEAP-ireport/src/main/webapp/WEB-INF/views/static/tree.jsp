<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>智服报表</title>
<link rel="stylesheet" href="../scripts/jsTree/themes/default/style.css">
<script type="text/javascript" src="../scripts/jquery.min.js"></script>
<script type="text/javascript" src="../scripts/jsTree/jquery.jstree.js"></script>
<style type="text/css" id="jstree-stylesheet">
.jstree ul,.jstree li {
	display: block;
	margin: 0 0 0 0;
	padding: 0 0 0 0;
	list-style-type: none;
}

.jstree li {
	display: block;
	min-height: 18px;
	line-height: 18px;
	white-space: nowrap;
	margin-left: 18px;
	min-width: 18px;
}

.jstree-rtl li {
	margin-left: 0;
	margin-right: 18px;
}

.jstree>ul>li {
	margin-left: 0px;
}

.jstree-rtl>ul>li {
	margin-right: 0px;
}

.jstree ins {
	display: inline-block;
	text-decoration: none;
	width: 18px;
	height: 18px;
	margin: 0 0 0 0;
	padding: 0;
}

.jstree a {
	display: inline-block;
	line-height: 16px;
	height: 16px;
	color: black;
	white-space: nowrap;
	text-decoration: none;
	padding: 1px 2px;
	margin: 0;
}

.jstree a:focus {
	outline: none;
}

.jstree a>ins {
	height: 16px;
	width: 16px;
}

.jstree a>.jstree-icon {
	margin-right: 3px;
}

.jstree-rtl a>.jstree-icon {
	margin-left: 3px;
	margin-right: 0;
}

li.jstree-open>ul {
	display: block;
}

li.jstree-closed>ul {
	display: none;
}

#vakata-dragged ins {
	display: block;
	text-decoration: none;
	width: 16px;
	height: 16px;
	margin: 0 0 0 0;
	padding: 0;
	position: absolute;
	top: 4px;
	left: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	-webkit-border-radius: 4px;
}

#vakata-dragged .jstree-ok {
	background: green;
}

#vakata-dragged .jstree-invalid {
	background: red;
}

#jstree-marker {
	padding: 0;
	margin: 0;
	font-size: 12px;
	overflow: hidden;
	height: 12px;
	width: 8px;
	position: absolute;
	top: -30px;
	z-index: 10001;
	background-repeat: no-repeat;
	display: none;
	background-color: transparent;
	text-shadow: 1px 1px 1px white;
	color: black;
	line-height: 10px;
}

#jstree-marker-line {
	padding: 0;
	margin: 0;
	line-height: 0%;
	font-size: 1px;
	overflow: hidden;
	height: 1px;
	width: 100px;
	position: absolute;
	top: -30px;
	z-index: 10000;
	background-repeat: no-repeat;
	display: none;
	background-color: #456c43;
	cursor: pointer;
	border: 1px solid #eeeeee;
	border-left: 0;
	-moz-box-shadow: 0px 0px 2px #666;
	-webkit-box-shadow: 0px 0px 2px #666;
	box-shadow: 0px 0px 2px #666;
	-moz-border-radius: 1px;
	border-radius: 1px;
	-webkit-border-radius: 1px;
}

.jstree .jstree-real-checkbox {
	display: none;
}

.jstree-themeroller .ui-icon {
	overflow: visible;
}

.jstree-themeroller a {
	padding: 0 2px;
}

.jstree-themeroller .jstree-no-icon {
	display: none;
}

.jstree .jstree-wholerow-real {
	position: relative;
	z-index: 1;
}

.jstree .jstree-wholerow-real li {
	cursor: pointer;
}

.jstree .jstree-wholerow-real a {
	border-left-color: transparent !important;
	border-right-color: transparent !important;
}

.jstree .jstree-wholerow {
	position: relative;
	z-index: 0;
	height: 0;
}

.jstree .jstree-wholerow ul,.jstree .jstree-wholerow li {
	width: 100%;
}

.jstree .jstree-wholerow,.jstree .jstree-wholerow ul,.jstree .jstree-wholerow li,.jstree .jstree-wholerow a
	{
	margin: 0 !important;
	padding: 0 !important;
}

.jstree .jstree-wholerow,.jstree .jstree-wholerow ul,.jstree .jstree-wholerow li
	{
	background: transparent !important;
}

.jstree .jstree-wholerow ins,.jstree .jstree-wholerow span,.jstree .jstree-wholerow input
	{
	display: none !important;
}

.jstree .jstree-wholerow a,.jstree .jstree-wholerow a:hover {
	text-indent: -9999px; ! important;
	width: 100%;
	padding: 0 !important;
	border-right-width: 0px !important;
	border-left-width: 0px !important;
}

.jstree .jstree-wholerow-span {
	position: absolute;
	left: 0;
	margin: 0px;
	padding: 0;
	height: 18px;
	border-width: 0;
	padding: 0;
	z-index: 0;
}
</style>
<script type="text/javascript">
	$(function() {
		var options = {
			Name : "demo1"
		};
		var plugins = [ "themes", "json_data", "checkbox", "sort", "ui" ];
		$.ajaxSetup({
			cache : false
		});
		$("#" + options.Name).jstree({
			"plugins" : plugins,
			"themes" : {
				"theme" : "default",
				"url" : "../scripts/jsTree/themes/default/style.css",
				"dots" : true,
				"icons" : false
			},
			"lang" : {
				"loading" : "目录加载中……"
			},
			"json_data" : {
				//"ajax": {
				//    "url": "/FormDesigner/Home/GetTreeInfo",
				//    "data": { "DataSource": options.DataSource, "NodeImg": options.DefaultValue }// treeContent.dataSource }
				//},
				"data" : {
					"data" : "node_title",
					// omit `attr` if not needed; the `attr` object gets passed to the jQuery `attr` function
					"attr" : {
						"id" : "node_identificator",
						"some-other-attribute" : "attribute_value"
					},
					// `state` and `children` are only used for NON-leaf nodes
					"state" : "closed"//, // or "open", defaults to "closed"
				//"children" : [ /* an array of child nodes objects */ ]
				},

				"progressive_render" : true,
			},
			"checkbox" : {
			//"two_state": true
			}
		}).bind("open_node.jstree loaded.jstree", function(e, data) {
			if (ListItems.length > 0) {
				//document.oncontextmenu = function (e) { return false };
				//initJSTreeContextMenu(ListItems, options.Name);
			}
		});
		$("#" + options.Name).css("overflow", "auto");
		//$("#" + options.Name).wrap("<div class='wrap'></div>");
		//$("#" + options.Name).resizable({
		//   // alsoResize: "#" + options.Name,
		//    handles: "all"
		//});
		$(".ui-resizable-handle").css("display", "none");
	});
</script>
</head>
<body>
	报表目录
	<div id="demo1"
		class="demo jstree jstree-0 jstree-default jstree-focused"
		style="height: 398px;"></div>
	<!-- 	<div class="row-fluid">
		<div class="span2">
			报表树
			<div id="navTree"></div>
			Sidebar content
		</div>
		<div class="span10">
			Body content

		</div>
	</div> -->

</body>
</html>
