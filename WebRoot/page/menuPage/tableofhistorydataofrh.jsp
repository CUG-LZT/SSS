<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>湿度数据统计</title>

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
<script type="text/javascript" src="../../js/myjs/tableofhistorydataofrh.js"></script>

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

<body onload="init()" style="background-color:#FFFFF4">
	<h2>湿度数据统计
	</h2>
	<!-- <div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		<div>温馨提示：起始时间</div>
	</div> -->

	<table id="dg" class="easyui-datagrid" style="width:950px;height:410px"
		url="http://172.16.10.165:8080/sss/servlet/Tableofhistorydataofrh"
		title="湿度统计" 
		iconCls="icon-search" 
		toolbar="#tb" 
		rownumbers="true"
		pagination="true" 
		singleSelect="true" 
		fitColumns="false"
		showFooter="false"
		striped="true"
		>
		<thead>
			<tr>
				<th field="time" width="130" align="center">时间</th>
				<th field="rh1" width="60" align="center">RH1</th>
				<th field="rh2" width="60" align="center">RH2</th>
				<th field="rh3" width="60" align="center">RH3</th>
				<th field="rh4" width="60" align="center">RH4</th>
				<th field="rh5" width="60" align="center">RH5</th>
				<th field="rh6" width="60" align="center">RH6</th>
				<th field="rh7" width="60" align="center">RH7</th>
				<th field="rh8" width="60" align="center">RH8</th>
				<th field="rh9" width="60" align="center">RH9</th>
				<th field="rh10" width="60" align="center">RH10</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:3px">
		起始时间： <input id="start_timeInput" class="easyui-datetimebox" style="width:160px"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		结束时间：<input id="end_timeInput" class="easyui-datetimebox" style="width:160px"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a id="queryBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">汇总</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a style="float:right" href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="CreateFormPage('打印测试', $('#dg'));">打印</a>
	</div>

</body>
</html>
