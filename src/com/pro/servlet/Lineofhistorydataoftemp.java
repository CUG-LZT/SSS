package com.pro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pro.utils.HibernateSessionFactory;

public class Lineofhistorydataoftemp extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Lineofhistorydataoftemp() {
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
		// 获取参数
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String streamstr = request.getParameter("stream");
		int stream = Integer.valueOf(streamstr);

		System.out.println(start_time + "--" + end_time + "--" + start_time);
		PrintWriter out = response.getWriter();
		Map<String, Object> params = new HashMap<String, Object>();
		String select = "dt" + streamstr;
		
		String hqldata = "select " + select
				+ " from Dataofmonitor where dtime between '" + start_time
				+ "' and '" + end_time + "'";
		String hqltime = "select dtime from Dataofmonitor where dtime between '"
				+ start_time + "' and '" + end_time + "'";
		
		Session s = HibernateSessionFactory.getSession();
		Query querydata = s.createQuery(hqldata);
		Query querytime = s.createQuery(hqltime);
		List<Double> list = querydata.list();
		List<Timestamp> time = querytime.list();
		List<String> timestr = new ArrayList<String>();
		for (int i = 0; i < time.size(); i++) {
			timestr.add(time.get(i).toString().substring(0, 19));
		}
		params.put("date", timestr);
		params.put("p", list);
		JSONObject jsonObject = JSONObject.fromObject(params);
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
