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

public class Pofonetomuch extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Pofonetomuch() {
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
		String str = request.getParameter("number");
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
	    List<Double> p1 = new ArrayList<Double>();
		List<Double> p2 = new ArrayList<Double>();
		List<Double> p3 = new ArrayList<Double>();
		List<Double> p4 = new ArrayList<Double>();
		List<Double> p5 = new ArrayList<Double>();
		
		if("1".equals(str)){
		    for (Dataofmonitor dataofmonitor : list) {
		    	date.add(dataofmonitor.getDtime().toString().substring(0, 19));
		    	p1.add(dataofmonitor.getDp1());
		    	p2.add(dataofmonitor.getDp2());
		    	p3.add(dataofmonitor.getDp3());
		    	p4.add(dataofmonitor.getDp4());
		    	p5.add(dataofmonitor.getDp5());
			}
	    }else if("6".equals(str)){
	    	for (Dataofmonitor dataofmonitor : list) {
		    	date.add(dataofmonitor.getDtime().toString().substring(0, 19));
		    	p1.add(dataofmonitor.getDp6());
		    	p2.add(dataofmonitor.getDp7());
		    	p3.add(dataofmonitor.getDp8());
		    	p4.add(dataofmonitor.getDp9());
		    	p5.add(dataofmonitor.getDp10());
			}
	    }else if("11".equals(str)){
	    	for (Dataofmonitor dataofmonitor : list) {
		    	date.add(dataofmonitor.getDtime().toString().substring(0, 19));
		    	p1.add(dataofmonitor.getDp11());
		    	p2.add(dataofmonitor.getDp12());
		    	p3.add(dataofmonitor.getDp13());
		    	p4.add(dataofmonitor.getDp14());
		    	p5.add(dataofmonitor.getDp15());
			}
	    }else if("16".equals(str)){
	    	for (Dataofmonitor dataofmonitor : list) {
		    	date.add(dataofmonitor.getDtime().toString().substring(0, 19));
		    	p1.add(dataofmonitor.getDp16());
		    	p2.add(dataofmonitor.getDp17());
		    	p3.add(dataofmonitor.getDp18());
		    	p4.add(dataofmonitor.getDp19());
		    	p5.add(dataofmonitor.getDp20());
			}
	    }else if("21".equals(str)){
	    	for (Dataofmonitor dataofmonitor : list) {
		    	date.add(dataofmonitor.getDtime().toString().substring(0, 19));
		    	p1.add(dataofmonitor.getDp21());
		    	p2.add(dataofmonitor.getDp22());
		    	p3.add(dataofmonitor.getDp23());
		    	p4.add(dataofmonitor.getDp24());
		    	p5.add(dataofmonitor.getDp25());
			}
	    }else if("26".equals(str)){
	    	for (Dataofmonitor dataofmonitor : list) {
		    	date.add(dataofmonitor.getDtime().toString().substring(0, 19));
		    	p1.add(dataofmonitor.getDp26());
		    	p2.add(dataofmonitor.getDp27());
		    	p3.add(dataofmonitor.getDp28());
			}
	    }
		//--------------------------------
		if(!"26".equals(str)){
			params.put("time",date);
		    params.put("num", p1);
		    params.put("num1", p2);
		    params.put("num2", p3);
		    params.put("num3", p4);
		    params.put("num4", p5);
	    }else{
	    	params.put("time",date);
		    params.put("num", p1);
		    params.put("num1", p2);
		    params.put("num2", p3);
	    }
	    
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
