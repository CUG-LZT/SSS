package com.pro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import org.hibernate.Query;
import org.hibernate.Session;

import com.pro.entity.Dataofmonitor;
import com.pro.utils.HibernateSessionFactory;
import com.pro.utils.JsonTools;


public class Getlampdata extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Getlampdata() {
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
		java.util.Date javaDate = new java.util.Date();
		
		long javaTime = javaDate.getTime() - 180 * 1000 ;
		java.sql.Timestamp time = new java.sql.Timestamp(javaTime);
		Session s = null;
		String hql1 = "from Dataofmonitor where dtime>'" + time + "' order by did desc";
		s = HibernateSessionFactory.getSession();
		
		Query query1 = s.createQuery(hql1);
		List<Dataofmonitor> list1 = query1.list();
		
		List<Integer> params = new ArrayList<Integer>();
		
		Map<String, Object> paramsofend = new HashMap<String, Object>();
		int sunofled = 0;
		if (list1.size() > 0) {
			Dataofmonitor data = list1.get(0);
			params.add(data.getDlamp1());
			params.add(data.getDlamp2());
			params.add(data.getDlamp3());
			params.add(data.getDlamp4());
			params.add(data.getDlamp5());
			params.add(data.getDlamp6());
			params.add(data.getDlamp7());
			params.add(data.getDlamp8());
			params.add(data.getDlamp9());
			params.add(data.getDlamp10());
		}
		for (Integer integer : params) {
			if(integer > 0 && integer <=10 )
				sunofled++;
		}
		
		if(sunofled == 0)
			paramsofend.put("sum", 1);
		else
			paramsofend.put("sum", 0);
		paramsofend.put("da", params);
		JSONObject jsonObject = JSONObject.fromObject(paramsofend);
		out.println(jsonObject);
		
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
