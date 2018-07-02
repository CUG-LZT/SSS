var r = /^[0-9]*[1-9][0-9]*$/; // 整数的正则表达式

// 初始化函数，将userinfo.jsp的文本框变成不可编辑的, 给一些空间添加监听事件.
function init() {
	document.getElementById('DP').disabled = true;
	document.getElementById('DR').disabled = true;
	document.getElementById('DT').disabled = true;
	document.getElementById('P1').disabled = true;
	document.getElementById('P2').disabled = true;
	document.getElementById('P3').disabled = true;
	document.getElementById('P4').disabled = true;
	document.getElementById('P5').disabled = true;
	document.getElementById('P6').disabled = true;
	document.getElementById('P7').disabled = true;
	document.getElementById('P8').disabled = true;
	document.getElementById('P9').disabled = true;
	document.getElementById('P10').disabled = true;
	document.getElementById('P11').disabled = true;
	document.getElementById('P12').disabled = true;
	document.getElementById('P13').disabled = true;
	document.getElementById('P14').disabled = true;
	document.getElementById('P15').disabled = true;
	document.getElementById('P16').disabled = true;
	document.getElementById('P17').disabled = true;
	document.getElementById('P18').disabled = true;
	document.getElementById('P19').disabled = true;
	document.getElementById('P20').disabled = true;
	document.getElementById('P21').disabled = true;
	document.getElementById('P22').disabled = true;
	document.getElementById('P23').disabled = true;
	document.getElementById('P24').disabled = true;
	document.getElementById('P25').disabled = true;
	document.getElementById('P26').disabled = true;
	document.getElementById('P27').disabled = true;
	document.getElementById('P28').disabled = true;
	
	document.getElementById('t').disabled = true;
	document.getElementById('rh').disabled = true;
	document.getElementById('saveInfoBtn').style.display = "none";
	
}

// 将userinfo.jsp的文本框变成可编辑的.
function chageInfoPressed() {
	document.getElementById('saveInfoBtn').style.display = "block";
	document.getElementById('DR').disabled = false;
	document.getElementById('DT').disabled = false;
	document.getElementById('P1').disabled = false;
	document.getElementById('P2').disabled = false;
	document.getElementById('P3').disabled = false;
	document.getElementById('P4').disabled = false;
	document.getElementById('P5').disabled = false;
	document.getElementById('P6').disabled = false;
	document.getElementById('P7').disabled = false;
	document.getElementById('P8').disabled = false;
	document.getElementById('P9').disabled = false;
	document.getElementById('P10').disabled = false;
	document.getElementById('P11').disabled = false;
	document.getElementById('P12').disabled = false;
	document.getElementById('P13').disabled = false;
	document.getElementById('P14').disabled = false;
	document.getElementById('P15').disabled = false;
	document.getElementById('P16').disabled = false;
	document.getElementById('P17').disabled = false;
	document.getElementById('P18').disabled = false;
	document.getElementById('P19').disabled = false;
	document.getElementById('P20').disabled = false;
	document.getElementById('P21').disabled = false;
	document.getElementById('P22').disabled = false;
	document.getElementById('P23').disabled = false;
	document.getElementById('P24').disabled = false;
	document.getElementById('P25').disabled = false;
	document.getElementById('P26').disabled = false;
	document.getElementById('P27').disabled = false;
	document.getElementById('P28').disabled = false;
	
	document.getElementById('t').disabled = false;
	document.getElementById('rh').disabled = false;
}