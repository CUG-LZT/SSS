<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>My JSP 'lampcontrol.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../../js/myjs/controlamp.js"></script>
<style>
		.datagrid-row {  
		  height: 42px;  
		  text-align:center;  
		}
	
	</style>


  </head>
  <body style="margin:50px;">
  	<table id="tt" 
  			title="无影灯控制" 
  			class="easyui-datagrid" 
  			style="margin:50px;width:480px;height:550px"
  			url = 'http://172.16.10.165:8080/sss/servlet/Getdataoflamp'
  			toolbar = "#tb">
		<thead>
			<tr>
				<th field="ck" width="50" checkbox=true>ID</th>
				<th field="id" width="150" align="center">LID</th>
				<th field="number" width="150" align="center">手术室号</th>
				<th field="status" width="150" align="center">当前状态</th>
			</tr>
		</thead>
	</table>
	
 <div id="tb" style="padding:5px;padding-left:50px;background:#E1FFFF;border:1px solid #ccc">
        <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add"  onclick="lock()">锁定</a>
        <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add" style="margin-left:70px;"  onclick="unlk()">解除锁定</a>
        <a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-reload" style="margin-left:70px;" onclick="ajax()">刷新</a>
        
    </div>
</body>
</html>

