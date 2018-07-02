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

<link rel="stylesheet" type="text/css" href="../../js/framejs/jquery-easyui-1.3.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../../js/framejs/jquery-easyui-1.3.2/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../js/framejs/jquery-easyui-1.3.2/demo/demo.css">
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/datagrid-detailview.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>
<script>
 $(document).ready(function() {  
 	Highcharts.setOptions({ global: { useUTC: false } }); 
     chart = new Highcharts.Chart({  
         chart: {  
             renderTo: 'divChart',          //����ͼ�������  
             plotBackgroundColor: null,  
             plotBorderWidth: null,  
             defaultSeriesType: 'spline'  
         },  
         title: {  
             text: '湿度历史曲线'  
         },  
         subtitle: {  
             text: ''  
         },  
         xAxis: {//X�����  
            type: 'datetime',                                                   
	   tickPixelInterval: 100,
  
             labels: {  
                 //rotation: -45, 
		//������б  
                // align: 'right',  
                 style: { font: 'normal 12px ����' }  
             }  
         },  
         yAxis: {//Y����ʾ����  
             title: {  
                 text: 'MW'  
             }  
         },  
         tooltip: {  
             enabled: true,  
             formatter: function() {  
                 return '<b>'+ this.series.name +'</b><br/>'+                
					Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) +'<br/>'+
					Highcharts.numberFormat(this.y, 2);                         
             }  
         },  
         plotOptions: {  
             line: {  
                 dataLabels: {  
                     enabled: false  //	�Ƿ�����ݵ���ֱ����ʾ���
                 },  
                 enableMouseTracking: true//�Ƿ���ʾtitle  
             }  
         },  
         series: [{                                                              
			name: '湿度',  
			 marker: {
                    enabled: false},                                               

		}]  
         });  
      
         $(document).ready(function() {    
               
         });  
});</script>
<script src="../../js/myjs/lineofhistorydataofrh.js" type="text/javascript"></script>
<body style="background-color:#FFFFF4" onload="init()"> 
	<div id="tb" style="padding:3px">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;起始时间： <input id="start_timeInput" class="easyui-datetimebox" style="width:160px"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间：<input id="end_timeInput" class="easyui-datetimebox" style="width:160px"/>
		&nbsp;&nbsp;&nbsp;监测点：<input id="streamInput" class="easyui-combobox" style="width:150px"
					url="../../data/linehistoryrh.json"
					valueField="id" textField="text"/>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="queryBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查询</a>
		
	</div>
<div id="divChart"> </div></body>
</html>