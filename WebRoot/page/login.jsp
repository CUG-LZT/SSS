<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
    <base href="<%=basePath%>">
    
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">

</head>

<body style="background-color:#D9FFFF">
	<div class="htmleaf-container">
		<div class="wrapper">
			<div class="container">
				<h1>Welcome</h1>
				<form class="form" action="dologin.jsp" method="post">
					<input type="text" placeholder="Username" name="username">
					<input type="password" placeholder="Password" name="password">
					<button type="submit" id="login-button">Login</button>
				</form>
			</div>

			<ul class="bg-bubbles">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>

	<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
	<div
		style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';color:#000000">
		<h1>管理系统</h1>
	</div>
	<div
		style="position:absolute; bottom:0px;height:20px;width:100%;background-color:#DEFFAC;text-align:center">
		<span style="color:black">Powered by </span><span
			style="color:blue;font-family:SimHei"><img
			src="picture/logo.png" width="30" height="20" align="absmiddle" />湖北省电子科学研究所有限公司</span>
	</div>
</html>
