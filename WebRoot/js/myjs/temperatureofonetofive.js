var time = (new Date()).getTime() - 60000;
function init() {
	query();
	window.setInterval(query,60000); 
}

// 查询函数
function query() {
	

	$.ajax({
		type : "POST", //Ҫ��post��ʽ       
		url : "http://172.16.10.165:8080/sss/servlet/Temperatureofonetofive?oneorsix=one",
		//contentType: "application/json",  
		data : {
		},
		dataType : "json",
		success : function(data) {
			data1 = data;
			var n = data1["time"].length;
			Highcharts.setOptions({
				global : {
					useUTC : false
				}
			});
			chart = new Highcharts.Chart(
					{
						chart : {
							renderTo : 'divChart', //����ͼ�������  
							plotBackgroundColor : null,
							plotBorderWidth : null,
							defaultSeriesType : 'spline'
						},
						title : {
							text : '温度实时监控(t11-t15)'
						},
						subtitle : {
							text : ''
						},
						xAxis : {
							type : 'datetime',
							tickPixelInterval : 100,

							labels : {
								style : {
									font : 'normal 12px ����'
								}
							}
						},
						yAxis : {  
							title : {
								text : 'MW'
							}
						},
						tooltip : {
							enabled : true,
							formatter : function() {
								return '<b>'
										+ this.series.name
										+ '</b><br/>'
										+ Highcharts
												.dateFormat(
														'%Y-%m-%d %H:%M:%S',
														this.x)
										+ '<br/>'
										+ Highcharts
												.numberFormat(
														this.y,
														2);
							}
						},
						plotOptions : {
							line : {
								dataLabels : {
									enabled : false
								},
								enableMouseTracking : true
							}
						},
						series : [
								{
									name : '(t11)',
									data : (function() {                           
										var data = [], i;
										for (i = -n + 1; i <= 0; i++) {

											data.push({
														x : time + i * 60000,
														y : data1["num"][i + n - 1]
													});
										}
										return data;
									})()
								},
								{
									name : '(t12)',
									data : (function() {
										// generate an array of random data                             
										var data = [], i;

										for (i = -n + 1; i <= 0; i++) {

											data.push({
														x : time + i * 60000,
														y : data1["num1"][i + n - 1]
													});
										}

										return data;
									})()
								},
								{
									name : '(t13)',
									data : (function() {
										// generate an array of random data                             
										var data = [],

										i;
										for (i = -n + 1; i <= 0; i++) {

											data .push({
														x : time + i * 60000,
														y : data1["num2"][i + n - 1]
													});
										}
										return data;
									})()
								},
								{
									name : '(t14)',
									data : (function() {                         
										var data = [], i;

										for (i = -n + 1; i <= 0; i++) {

											data.push({
														x : time + i * 60000,
														y : data1["num3"][i + n - 1]
													});
										}
										return data;
									})()
								},
								{
									name : '(t15)',
									data : (function() {
										// generate an array of random data                             
										var data = [],

										i;
										for (i = -n + 1; i <= 0; i++) {

											data .push({
														x : time + i * 60000,
														y : data1["num4"][i + n - 1]
													});
										}
										return data;
									})()
								}
								]
					});

		},
		error : function(err) {
			alert("error");
		}
	});
}
