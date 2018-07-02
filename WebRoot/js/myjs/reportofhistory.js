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
			{field:'statues', width:'100', align:'center',title:'是否处理'},
			{field:'type', width:'100', align:'center',title:'异常类型'},
			]]
	});
	
	
	query();
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