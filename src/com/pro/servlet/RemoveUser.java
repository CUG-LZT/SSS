package com.pro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.hibernate.Session;

import com.pro.entity.User;
import com.pro.utils.HibernateSessionFactory;


public class RemoveUser extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RemoveUser() {
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
        Session session =null;
        try
        {
           session= HibernateSessionFactory.getSession();
           //开启事务.
           session.beginTransaction();
           //采用load查询不存在的数据,hibernate会抛出object not found exception
           User user = (User)session.load(User.class,Integer.valueOf(request.getParameter("id")));
           //删除表中的记录.
           session.delete(user);
           //提交事务.把内存的改变提交到数据库上.
           session.getTransaction().commit();
           
        }catch(Exception e){
           e.printStackTrace();
           session.getTransaction().rollback();
        }finally{
        	if(session  != null){
        		session.close();
        	}
        }
        params.put("flag", "1");
	    System.out.println(params);
        JSONObject jsonObject = JSONObject.fromObject(params);
        out.println(jsonObject);
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
