var sum ;
var suni = 0;
function openw(u){
	var url = 'menuPage/'+u+'.jsp';
	window.open(url, '', 'height=500, width=600, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');  
	
}

function changeData(data){
	//c是数据通讯那个东西
	if(data.c ==1){
		$("#C").css("background-color","#00DB00");//绿色
	    $("#C").css({"-webkit-animation":""});
	    $("#C").css({"animation":""});
	}else{
		$("#C").css("background-color","#FF2D2D");//红色
	    $("#C").css({"-webkit-animation":"twinkling 1.5s infinite ease-in-out"});
	    $("#C").css({"animation":"twinkling 1.5s infinite ease-in-out"});
	}
	
	if(data.p ==1){
		$("#P").css("background-color","#00DB00");
	    $("#P").css({"-webkit-animation":""});
	    $("#p").css({"animation":""});
	}else if(data.p ==2){
		$("#P").css("background-color","#FFA500");//黄色
	    $("#P").css({"-webkit-animation":"twinkling 1.5s infinite ease-in-out"});
	    $("#P").css({"animation":"twinkling 1.5s infinite ease-in-out"});
	}else{
		$("#P").css("background-color","#FF2D2D");
	    $("#P").css({"-webkit-animation":"twinkling 1.5s infinite ease-in-out"});
	    $("#P").css({"animation":"twinkling 1.5s infinite ease-in-out"});
	}
	if(data.t ==1){
		$("#T").css("background-color","#00DB00");
	    $("#T").css({"-webkit-animation":""});
	    $("#T").css({"animation":""});
	}else if(data.t ==2){
		$("#T").css("background-color","#FFA500");//黄色
	    $("#T").css({"-webkit-animation":"twinkling 1.5s infinite ease-in-out"});
	    $("#T").css({"animation":"twinkling 1.5s infinite ease-in-out"});
	}else{
		$("#T").css("background-color","#FF2D2D");
	    $("#T").css({"-webkit-animation":"twinkling 1.5s infinite ease-in-out"});
	    $("#T").css({"animation":"twinkling 1.5s infinite ease-in-out"});
	} 
	if(data.rh ==1){
		$("#RH").css("background-color","#00DB00");
	    $("#RH").css({"-webkit-animation":""});
	    $("#RH").css({"animation":""});
	}else if(data.rh ==2){
		$("#RH").css("background-color","#FFA500");//黄色
	    $("#RH").css({"-webkit-animation":"twinkling 1.5s infinite ease-in-out"});
	    $("#RH").css({"animation":"twinkling 1.5s infinite ease-in-out"});
	}else{
		$("#RH").css("background-color","#FF2D2D");
	    $("#RH").css({"-webkit-animation":"twinkling 1.5s infinite ease-in-out"});
	    $("#RH").css({"animation":"twinkling 1.5s infinite ease-in-out"});
	} 
	
	
	
	if(data.p1c==1){
		$("#p1").html('p1&nbsp:' + data.p1);
		$("#p1").css("color","#00DB00");
	}
	else{
		$("#p1").html('p1&nbsp:' + data.p1 );
		$("#p1").css("color","#FF5151");
	}

	if(data.p2c==1){
		$("#p2").html('p2&nbsp:' + data.p2 );
		$("#p2").css("color","#00DB00");;
	}
	else{
		$("#p2").html('p2&nbsp:' + data.p2 );
		$("#p2").css("color","#FF5151");
	}
	
	if(data.p3c ==1){
		$("#p3").html('p3&nbsp:' + data.p3 );
		$("#p3").css("color","#00DB00");
	}
	else{
		$("#p3").html('p3&nbsp:' + data.p3 );
		$("#p3").css("color","#FF5151");
	}
	if(data.p4c ==1){
		$("#p4").html('p4&nbsp:' + data.p4 );
		$("#p4").css("color","#00DB00");
	}
	else{
		$("#p4").html('p4&nbsp:' + data.p4 );
		$("#p4").css("color","#FF5151");
	}
	if(data.p5c ==1){
		$("#p5").html('p5&nbsp:' + data.p5 );
		$("#p5").css("color","#00DB00");
	}
	else{
		$("#p5").html('p5&nbsp:' + data.p5 );
		$("#p5").css("color","#FF5151");
	}
	if(data.p6c ==1){
		$("#p6").html('p6&nbsp:' + data.p6 );
		$("#p6").css("color","#00DB00");
	}
	else{
		$("#p6").html('p6&nbsp:' + data.p6 );
		$("#p6").css("color","#FF5151");
	}
	if(data.p7c ==1){
		$("#p7").html('p7&nbsp:' + data.p7 );
		$("#p7").css("color","#00DB00");
	}
	else{
		$("#p7").html('p7&nbsp:' + data.p7 );
		$("#p7").css("color","#FF5151");
	}
	if(data.p8c ==1){
		$("#p8").html('p8&nbsp:' + data.p8 );
		$("#p8").css("color","#00DB00");
	}
	else{
		$("#p8").html('p8&nbsp:' + data.p8 );
		$("#p8").css("color","#FF5151");
	}
	if(data.p9c ==1){
		$("#p9").html('p9&nbsp:' + data.p9 );
		$("#p9").css("color","#00DB00");
	}else{
		$("#p9").html('p9&nbsp:' + data.p9 );
		$("#p9").css("color","#FF5151");
	}
	if(data.p10c ==1){ 
		$("#p10").html('p10&nbsp:' + data.p10 );
		$("#p10").css("color","#00DB00");
	}else{
		$("#p10").html('p10&nbsp:' + data.p10 );
		$("#p10").css("color","#FF5151");
	}
	if(data.p11c ==1){
		$("#p11").html('p11&nbsp:' + data.p11 );
		$("#p11").css("color","#00DB00");
	}
	else{
		$("#p11").html('p11&nbsp:' + data.p11 );
		$("#p11").css("color","#FF5151");
	}
	if(data.p12c ==1){
		$("#p12").html('p12&nbsp:' + data.p12 );
		$("#p12").css("color","#00DB00");
	}
	else{
		$("#p12").html('p12&nbsp:' + data.p12 );
		$("#p12").css("color","#FF5151");
	}
	if(data.p13c ==1){
		$("#p13").html('p13&nbsp:' + data.p13 );
		$("#p13").css("color","#00DB00");
	}
	else{
		$("#p13").html('p13&nbsp:' + data.p13 );
		$("#p13").css("color","#FF5151");
	}
	if(data.p14c ==1){
		$("#p14").html('p14&nbsp:' + data.p14 );
		$("#p14").css("color","#00DB00");
	}
	else{
		$("#p14").html('p14&nbsp:' + data.p14 );
		$("#p14").css("color","#FF5151");
	}
	if(data.p15c ==1){
		$("#p15").html('p15&nbsp:' + data.p15 );
		$("#p15").css("color","#00DB00");
	}
	else{
		$("#p15").html('p15&nbsp:' + data.p15 );
		$("#p15").css("color","#FF5151");
	}
	if(data.p16c ==1){
		$("#p16").html('p16&nbsp:' + data.p16 );
		$("#p16").css("color","#00DB00");
	}
	else{
		$("#p16").html('p16&nbsp:' + data.p16 );
		$("#p16").css("color","#FF5151");
	}
	if(data.p17c ==1){
		$("#p17").html('p17&nbsp:' + data.p17 );
		$("#p17").css("color","#00DB00");
	}
	else{
		$("#p17").html('p17&nbsp:' + data.p17 );
		$("#p17").css("color","#FF5151");
	}
	if(data.p18c ==1){
		$("#p18").html('p18&nbsp:' + data.p18 );
		$("#p18").css("color","#00DB00");
	}
	else{
		$("#p18").html('p18&nbsp:' + data.p18 );
		$("#p18").css("color","#FF5151");
	}
	if(data.p19c ==1){
		$("#p19").html('p19&nbsp:' + data.p19 );
		$("#p19").css("color","#00DB00");
	}
	else{
		$("#p19").html('p19&nbsp:' + data.p19 );
		$("#p19").css("color","#FF5151");
	}
	if(data.p20c ==1){
		$("#p20").html('p20&nbsp:' + data.p20 );
		$("#p20").css("color","#00DB00");
	}
	else{
		$("#p20").html('p20&nbsp:' + data.p20 );
		$("#p20").css("color","#FF5151");
	}
	if(data.p21c ==1){
		$("#p21").html('p21&nbsp:' + data.p21 );
		$("#p21").css("color","#00DB00");
	}
	else{
		$("#p21").html('p21&nbsp:' + data.p21 );
		$("#p21").css("color","#FF5151");
	}
	if(data.p22c ==1){
		$("#p22").html('p22&nbsp:' + data.p22 );
		$("#p22").css("color","#00DB00");
	}
	else{
		$("#p22").html('p22&nbsp:' + data.p22 );
		$("#p22").css("color","#FF5151");
	}
	if(data.p23c ==1){
		$("#p23").html('p23&nbsp:' + data.p23 );
		$("#p23").css("color","#00DB00");
	}
	else{
		$("#p23").html('p23&nbsp:' + data.p23 );
		$("#p23").css("color","#FF5151");
	}
	if(data.p24c ==1){
		$("#p24").html('p24&nbsp:' + data.p24 );
		$("#p24").css("color","#00DB00");
	}
	else{
		$("#p24").html('p24&nbsp:' + data.p24 );
		$("#p24").css("color","#FF5151");
	}
	if(data.p25c ==1){
		$("#p25").html('p25&nbsp:' + data.p25 );
		$("#p25").css("color","#00DB00");
	}
	else{
		$("#p25").html('p25&nbsp:' + data.p25 );
		$("#p25").css("color","#FF5151");
	}
	if(data.p26c ==1){
		$("#p26").html('p26&nbsp:' + data.p26 );
		$("#p26").css("color","#00DB00");
	}
	else{
		$("#p26").html('p26&nbsp:' + data.p26 );
		$("#p26").css("color","#FF5151");
	}
	if(data.p27c ==1){
		$("#p27").html('p27&nbsp:' + data.p27 );
		$("#p27").css("color","#00DB00");
	}
	else{
		$("#p27").html('p27&nbsp:' + data.p27 );
		$("#p27").css("color","#FF5151");
	}
	if(data.p28c ==1){
		$("#p28").html('p28&nbsp:' + data.p28 );
		$("#p28").css("color","#00DB00");
	}
	else{
		$("#p28").html('p28&nbsp:' + data.p28 );
		$("#p28").css("color","#FF5151");
	}
	
//wendu 
	if(data.t1c ==0){
		$("#sum1t").css("background","red");
		$("#sum1tdata").html(data.t1);
	}
	else{
		$("#sum1t").css("background","#00DB00");
		$("#sum1tdata").html(data.t1);
	}
	if(data.t2c ==0){
		$("#sum2t").css("background","red");
		$("#sum2tdata").html(data.t2);
	}
	else{
		$("#sum2t").css("background","#00DB00");
		$("#sum2tdata").html(data.t2);
	}
	if(data.t3c ==0){
		$("#sum3t").css("background","red");
		$("#sum3tdata").html(data.t3);
	}
	else{
		$("#sum3t").css("background","#00DB00");
		$("#sum3tdata").html(data.t3);
	}
	if(data.t4c ==0){
		$("#sum4t").css("background","red");
		$("#sum4tdata").html(data.t4);
	}
	else{
		$("#sum4t").css("background","#00DB00");
		$("#sum4tdata").html(data.t4);
	}
	if(data.t5c ==0){
		$("#sum5t").css("background","red");
		$("#sum5tdata").html(data.t5);
	}
	else{
		$("#sum5t").css("background","#00DB00");
		$("#sum5tdata").html(data.t5);
	}
	if(data.t6c ==0){
		$("#sum6t").css("background","red");
		$("#sum6tdata").html(data.t6);
	}
	else{
		$("#sum6t").css("background","#00DB00");
		$("#sum6tdata").html(data.t6);
	}
	if(data.t7c ==0){
		$("#sum7t").css("background","red");
		$("#sum7tdata").html(data.t7);
	}
	else{
		$("#sum7t").css("background","#00DB00");
		$("#sum7tdata").html(data.t7);
	}
	if(data.t8c ==0){
		$("#sum8t").css("background","red");
		$("#sum8tdata").html(data.t8);
	}
	else{
		$("#sum8t").css("background","#00DB00");
		$("#sum8tdata").html(data.t8);
	}
	if(data.t9c ==0){
		$("#sum9t").css("background","red");
		$("#sum9tdata").html(data.t9);
	}
	else{
		$("#sum9t").css("background","#00DB00");
		$("#sum9tdata").html(data.t9);
	}
	if(data.t10c ==0){
		$("#sum10t").css("background","red");
		$("#sum10tdata").html(data.t10);
	}
	else{
		$("#sum10t").css("background","#00DB00");
		$("#sum10tdata").html(data.t10);
	}
	
	
	
	
	
	
	if(data.rh1c ==0){
		$("#sum1rh").css("background","red");
		$("#sum1rhdata").html(data.rh1);
	}else{
		$("#sum1rh").css("background","#00DB00");
		$("#sum1rhdata").html(data.rh1);	
	}
	if(data.rh2c ==0){
		$("#sum2rh").css("background","red");
		$("#sum2rhdata").html(data.rh2);
	}else{
		$("#sum2rh").css("background","#00DB00");
		$("#sum2rhdata").html(data.rh2);
	}
	if(data.rh3c ==0){
		$("#sum3rh").css("background","red");
		$("#sum3rhdata").html(data.rh3);
	}else{
		$("#sum3rh").css("background","#00DB00");
		$("#sum3rhdata").html(data.rh3);
	}
	if(data.rh4c ==0){
		$("#sum4rh").css("background","red");
		$("#sum4rhdata").html(data.rh4);
	}else{
		$("#sum4rh").css("background","#00DB00");
		$("#sum4rhdata").html(data.rh4);
	}
	if(data.rh5c ==0){
		$("#sum5rh").css("background","red");
		$("#sum5rhdata").html(data.rh5);
	}else{
		$("#sum5rh").css("background","#00DB00");
		$("#sum5rhdata").html(data.rh5);
	}
	if(data.rh6c ==0){
		$("#sum6rh").css("background","red");
		$("#sum6rhdata").html(data.rh6);
	}else{
		$("#sum6rh").css("background","#00DB00");
		$("#sum6rhdata").html(data.rh6);
	}
	if(data.rh7c ==0){
		$("#sum7rh").css("background","red");
		$("#sum7rhdata").html(data.rh7);
	}else{
		$("#sum7rh").css("background","#00DB00");
		$("#sum7rhdata").html(data.rh7);
	}
	if(data.rh8c ==0){
		$("#sum8rh").css("background","red");
		$("#sum8rhdata").html(data.rh8);
	}else{
		$("#sum8rh").css("background","#00DB00");
		$("#sum8rhdata").html(data.rh8);
	}
	if(data.rh9c ==0){
		$("#sum9rh").css("background","red");
		$("#sum9rhdata").html(data.rh9);
	}else{
		$("#sum9rh").css("background","#00DB00");
		$("#sum9rhdata").html(data.rh9);
	}
	if(data.rh10c ==0){
		$("#sum10rh").css("background","red");
		$("#sum10rhdata").html(data.rh10);
	}else{
		$("#sum10rh").css("background","#00DB00");
		$("#sum10rhdata").html(data.rh10);
	}
	

}


// Ajax从服务器拿数据
function ajax() {
	
    $.ajax({  
        type: "POST",     //要用post方式       
        url: "http://172.16.10.165:8080/sss/servlet/GetDatatomap",         
        contentType: "application/json",   
        dataType: "json",  
        success: function (data) { 
        		changeData(data);
        },  
        error: function (err) {
            console.log(err);  
        }  
    }); 

}

function ajaxi() {
    $.ajax({  
        type: "POST",     //要用post方式       
        url: "http://172.16.10.165:8080/sss/servlet/Getlampdata",         
        contentType: "application/json",   
        dataType: "json",  
        success: function (data) { 
        	var newdata = data.da;
        	if(data.sum == 1){
        			$("#LED").css("background-color","#00DB00");
        		    $("#LED").css({"-webkit-animation":""});
        		    $("#LED").css({"animation":""});
        		}
        	else{
        			$("#LED").css("background-color","#FF2D2D");
        		    $("#LED").css({"-webkit-animation":"twinkling 1.5s infinite ease-in-out"});
        		    $("#LED").css({"animation":"twinkling 1.5s infinite ease-in-out"});
        		} 
        	if(newdata.length > 0){
        		for(var i = 0 ; i < newdata.length ; i++){
        			sum[i] = newdata[i];
        		}
        		inittemp(sum);//初始化锁定状态
        	}
        	else
        		if(suni < 1){
        			alert("数据通讯异常！无法获取初始状态！");
        			suni++;
        		}
        		
        },  
        error: function (err) {
            console.log(err);  
        }  
    }); 
}
function inittemp(sum){
	var lacal = 0;
	for(var i = 0 ; i < 10 ; i++){
		lacal = i + 1; 
		if(sum[i]==1){//如果是锁定就变红
			$("#sum"+lacal+"led").css("background","red");
			//$("#sum"+lacal+"leddata").html("锁定");
		}else if(sum[i]==0){
			$("#sum"+lacal+"led").css("background","#00DB00");
			//$("#sum"+lacal+"leddata").html("未锁定");
		}else if(sum[i]==11){
			$("#sum"+lacal+"led").css("background","#B0C4DE");
			//$("#sum"+lacal+"leddata").html("锁定中");
		}else if(sum[i]==10){
			$("#sum"+lacal+"led").css("background","#B0C4DE");
			//$("#sum"+lacal+"leddata").html("解锁中");
		}
		
	}
}
$(document).ready(function() {    
    //每隔60秒自动调用方法，实现数据实时更新   
	ajax();
    window.setInterval(ajax,60000); 
	sum = [1,1,1,1,1,1,1,1,1,1]; //1代表锁定
	ajaxi();
	window.setInterval(ajaxi,5000); 
});