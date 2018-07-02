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

import com.pro.entity.Dataofmonitor;
import com.pro.utils.HibernateSessionFactory;
import com.pro.utils.JsonTools;

public class Tableofhistorydataoft extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Tableofhistorydataoft() {
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
		//获取参数
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		//获取分页参数
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		
		PrintWriter out = response.getWriter();
		Map<String, Object>  params =  new HashMap<String, Object>();
		List<Map<String, Object>> datalist = new ArrayList<Map<String, Object>>();
	    Session s = null;
	    String resultJSONString = "";
	    
	    String hql = "from Dataofmonitor where dtime between '"+start_time+"' and '"+end_time+"' order by dtime";
	    String pagesql = "select count(*) from Dataofmonitor  where dtime between '"+start_time+"' and '"+end_time+"' order by dtime";
	    s = HibernateSessionFactory.getSession();
	    Query query = s.createQuery(hql);
	    Query pagequery = s.createQuery(pagesql);
	    //获取总共多条记录
	    int tollpage = ((Number)pagequery.uniqueResult()).intValue();
	    
	    //
		@SuppressWarnings("unchecked")
		List<Dataofmonitor> list = query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
	    for(int i=0;i<list.size();i++){
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("time", list.get(i).getDtime().toString());
	    	map.put("t1",list.get(i).getDt1());
	    	map.put("t2",list.get(i).getDt2());
	    	map.put("t3",list.get(i).getDt3());
	    	map.put("t4",list.get(i).getDt4());
	    	map.put("t5",list.get(i).getDt5());
	    	map.put("t6",list.get(i).getDt6());
	    	map.put("t7",list.get(i).getDt7());
	    	map.put("t8",list.get(i).getDt8());
	    	map.put("t9",list.get(i).getDt9());
	    	map.put("t10",list.get(i).getDt10());
	    	datalist.add(map);
	    }
	    params.put("total", tollpage);
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
