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
<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
</head>

<body style="background-color:#DCDCDC";>

	<div style = "width:100%;height:400px;background:url(picture/bg.png) no-repeat  ;">
		
	</div>
	<div style = "width:100%;height:340px;">
		<div style = "border:solid red 1px;width:450px;height:260px; position: absolute;left:50%; top:350px; margin-left:-225px; ">
			 <div class="container">
				<form class="form" action="dologin.jsp" method="post">
					<input type="text" placeholder="Username" name="username">
					<input type="password" placeholder="Password" name="password">
					<button type="submit" id="login-button">登录</button>
				</form>
			</div> 
			
			<table border="1">
			    <tr>
			        <td>row 1, cell 1</td>
			        <td>row 1, cell 2</td>
			    </tr>
			    <tr>
			        <td>row 2, cell 1</td>
			        <td>row 2, cell 2</td>
			    </tr>
			</table>

		</div>
	</div>

<div style="position:absolute; bottom:0px;height:20px;width:100%;background-color:#D9FFFF;text-align:center"><span style="color:black">Powered by </span><span style="color:blue;font-family:SimHei"><img
			src="picture/logo.png" width="30" height="20" align="absmiddle" />湖北省电子科学研究所有限公司</span></div>
</body>
</html>
