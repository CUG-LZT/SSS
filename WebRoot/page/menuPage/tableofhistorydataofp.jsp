<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>压差数据统计</title>

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
<script type="text/javascript" src="../../js/myjs/tableofhistorydataofp.js"></script>

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
	<h2>压差数据统计
	</h2>
	<!-- <div class="demo-info" style="margin-bottom:10px">
		<div class="demo-tip icon-tip">&nbsp;</div>
		<div>温馨提示：起始时间</div>
	</div> -->

	<table id="dg" class="easyui-datagrid" style="width:950px;height:410px"
		url="http://172.16.10.165:8080/sss/servlet/Tableofhistorydataofp"
		title="压差统计" 
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
				<th field="p1" width="60" align="center">P1</th>
				<th field="p2" width="60" align="center">P2</th>
				<th field="p3" width="60" align="center">P3</th>
				<th field="p4" width="60" align="center">P4</th>
				<th field="p5" width="60" align="center">P5</th>
				<th field="p6" width="60" align="center">P6</th>
				<th field="p7" width="60" align="center">P7</th>
				<th field="p8" width="60" align="center">P8</th>
				<th field="p9" width="60" align="center">P9</th>
				<th field="p10" width="60" align="center">P10</th>
				<th field="p11" width="60" align="center">P11</th>
				<th field="p12" width="60" align="center">P12</th>
				<th field="p13" width="60" align="center">P13</th>
				<th field="p14" width="60" align="center">P14</th>
				<th field="p15" width="60" align="center">P15</th>
				<th field="p16" width="60" align="center">P16</th>
				<th field="p17" width="60" align="center">P17</th>
				<th field="p18" width="60" align="center">P18</th>
				<th field="p19" width="60" align="center">P19</th>
				<th field="p20" width="60" align="center">P20</th>
				<th field="p21" width="60" align="center">P21</th>
				<th field="p22" width="60" align="center">P22</th>
				<th field="p23" width="60" align="center">P23</th>
				<th field="p24" width="60" align="center">P24</th>
				<th field="p25" width="60" align="center">P25</th>
				<th field="p26" width="60" align="center">P26</th>
				<th field="p27" width="60" align="center">P27</th>
				<th field="p28" width="60" align="center">P28</th>
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
