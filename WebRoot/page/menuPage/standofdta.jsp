<%@page import="com.pro.entity.*"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.pro.utils.*"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	 request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String username = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");
	if (username == null && password == null) {
		response.sendRedirect("login.jsp");
	}
	
	Session ss = HibernateSessionFactory.getSession();
	Query queryofstand = ss.createQuery("from Standofdata ");
	Standofdata sod = (Standofdata) queryofstand.uniqueResult();
	
	    double dpt= sod.getSptime();
		double dtt= sod.getSttime();
		double drht= sod.getSrhtime();
		//设置标准
		String dp1=  sod.getSstandofp1() ;
		String dp2=  sod.getSstandofp2() ;
		String dp3=  sod.getSstandofp3() ;
		String dp4=  sod.getSstandofp4() ;
		String dp5=  sod.getSstandofp5() ;
		String dp6=  sod.getSstandofp6() ;
		String dp7=  sod.getSstandofp7() ;
		String dp8=  sod.getSstandofp8() ;
		String dp9=  sod.getSstandofp9() ;
		String dp10=  sod.getSstandofp10() ;
		String dp11=  sod.getSstandofp11() ;
		String dp12=  sod.getSstandofp12() ;
		String dp13=  sod.getSstandofp13() ;
		String dp14=  sod.getSstandofp14() ;
		String dp15=  sod.getSstandofp15() ;
		String dp16=  sod.getSstandofp16() ;
		String dp17=  sod.getSstandofp17() ;
		String dp18=  sod.getSstandofp18() ;
		String dp19=  sod.getSstandofp19() ;
		String dp20=  sod.getSstandofp20() ;
		String dp21=  sod.getSstandofp21() ;
		String dp22=  sod.getSstandofp22() ;
		String dp23=  sod.getSstandofp23() ;
		String dp24=  sod.getSstandofp24() ;
		String dp25=  sod.getSstandofp25() ;
		String dp26=  sod.getSstandofp26() ;
		String dp27=  sod.getSstandofp27() ;
		String dp28=  sod.getSstandofp28() ;
		//温度标准
		String dt=  sod.getSstandoft() ;
		//湿度标准
		String drh=  sod.getSstandofrh() ;
		if (ss != null) {
			ss.close();
		}
%>

<!DOCTYPE html>
<html>
<head>
<title>标准配置信息</title>
<link rel="stylesheet" type="text/css" href="../../js/framejs/jquery-easyui-1.3.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="../../js/framejs/jquery-easyui-1.3.2/themes/icon.css">
<link rel="stylesheet" type="text/css" href="../../js/framejs/jquery-easyui-1.3.2/demo/demo.css">
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/datagrid-detailview.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-easyui-1.3.2/locale/easyui-lang-zh_CN.js"></script>


<link href="../../css/bootstrap-combined.min.css" rel="stylesheet">
<script src="../../js/framejs/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="../../js/framejs/jquery-ui.js"></script>
<script type="text/javascript" src="../../js/myjs/standofdta.js"></script>
</head>

<body onload="init()" style="background-color:#FFFFF4">
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<form class="form-horizontal"
					action="http://172.16.10.165:8080/sss/servlet/ChangealarmInfo"
					method="post">
					<fieldset>
						<legend style="margin-left: 60px">系统配置信息 </legend>
						
						<div class="demo-info" style="margin-bottom:10px">
							<div class="demo-tip icon-tip">&nbsp;</div>
							<div>温馨提示：设置数据标准格式为：下限值+英文逗号+上限值</div>
						</div>
						
						<div class="control-group" style="margin-left:180px">
							<div class="controls" >
								<button id="changeInfoBtn" type="button" class="btn"
									onclick="chageInfoPressed()" style="float:left">修改</button>
								<button id="saveInfoBtn" type="submit" class="btn"
									style="margin-left: 110px">保存</button>
							</div>
						</div>
						
						<hr>
						<table border="0" style="margin-left: 10px">
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="DP">压差报警延时(分钟)：</label>
										<div class="controls">
											<input style="width:150px" id="DP" name="DP" type="text"
												value="<%=dpt %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="DR">湿度报警延时(分钟)：</label>
										<div class="controls">
											<input style="width:150px" id="DR" name="DR" type="text"
												value="<%=drht %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="DT">温度报警延时(分钟)：</label>
										<div class="controls">
											<input style="width:150px" id="DT" name="DT" type="text"
												value="<%=dtt %>" />
										</div>
									</div>
								</td>
							</tr>
							</table><hr>
							<table border="0" style="margin-left: 10px">
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P1">压差P1(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P1" name="P1" type="text" value="<%=dp1 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P2">压差P2(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P2" name="P2" type="text" value="<%=dp2 %>" /> 
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P3">压差P3(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P3" name="P3" type="text" value="<%=dp3 %>" /> 
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P4">压差P4(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P4" name="P4" type="text" value="<%=dp4 %>" /> 
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P5">压差P5(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P5" name="P5" type="text" value="<%=dp5 %>" /> 
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P6">压差P6(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P6" name="P6" type="text" value="<%=dp6 %>" /> 
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P7">压差P7(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P7" name="P7" type="text" value="<%=dp7 %>" /> 
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P8">压差P8(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P8" name="P8" type="text" value="<%=dp8 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P9">压差P9(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P9" name="P9" type="text" value="<%=dp9 %>" /> 
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P10">压差P10(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P10" name="P10" type="text" value="<%=dp10 %>" /> 
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P11">压差P11(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P11" name="P11" type="text" value="<%=dp11 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P12">压差P12(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P12" name="P12" type="text" value="<%=dp12 %>" /> 
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P13">压差P13(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P13" name="P13" type="text" value="<%=dp13 %>" /> 
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P14">压差P14(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P14" name="P14" type="text" value="<%=dp14 %>" /> 
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P15">压差P15(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P15" name="P15" type="text" value="<%=dp15 %>" /> 
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P16">压差P16(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P16" name="P16" type="text" value="<%=dp16 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P17">压差P17(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P17" name="P17" type="text" value="<%=dp17 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P18">压差P18(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P18" name="P18" type="text" value="<%=dp18 %>" />
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P19">压差P19(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P19" name="P19" type="text" value="<%=dp19 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P20">压差P20(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P20" name="P20" type="text" value="<%=dp20 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P21">压差P21(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P21" name="P21" type="text" value="<%=dp21 %>" />
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P22">压差P22(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P22" name="P22" type="text" value="<%=dp22 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P23">压差P23(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P23" name="P23" type="text" value="<%=dp23 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P24">压差P24(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P24" name="P24" type="text" value="<%=dp24 %>" />
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P25">压差P25(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P25" name="P25" type="text" value="<%=dp25 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P26">压差P26(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P26" name="P26" type="text" value="<%=dp26 %>" />
										</div>
									</div>
								</td>
								<td>
									<div class="control-group">
										<label class="control-label" for="P27">压差P27(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P27" name="P27" type="text" value="<%=dp27 %>" />
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<div class="control-group">
										<label class="control-label" for="P28">压差P28(Pa)：</label>
										<div class="controls">
											<input style="width:150px" id="P28" name="P28" type="text" value="<%=dp28 %>" />
										</div>
									</div>
								</td>
								<td></td>
								<td></td>
							</tr>
							</table><hr>
							<table border="0" style="margin-left: 10px">
							<tr>
								<td> 
									<div class="control-group">
									<label class="control-label" for="T">温度T(℃ )：</label>
									<div class="controls">
										<input style="width:150px" id="t" name="TL" type="text" value="<%=dt %>" /> 
									</div>
								</div>
								</td>
							</tr>
							</table><hr>
							<table border="0" style="margin-left: 10px">
							<tr>
								<td> 
									<div class="control-group">
									<label class="control-label" for="T">湿度RH(%)：</label>
									<div class="controls">
										<input style="width:150px" id="rh" name="RH" type="text" value="<%=drh %>" />
									</div>
								</div>
								</td>
							</tr>
						</table>

						
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
