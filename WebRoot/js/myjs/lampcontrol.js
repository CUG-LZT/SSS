var sum ;

$(document).ready(function() {    
	sum = [1,1,1,1,1,1,1,1,1,1]; //1代表锁定
	ajax();
	window.setInterval(ajax,5000); 
});

function ajax() {
    $.ajax({  
        type: "POST",     //要用post方式       
        url: "http://172.16.10.165:8080/sss/servlet/Getlampdata",         
        contentType: "application/json",   
        dataType: "json",  
        success: function (data) { 
        	if(data.length > 0){
        		for(var i = 0 ; i < data.length ; i++){
        			sum[i] = data[i];
        		}
        	inittemp(sum);//初始化锁定状态
        	}
        	else
        		alert("数据通讯异常！无法获取初始状态！");
        },  
        error: function (err) {
            console.log(err);  
        }  
    }); 
}


function inittemp(sum){
	var lacal = 0;
	for(var i = 0 ; i < 10 ; i++){
		if(sum[i]==1){//如果是锁定就变红
			lacal = i + 11;
			$("#l"+lacal+"p").css("background-color","red");
			$("#"+lacal).css("color","#00DB00");
		}else{
			lacal = i + 11;
			$("#l"+lacal+"p").css("background-color","#00DB00");
			$("#"+lacal).css("color","black");
		}
	}
}

function openw(u){
	/* 改为列表形式
	 * 添加两种状态：正在锁定和 正在解锁用于主界面显示
	 * 前端弹框提示内容：先从后台获取状态，选取后进行比对确定提示内容
	 * 
	 */
	if(sum[u-11]==1){
		$("#l"+u+"p").css("background-color","#0033CC");//更改中
		$("#"+u).css("color","black");
		sum[u-11]=0;
	}else{
		$("#l"+u+"p").css("background-color","#0033CC");
		$("#"+u).css("color","#00DB00");
		sum[u-11]=1;
	}
}

function send(){
	var res = confirm("确认操作！");
	if (res == true) {
		var restwice = confirm("再次确认操作！");
		if (restwice == true) {
			$.ajax({
				type : "POST",
				url : "http://172.16.10.165:8080/sss/servlet/Changelampdata",
				data : {
					"data" : sum,
				},
				dataType : "json",
				traditional: true,//属性在这里设置
				success : function(data) {
					alert(data);
					ajax();
				},
				error : function(err) {
					alert("error!");
				}
			});
		} else {
			alert("已取消操作！");
			ajax();
		}
	} else {
		alert("已取消操作！");
		ajax();
	}
}
