function init() {
	var etimeStr = new Date().getFullYear() + "-" + (new Date().getMonth() + 1)
			+ "-" + new Date().getDate() + " " + new Date().getHours() + ":"
			+ new Date().getMinutes() + ":" + new Date().getSeconds();
	var stimeStr = new Date().getFullYear() + "-" + (new Date().getMonth() + 1)
			+ "-" + new Date().getDate() + " 00:00:00";
	$('#start_timeInput').datetimebox('setValue', stimeStr);
	$('#end_timeInput').datetimebox('setValue', etimeStr);
	$('#streamInput').combobox('setValue', 1);
	query();
}

// 查询函数
function query() {
	var starttime = $('#start_timeInput').datebox('getValue');
	var endtime = $('#end_timeInput').datebox('getValue');
	var stream = $('#streamInput').combobox('getValue');
	console.log(starttime);
	if (starttime != "" && endtime != "") {
		$.ajax({
			type : "POST",
			url : "http://172.16.10.165:8080/sss/servlet/Lineofhistorydataoftemp",
			data : {
				"start_time" : starttime,
				"end_time" : endtime,
				"stream" : stream
			},
			dataType : "json",
			success : function(data) {// 处理返回的数据
				var p1 = [];
				for(var i = 0; i < data["p"].length; i++) {
					var s = data["date"][i];
					var d = new Date(Date.parse(s.replace(/-/g, "/")));
					var tt = d.getTime();
					p1.push({
						x : tt,
						y : data["p"][i]
					});
				}
				chart.series[0].setData(p1);
			},
			error : function(err) {
				alert("error!");
			}
		});
	} else {
		alert("起始时间和终止时间不能为空！");
	}
}
