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

import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pro.entity.Dataofmonitor;
import com.pro.utils.HibernateSessionFactory;

public class Rhofonetofive extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Rhofonetofive() {
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
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String str = request.getParameter("oneorsix");
	    java.util.Date javaDate = new java.util.Date();
	    long javaTime = javaDate.getTime()-1800*1000;
	    java.sql.Timestamp starttime = new java.sql.Timestamp(javaTime);
	    java.sql.Timestamp endtime = new java.sql.Timestamp(javaDate.getTime());
	    Session s = null;
	    String hql = "from Dataofmonitor where dtime>='"+starttime+"' and dtime <'"+endtime+"'";
	    s = HibernateSessionFactory.getSession();
	    Query query = s.createQuery(hql);
	    List<String> date = new ArrayList<String>();
	    List<Dataofmonitor> list = query.list(); 
	    Map<String, Object>  params =  new HashMap<String, Object>();
	    Dataofmonitor dom = new Dataofmonitor();
	    List<Double> rh1 = new ArrayList<Double>();
		List<Double> rh2 = new ArrayList<Double>();
		List<Double> rh3 = new ArrayList<Double>();
		List<Double> rh4 = new ArrayList<Double>();
		List<Double> rh5 = new ArrayList<Double>();
		
		if("one".equals(str)){
			System.out.println("one"+str);
		    for (Dataofmonitor dataofmonitor : list) {
		    	date.add(dataofmonitor.getDtime().toString().substring(0, 19));
		    	rh1.add(dataofmonitor.getDrh1());
		    	rh2.add(dataofmonitor.getDrh2());
		    	rh3.add(dataofmonitor.getDrh3());
		    	rh4.add(dataofmonitor.getDrh4());
		    	rh5.add(dataofmonitor.getDrh5());
			}
	    }else{
	    	System.out.println("six"+str);
	    	for (Dataofmonitor dataofmonitor : list) {
		    	date.add(dataofmonitor.getDtime().toString().substring(0, 19));
		    	rh1.add(dataofmonitor.getDrh6());
		    	rh2.add(dataofmonitor.getDrh7());
		    	rh3.add(dataofmonitor.getDrh8());
		    	rh4.add(dataofmonitor.getDrh9());
		    	rh5.add(dataofmonitor.getDrh10());
			}
	    }
		
		params.put("time",date);
	    params.put("num", rh1);
	    params.put("num1", rh2);
	    params.put("num2", rh3);
	    params.put("num3", rh4);
	    params.put("num4", rh5);
	    
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
