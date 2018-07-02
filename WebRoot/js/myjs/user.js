// 初始化函数
function init() {

}

function add() {
	$('#dlg').dialog('open').dialog('setTitle', '新增用户');
	document.getElementById("tb").style.display = "none";
}

function removeUser() {
	var row = $("#dg").datagrid('getSelected');
	if (row) {
		$.ajax({
			type : "POST",
			url : "http://172.16.10.165:8080/sss/servlet/RemoveUser",
			data : {
				"id" : row.id
			},
			dataType : "json",
			success : function(data) {
				if (data.flag == "1") {
					$('#dlg').dialog('close'); // close the dialog
					document.getElementById("tb").style.display = "block";
					$('#dg').datagrid('reload'); // reload the user data
				} else {
					$.messager.alert('错误', data.msg, 'error');
				}
			},
			error : function(err) {
				alert("error!");
				$('#dlg').dialog('close'); // close the dialog
				document.getElementById("tb").style.display = "block";
				$('#dg').datagrid('reload'); // reload the user data
			}
		});
	} else {
		$.messager.show({
			title : '警告',
			msg : '请先选择用户。'
		});
	}
}

function addUser() {
	var role = $('#role').combobox('getValue');
	var username = $('#username').val();
	var password = $('#password').val();
	$.ajax({
		type : "POST",
		url : "http://172.16.10.165:8080/sss/servlet/AddUser",
		data : {
			"username" : username,
			"password" : password,
			"role" : role
		},
		dataType : "json",
		success : function(data) {
			if (data.flag == "1") {
				$('#dlg').dialog('close'); // close the dialog
				document.getElementById("tb").style.display = "block";
				$('#dg').datagrid('reload'); // reload the user data
			} else {
				$.messager.alert('错误', data.msg, 'error');
			}
		},
		error : function(err) {
			alert("error!");
			$('#dlg').dialog('close'); // close the dialog
			document.getElementById("tb").style.display = "block";
			$('#dg').datagrid('reload'); // reload the user data
		}

	});
}

function Cancel() {
	$('#dlg').dialog('close');
	document.getElementById("tb").style.display = "block";
}
