<%@ page language="java" contentType="text/html; charset=utf-8"
    %>
<!DOCTYPE HTML>
<html>
<head>
<title>用户管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="description" content="情况汇总">

<link rel="stylesheet" type="text/css" href="../../js/framejs/jquery-easyui-1.3.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../../js/framejs/jquery-easyui-1.3.2/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../js/framejs/jquery-easyui-1.3.2/demo/demo.css">
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/datagrid-detailview.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="../../js/myjs/user.js"></script>

<style type="text/css">
	.dv-table td{
		border:0;
	}
	.dv-label{
		font-weight:bold;
		color:#15428B;
		width:100px;
	}
</style>

</head>

<body onload="init()">
	<h2>用户管理
	</h2>
	<div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		<div>温馨提示：选择一个用户后点击删除用户，即可删除该用户</div>
	</div>
	<table id="dg" class="easyui-datagrid" style="width:655px;height:435px"
		url="http://172.16.10.165:8080/sss/servlet/UserList" title="用户管理" iconCls="icon-search" toolbar="#tb"
		rownumbers="false" pagination="false" singleSelect="true" fitColumns="false" showFooter="false" >
		<thead>
			<tr>
				<th field="id" width="150" align="center">编号</th>
				<th field="username" width="250" align="center">用户名</th>
				<th field="role" width="250" align="center">角色名称</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:3px;">
		<a id="queryBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="add()">添加用户</a>
		<a id="queryBtn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="removeUser()" style="position:relative;left:40px">删除用户</a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width:300px;height:200px;padding:10px 20px"; closed="true"
		buttons="#dlg-buttons">
		<div style="text-align: center;">
			<form id="ff" method="post">
	    		<table>
	    			<tr>
	    				<td>用&nbsp&nbsp户&nbsp&nbsp名：</td>
	    				<td><input id="username" class="easyui-validatebox" type="text" name="sheetname" data-options="required:true" value=""></input></td>
	    			</tr>
	    			<tr>
	    				<td>密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码：</td>
	    				<td><input id="password" class="easyui-validatebox" type="password" name="excelname" data-options="required:true" value=""></input></td>
	    			</tr>
	    			<tr>
	    				<td>确认密码：</td>
	    				<td><input id="repassword" class="easyui-validatebox" type="password" name="excelname" data-options="required:true" value=""></input></td>
	    			</tr>
	    			<tr>
	    				<td>角&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp色：</td>
	    				<td><input id="role" class="easyui-combobox" style="width:150px"
					url="../../data/user.json"
					valueField="id" textField="text"/></td>
	    			</tr>
	    		</table>
	 	   </form>
	    </div>
	</div>
	<div id="dlg-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
			onclick="addUser()">确定</a> 
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" 
			onclick="Cancel()">取消</a>
	</div>
	

</body>
</html>