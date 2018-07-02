function init() {
	var etimeStr = new Date().getFullYear() + "-" + (new Date().getMonth() + 1)
			+ "-" + new Date().getDate() + " " + new Date().getHours() + ":"
			+ new Date().getMinutes() + ":" + new Date().getSeconds();
	var stimeStr = new Date().getFullYear() + "-" + (new Date().getMonth() + 1)
			+ "-" + new Date().getDate() + " 00:00:00";
	$('#start_timeInput').datetimebox('setValue', stimeStr);
	$('#end_timeInput').datetimebox('setValue', etimeStr);
	query();
}

// 查询函数
function query() {
	var starttime = $('#start_timeInput').datetimebox('getValue');
	var endtime = $('#end_timeInput').datetimebox('getValue');
	console.log("starttime" + starttime);
	if (starttime != "") {
		$('#dg').datagrid('load', {
			start_time : $('#start_timeInput').datetimebox('getValue'),
			end_time : $('#end_timeInput').datetimebox('getValue'),
		});
	} else {
		alert("起始时间和终止时间不能为空！");
	}
}

// strPrintName 打印任务名
// printDatagrid 要打印的datagrid
function CreateFormPage(strPrintName, printDatagrid) {
	console.log(strPrintName+"   "+printDatagrid);
	var tableString = '<table cellspacing="0" class="pb">';
	var frozenColumns = printDatagrid.datagrid("options").frozenColumns; // 得到frozenColumns对象
	var columns = printDatagrid.datagrid("options").columns; // 得到columns对象
	var nameList = '';

	// 载入title
	if (typeof columns != 'undefined' && columns != '') {
		$(columns)
				.each(
						function(index) {
							tableString += '\n<tr>';
							if (typeof frozenColumns != 'undefined'
									&& typeof frozenColumns[index] != 'undefined') {
								for (var i = 0; i < frozenColumns[index].length; ++i) {
									if (!frozenColumns[index][i].hidden) {
										tableString += '\n<th width="'
												+ frozenColumns[index][i].width
												+ '"';
										if (typeof frozenColumns[index][i].rowspan != 'undefined'
												&& frozenColumns[index][i].rowspan > 1) {
											tableString += ' rowspan="'
													+ frozenColumns[index][i].rowspan
													+ '"';
										}
										if (typeof frozenColumns[index][i].colspan != 'undefined'
												&& frozenColumns[index][i].colspan > 1) {
											tableString += ' colspan="'
													+ frozenColumns[index][i].colspan
													+ '"';
										}
										if (typeof frozenColumns[index][i].field != 'undefined'
												&& frozenColumns[index][i].field != '') {
											nameList += ',{"f":"'
													+ frozenColumns[index][i].field
													+ '", "a":"'
													+ frozenColumns[index][i].align
													+ '"}';
										}
										tableString += '>'
												+ frozenColumns[0][i].title
												+ '</th>';
									}
								}
							}
							for (var i = 0; i < columns[index].length; ++i) {
								if (!columns[index][i].hidden) {
									tableString += '\n<th width="'
											+ columns[index][i].width + '"';
									if (typeof columns[index][i].rowspan != 'undefined'
											&& columns[index][i].rowspan > 1) {
										tableString += ' rowspan="'
												+ columns[index][i].rowspan
												+ '"';
									}
									if (typeof columns[index][i].colspan != 'undefined'
											&& columns[index][i].colspan > 1) {
										tableString += ' colspan="'
												+ columns[index][i].colspan
												+ '"';
									}
									if (typeof columns[index][i].field != 'undefined'
											&& columns[index][i].field != '') {
										nameList += ',{"f":"'
												+ columns[index][i].field
												+ '", "a":"'
												+ columns[index][i].align
												+ '"}';
									}
									tableString += '>'
											+ columns[index][i].title + '</th>';
								}
							}
							tableString += '\n</tr>';
						});
	}
	// 载入内容
	var rows = printDatagrid.datagrid("getRows"); // 这段代码是获取当前页的所有行
	var nl = eval('([' + nameList.substring(1) + '])');
	for (var i = 0; i < rows.length; ++i) {
		tableString += '\n<tr>';
		$(nl).each(function(j) {
			var e = nl[j].f.lastIndexOf('_0');

			tableString += '\n<td';
			if (nl[j].a != 'undefined' && nl[j].a != '') {
				tableString += ' style="text-align:' + nl[j].a + ';"';
			}
			tableString += '>';
			if (e + 2 == nl[j].f.length) {
				tableString += rows[i][nl[j].f.substring(0, e)];
			} else
				tableString += rows[i][nl[j].f];
			tableString += '</td>';
		});
		tableString += '\n</tr>';
	}
	sessionStorage.setItem("sent", tableString);
	tableString += '\n</table>';
	window.open(
					"../../page/menuPage/print.jsp",
					strPrintName,
					"location:No;status:No;help:No;dialogWidth:800px;dialogHeight:600px;scroll:auto;");
}
