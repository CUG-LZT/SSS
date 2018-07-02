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
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

<script src="js/jquery-2.1.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/framejs/bootstrap.min.js"></script>
<script type="text/javascript" src="js/framejs/jquery-2.1.1.min.js"></script>

</head>

<body style="background-color:#DCDCDC";>
	<div style = "width:100%;height:170px;text-align: center">
		<h1 style="padding-top:90px"><font  color=blue >欢迎使用压差、温湿度监测系统</font></h1>
	</div>
	<div style = "width:100%;height:400px;background:url(picture/bg.png) no-repeat;">
		<div style = "width:450px;height:260px; position: absolute;left:50%; top:350px; margin-left:-225px;margin-top:-110px;background:url(picture/dl_bg.jpg) no-repeat;opacity:0.9;">
			<form action="dologin.jsp" method="post">
				<table style="pdding:0px;margin:0px;position: absolute;left:50%; top:350px; margin-left:-190px;margin-top:-325px;">
				    <tr>
				    	<td  style="width:380px;height:70px">
					       <div class="input-group"  style="width:100%;height:50px">
					            <span class="input-group-addon">用户名</span>
					            <input name="username" type="text" class="form-control" style="width:100%;height:50px;font-size:20px"  placeholder="username">
					        </div>
				        </td>
				    </tr>
				    <tr>
				       <td  style="width:380px;height:70px">
					       <div class="input-group"  style="width:100%;height:50px">
					            <span class="input-group-addon">密&nbsp;&nbsp;&nbsp;码</span>
					            <input name="password" type="password" class="form-control" style="width:100%;height:50px;font-size:20px" placeholder="password">
					        </div>
				        </td>
				    </tr>
				    <tr >
				        <td colspan="2"  style="width:380px;height:50px;padding-top:10px"><button type="submit" id="login-button" class="btn btn-primary" style="font-size:20px;width:100%;height:50px">登录</button></td>
				        
				    </tr>
				</table>
			</form>
		</div>
	</div>
	<div style = "width:100%;height:170px;">
		
	</div>

<div style="position:absolute; bottom:0px;height:20px;width:100%;background-color:#D9FFFF;text-align:center"><span style="color:black">Powered by </span><span style="color:blue;font-family:SimHei"><img
			src="picture/logo.png" width="30" height="20" align="absmiddle" />湖北省电子科学研究所有限公司</span></div>
</body>
</html>
