function init() {
	var etimeStr = new Date().getFullYear() + "-" + (new Date().getMonth() + 1)
		+ "-" + new Date().getDate() + " " + new Date().getHours() + ":"
		+ new Date().getMinutes() + ":" + new Date().getSeconds();
	var stimeStr = new Date().getFullYear() + "-" + (new Date().getMonth() + 1)
		+ "-" + new Date().getDate() + " 00:00:00";
	$('#start_timeInput').datetimebox('setValue', stimeStr);
	$('#end_timeInput').datetimebox('setValue', etimeStr);
	
	$('#dg').datagrid({
		title:"报告单管理" ,
		toolbar:"#tb",
		iconCls: "icon-search",
		rownumbers:false,
		pagination:true,
		singleSelect:true,
		fitColumns:false,
		showFooter:false,
		striped:"true",
		pageNumber:1,
		ageSize:15,
		pageList:[15, 20, 30],
		columns:[[
			{field:'id',width:'50',align:'center',title:'编号'},
			{field:'starttime', width:'150', align:'center',title:'起始时间'},
			{field:'endtime', width:'150', align:'center',title:'结束时间'},
			{field:'location', width:'100', align:'center',title:'位置'},
			{field:'detail' ,width:'100', align:'center',title:'详情'},
			{field:'type', width:'100', align:'center',title:'异常类型'},
			{field:'isdeal',title:"操作",width:100,align:'center',
				formatter:function(value,row,index){		
					var s = '<a href="#" onclick="addtoreport('+row.id+')">完成提交</a> ';
					return s;
				}
			}]]
	});
	
	
	query();
}

function addtoreport(id){
		var restwice = confirm("确认提交！");
		if (restwice == true) {
			$.ajax({
				type : "POST",
				url : "http://172.16.10.165:8080/sss/servlet/Addreport?caozuo=qr",
				data : {
					"id" : id,
				},
				dataType : "json",
				traditional: true,//属性在这里设置
				success : function(data) {
					if(data){
						alert("添加成功");
						query();
					}
				},
				error : function(err) {
					alert("error!");
				}
			});
		} else {
			alert("已取消操作！");
		}
}


function query() {
	var starttime = $('#start_timeInput').datetimebox('getValue');
	console.log("查询起始时间：" + starttime);
	if (starttime != "") {
		$('#dg').datagrid('load', {
			start_time : $('#start_timeInput').datetimebox('getValue'),
			end_time : $('#end_timeInput').datetimebox('getValue'),
		});
	} else {
		alert("起始时间和终止时间不能为空！");
	}
}