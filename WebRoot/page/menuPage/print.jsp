<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>数据打印</title>
<style type="text/css">
body {
	background: white;
	margin: 0px;
	padding: 0px;
	font-size: 13px;
	text-align: left;
}

.pb {
	font-size: 13px;
	border-collapse: collapse;
}

.pb th {
	font-weight: bold;
	text-align: center;
	border: 1px solid #333333;
	padding: 2px;
}

.pb td {
	border: 1px solid #333333;
	padding: 2px;
}
　　
</style>
</head>
<body>
	<script type="text/javascript">
		document.write(sessionStorage.getItem("sent"));
		window.print();
		 sessionStorage.clear();
	</script>
</body>
</html>