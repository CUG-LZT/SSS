<%@ page import="java.sql.Timestamp"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String username = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");
	if (username == null && password == null) {
		response.sendRedirect("login.jsp");
	}
	Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	session.setAttribute("currentTime", currentTime);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>医院手术室监控管理系统</title>
<link rel="stylesheet" type="text/css" href="../css/default.css" />
<link rel="stylesheet" type="text/css" href="../css/ol.css" />
<link rel="stylesheet" type="text/css"
	href="../js/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../js/themes/icon.css" />
<style>
/*弹窗样式*/
.popup {
	position: absolute;
	background-color: #FFFFF4;
	-webkit-filter: drop-shadow(0 1px 4px rgba(0, 0, 0, 0.2));
	filter: drop-shadow(0 1px 4px rgba(0, 0, 0, 0.2));
	padding: 15px;
	border-radius: 10px;
	border: 1px solid #cccccc;
	bottom: 12px;
	left: -50px;
	min-width: 280px;
}

.popup:after,.popup:before {
	top: 100%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
}

.popup:after {
	border-top-color: white;
	border-width: 10px;
	left: 48px;
	margin-left: -10px;
}

.popup:before {
	border-top-color: #cccccc;
	border-width: 11px;
	left: 48px;
	margin-left: -11px;
}

.popup-closer {
	text-decoration: none;
	position: absolute;
	top: 2px;
	right: 8px;
}

.popup-closer:after {
	content: "✖";
}
</style>
<script type="text/javascript" src="../js/framejs/jquery-1.4.4.min.js"></script>
<script type="text/javascript"
	src="../js/framejs/jquery.easyui.min.1.2.2.js"></script>
<script type="text/javascript" src='../js/framejs/outlook2.js'></script>
<script type="text/javascript" src="../js/framejs/jquery.tempgauge.js"></script>
<script src="../js/framejs/raphael.2.1.0.min.js"></script>
<script src="../js/framejs/justgage.1.0.1.min.js"></script>
<script src="../js/framejs/ol.js"></script>

<script type="text/javascript">
	var _menus = {
		"menus" : [ 
		{
			"menuid" : "5",
			"isdisplay" : 2, //3表示最高权限 2是管理员 1是游客
			"icon" : "icon-sys",
			"menuname" : "报告单信息",
			"menus" : [ {
				"menuid" : "51",
				"isdisplay" :3,
				"menuname" : "未处理报告单  :  "+"<%=request.getSession().getAttribute("nodeal")%>  条",
				"icon" : "icon-log",
				"url" : "menuPage/reportofundeal.jsp"
			} ,{
				"menuid" : "52",
				"menuname" : "历史报告单",
				"isdisplay" :3,
				"icon" : "icon-log",
				"url" : "menuPage/reportofhistory.jsp"
			} ,{
				"menuid" : "53",
				"menuname" : "填写报告单(报警信息)",
				"isdisplay" :0,
				"icon" : "icon-log",
				"url" : "menuPage/alarminfo.jsp"
			} ]
		},{
			"menuid" : "1",
			"isdisplay" : 3,
			"icon" : "icon-sys",
			"menuname" : "超级管理员操作",
			"menus" : [ /* {
				"menuid" : "11",
				"menuname" : "无影灯控制","isdisplay" :3,
				"icon" : "icon-log",
				"url" : "menuPage/lampcontrol.html"
			}, */{
				"menuid" : "12",
				"menuname" : "报警灯控制","isdisplay" :3,
				"icon" : "icon-log",
				"url" : "menuPage/lampcontrol.jsp"
			}]
		}, {
			"menuid" : "2",
			"isdisplay" : 0,
			"icon" : "icon-sys",
			"menuname" : "实时曲线",
			"menus" : [ {
				"menuid" : "211",
				"menuname" : "温度实时曲线(t11~t15)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/temperatureofonetofive.jsp"
			} ,	{
				"menuid" : "212",
				"menuname" : "温度实时曲线(t16~t20)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/temperatureofsixtoten.jsp"
			} ,	{
				"menuid" : "221",
				"menuname" : "湿度实时曲线(rh11~15)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/rhofonetofive.jsp"
			},{
				"menuid" : "222",
				"menuname" : "湿度实时曲线(rh16~20)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/rhofsixtoten.jsp"
			},{
				"menuid" : "231",
				"menuname" : "压差实时曲线(p1~5)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/pof1to5.jsp"
			},
			{
				"menuid" : "232",
				"menuname" : "压差实时曲线(p6~10)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/pof6to10.jsp"
			},
			{
				"menuid" : "233",
				"menuname" : "压差实时曲线(p11~15)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/pof11to15.jsp"
			},
			{
				"menuid" : "234",
				"menuname" : "压差实时曲线(p16~20)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/pof16to20.jsp"
			},
			{
				"menuid" : "234",
				"menuname" : "压差实时曲线(p21~25)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/pof21to25.jsp"
			},
			{
				"menuid" : "236",
				"menuname" : "压差实时曲线(p26~28)","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/pof26to28.jsp"
			}]
		}, {
			"menuid" : "3",
			"isdisplay" : 0,
			"icon" : "icon-sys",
			"menuname" : "历史曲线",
			"menus" : [ {
				"menuid" : "31",
				"menuname" : "温度历史曲线","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/lineofhistorydataoft.jsp"
			} ,{
				"menuid" : "32",
				"menuname" : "湿度历史曲线","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/lineofhistorydataofrh.jsp"
			},{
				"menuid" : "33",
				"menuname" : "压差历史曲线","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/lineofhistorydataofp.jsp"
			} ]
		}, {
			"menuid" : "4",
			"isdisplay" : 0,
			"icon" : "icon-sys",
			"menuname" : "历史数据查询",
			"menus" : [ {
				"menuid" : "41",
				"menuname" : "压差","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/tableofhistorydataofp.jsp"
			}, {
				"menuid" : "42",
				"menuname" : "温度","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/tableofhistorydataoft.jsp"
			}, {
				"menuid" : "43",
				"menuname" : "湿度","isdisplay" :0,
				"icon" : "icon-nav",
				"url" : "menuPage/tableofhistorydataofrh.jsp"
			}  ]
		} ,{
			"menuid" : "6",
			"isdisplay" : 2,
			"icon" : "icon-sys",
			"menuname" : "配置信息",
			"menus" : [ {
				"menuid" : "61",
				"menuname" : "报警信息设置","isdisplay" :2,
				"icon" : "icon-log",
				"url" : "menuPage/standofdta.jsp"
			} ,{
				"menuid" : "62",
				"menuname" : "用户管理","isdisplay" :3,
				"icon" : "icon-log",
				"url" : "menuPage/userinfo.jsp"
			} ]
		}]
	};
	
	$(function() {
		$('#loginOut').click(function() {
			$.messager.confirm('系统提示', '您确定退出本次登录吗？', function(r) {
				if (r) {
					location.href = '/sss/login.jsp';
				}
			});
		});
	});
</script>

</head>
<body class="easyui-layout" style="overflow-y: hidden" scroll="no"
	style="background-color:#FFFFDF">

	<noscript>
		<div
			style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:#FFFFF4; text-align:center;">
			<img src="../images/noscript.gif" alt='noscript' />
		</div>
	</noscript>


	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 30px; background: url(images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%; line-height: 20px;color: #fff; font-family: Verdana, å¾®è½¯éé»,é»ä½">
		<span style="float:right; padding-right:20px;" class="head">| <a
			href="#" id="loginOut">安全退出</a>
		</span> 
		<span id="roleofuser" style="float:right; padding-right:20px;display:none" class="head">
			<%=request.getSession().getAttribute("role") %>
		</span>
		<span style="float:right; padding-right:20px;" class="head">|
			登录时间： <%=request.getSession().getAttribute("currentTime") %>
		</span> <span style="float:right; padding-right:20px;" class="head">| 身份：<%=request.getSession().getAttribute("roleofdisplay") %>
		</span> <span style="float:right; padding-right:20px;" class="head">您好：<%=request.getSession().getAttribute("username") %>
		</span> <span style="padding-left:10px; font-size: 16px; "><img
			src="../images/blocks.gif" width="20" height="20" align="absmiddle" />武汉市第一医院手术室压差、温湿度监测系统
		</span>
	</div>

	<div region="south" split="true"
		style="height: 30px; background: #D2E0F2; ">
		<div class="footer">Powered by 湖北省电子科学研究所有限公司</div>
	</div>

	<div region="west" hide="true" split="true" title="导航菜单"
		style="width:200px;" id="west">
		<div id="nav" class="easyui-accordion" fit="true" border="false">
		</div>
	</div>

	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y:hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="武汉市第一医院手术室压差、温湿度监测系统"
				style="padding:10px;overflow:hidden;overflow-y:scroll; overflow-x:scroll; ">
				<!--  <div id="map" class="map">-->
				<iframe src="map.html" style="width:100%;height:100%;border:none;"
					scrolling="no"></iframe>
			</div>
		</div>
	</div>

	<div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页面右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页面左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>



</body>
</html>