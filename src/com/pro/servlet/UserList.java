package com.pro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pro.entity.User;
import com.pro.utils.HibernateSessionFactory;
import com.pro.utils.JsonTools;


public class UserList extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserList() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/x-json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Map<String, Object>  params =  new HashMap<String, Object>();
		List<Map<String, Object>> datalist = new ArrayList<Map<String, Object>>();
	    Session s = HibernateSessionFactory.getSession();;
	    String resultJSONString = "";
	    String hql = "from User";
	    Query query=s.createQuery(hql);
	    List<User> list = query.list();
	    for(int i=0;i<list.size();i++){
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("id", list.get(i).getUid());
	    	map.put("username",list.get(i).getUusername());
	    	if(list.get(i).getUrole().equals("3")){
	    		map.put("role", "审核员");
	    	}else if(list.get(i).getUrole().equals("2")){
	    		map.put("role", "管理员");
	    	}else if(list.get(i).getUrole().equals("1")){
	    		map.put("role", "游客");
	    	}
	    	datalist.add(map);
	    }
		    params.put("rows", datalist);
			resultJSONString = JsonTools.createJsonString(params);
			out.println(resultJSONString);
			System.out.println(resultJSONString);
			if (s != null) {

				s.close();
			}
			out.flush();
			out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
