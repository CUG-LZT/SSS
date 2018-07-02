<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<script src="../../js/framejs/jquery-1.5.2.min.js" type="text/javascript"></script>  
<script src="../../js/framejs/raphael-min.js" type="text/javascript"></script>  
<script src="../../js/framejs/justgage.js" type="text/javascript"></script> 
<script src="../../js/framejs/highcharts.js" type="text/javascript"></script>    
<script src="../../js/framejs/exporting.js" type="text/javascript"></script>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></head>
<script src="../../js/myjs/pof26to28.js" type="text/javascript"></script>

<body style="background-color:#FFFFF4" id="divChart" onload="init()"> 
</html>
