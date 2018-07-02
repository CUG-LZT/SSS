<%@page import="com.pro.entity.*"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.pro.utils.*"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>

<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	// 从表单获取username和password的值
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	if(username == null && password==null){
		response.sendRedirect("login.jsp");
		out.clear();
		out = pageContext.pushBody();
	}else{
		// 从数据库里面查找和username相等的数据
	 	Session ss = HibernateSessionFactory.getSession();
		Query query = ss.createQuery("from User u where u.uusername='" + username + "'");
		User user = (User)query.uniqueResult(); 
		String role = user.getUrole();
	
	//获取未处理的报告单条数
	Query querycount = ss.createQuery("select count(*) from Alarm r where r.aisdeal='" + 1 + "'");
	session.setAttribute("nodeal", querycount.uniqueResult());
	
	//登录业务处理
	if (user != null && password.equals(user.getUpassword())) {
		//如果账号密码正确。将标准存在session中。
		session.setAttribute("username", username);
		session.setAttribute("role", role);
		session.setAttribute("password", password);
		
		// 权限划分 ；请求重定向
		if(role.equals("3")){
			session.setAttribute("roleofdisplay", "审核员");
		}
		else if(role.equals("2")){
			session.setAttribute("roleofdisplay", "管理员");
		}
		else if(role.equals("1")){
			session.setAttribute("roleofdisplay", "访客");
		}
		response.sendRedirect("page/homepage.jsp");
		out.clear();
		out = pageContext.pushBody();
		
	} else {
		// 请求重定向
		response.sendRedirect("login.jsp");
		out.clear();
		out = pageContext.pushBody();
	}
 	if (ss != null) {
			ss.close();
		} 
		}
%>





