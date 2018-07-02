var select = [0,0,0,0,0,0,0,0,0,0];
$(function() {
	//ajax();
	$('#tt').datagrid('reload', {});
	window.setInterval(ajax,5000); 
	$('#tt').datagrid({onClickRow: function(index,fvalue){
			if(select[fvalue.id-1] ==  0)
				select[fvalue.id-1] = 1;
			else{
				select[fvalue.id-1] = 0;
			}
		}
	});
	
});

function ajax(){
	
	var sum = 10;
	//获取页面状态
	var status= [];
	var rows = $('#tt').datagrid('getRows');
	for (var i = 0; i < rows.length; i++) {
		status.push(rows[i].status);
	}
	
	//从服务器获取状态
	$.ajax({
		type : "POST",
		url : "http://172.16.10.165:8080/sss/servlet/Getdataoflamp",
		dataType : "json",
		traditional: true,//属性在这里设置
		success : function(data) {
			var str="";
			if(data.length > 0){
				for (var i = 0; i < data.length; i++) {
					if(status[i] == data[i].status)
						sum--;
				}
				console.log(sum);
				if(sum > 0){
					$('#tt').datagrid('reload', {});
					$('#tt').datagrid({onLoadSuccess: function(index,fvalue){
						for(var i= 0 ; i < select.length ; i++){
							if(select[i] == 1) 						//显示选中  select值不变
								$("#tt").datagrid("selectRow", i);
						}
					}});
					console.log("yes");
					}
				else
					console.log("no");
			}
		},
		error : function(err) {
			alert("error!");
		}
	});
}

function unlk(){
		var sumoflock = 0, sunofunlk = 0 , sumoftolock = 0 , sumoftounlk = 0 ;
		var ids = [],room = [],status= [], allstatus= [];
		//获取呗选择的看是否是一样的
		var rows = $('#tt').datagrid('getSelections');
		for(var i=0; i<rows.length; i++){
			status.push(rows[i].status);
			room.push(rows[i].number);
			ids.push(rows[i].id);
		}
		//选择的是否有不一样的
		for(var i = 0 ; i < ids.length ; i++){
			if(status[i] == "锁定"){
				sumoflock++;
			}else if(status[i] == "未锁定"){
				sunofunlk++;
			}
		}
		
		//获取所有的行的状态看是否有正在进行的
		var rows1 = $('#tt').datagrid('getRows');
		for (var i = 0; i < rows1.length; i++) {
			allstatus.push(rows1[i].status);
		}
		//所有的行里面是否有正在进行的
		for (var i = 0; i < allstatus.length; i++) {
			if(allstatus[i] == "正在锁定"){
				sumoftolock++;
			}else if(allstatus[i] == "正在解锁"){
				sumoftounlk++;
			}
		}
		
		if(sumoflock!=0 && sunofunlk==0 && sumoftolock==0 && sumoftounlk==0){
			var res = confirm("请确认该手术室环境条件是否达标！");
			if (res == true) {
				var res = confirm("进行解锁房间为："+room);
				if (res == true) {
					$.ajax({
						type : "POST",
						url : "http://172.16.10.165:8080/sss/servlet/Dochangelampdata",
						data : {
							"op" : "unlk",
							"ids" : ids,
						},
						dataType : "json",
						traditional: true,//属性在这里设置
						success : function(data) {
							//alert(data);
						},
						error : function(err) {
							alert("error!");
						}
					});
				}else{
					alert("放弃解锁");
				}
			}else{
				alert("放弃解锁");
			}
		}else{
			alert("所选定的手术室状态不一致！！！");
		}
	
	
	select = [0,0,0,0,0,0,0,0,0,0];
	$("#tt").datagrid("clearSelections");
	ajax();
}

function lock(){
	
		// 判断操作有无异常
		var sumoflock = 0, sunofunlk = 0, sumoftolock = 0, sumoftounlk = 0;
		var ids = [], room = [],status = [],allstatus = [];
		var rows = $('#tt').datagrid('getSelections');
		for (var i = 0; i < rows.length; i++) {
			status.push(rows[i].status);
			room.push(rows[i].number);
			ids.push(rows[i].id);
		}
		var rows1 = $('#tt').datagrid('getRows');
		for (var i = 0; i < rows1.length; i++) {
			allstatus.push(rows1[i].status);
		}
		
		for (var i = 0; i < ids.length; i++) {
			if (status[i] == "锁定") {
				sumoflock++;
			} else if (status[i] == "未锁定") {
				sunofunlk++;
			} 
		}
		for (var i = 0; i < allstatus.length; i++) {
			if (allstatus[i] == "正在锁定") {
				sumoftolock++;
			} else if (allstatus[i] == "正在解锁") {
				sumoftounlk++;
			}
		}
		if (sumoflock == 0 && sunofunlk != 0 && sumoftolock == 0
				&& sumoftounlk == 0) {
			var res = confirm("锁定操作会使得无影灯无法再次开启，是否继续进行锁定操作？");
			if (res == true) {
				//alert("进行锁定id为：" + ids);
				var res = confirm("进行锁定房间为："+ room );
				if (res == true) {
					// 改数据库然后发送指令
					$.ajax({
						type : "POST",
						url : "http://172.16.10.165:8080/sss/servlet/Dochangelampdata",
						data : {
							"op" : "lock",
							"ids" : ids,
						},
						dataType : "json",
						traditional : true,// 属性在这里设置
						success : function(data) {
							//alert(data);
						},
						error : function(err) {
							alert("error!");
						}
					});
				}else{
					alert("放弃锁定");
				}
			}else{
				alert("放弃锁定");
			}
		} else {
			alert("所选定的手术室状态不一致！！！");
		}
	
	select = [0,0,0,0,0,0,0,0,0,0];
	$("#tt").datagrid("clearSelections");
	ajax();
}





