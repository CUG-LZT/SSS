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

import net.sf.json.JSONArray;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pro.entity.Dataofmonitor;
import com.pro.utils.HibernateSessionFactory;
import com.pro.utils.JsonTools;

public class Getdataoflamp extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Getdataoflamp() {
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
		String resultJSONString = "";
		long javaTime = javaDate.getTime() - 180 * 1000 ;
		java.sql.Timestamp time = new java.sql.Timestamp(javaTime);
		Session s = null;
		String hql1 = "from Dataofmonitor where dtime>'" + time + "' order by did desc";
		s = HibernateSessionFactory.getSession();
		
		Query query1 = s.createQuery(hql1);
		List<Dataofmonitor> list = query1.list();
		List<Map<String, Object>> datalist = new ArrayList<Map<String, Object>>();
		Map<String, Object> params = new HashMap<String, Object>();
		
		//List<Integer> data = new ArrayList<Integer>();
		//data.add(list.get(0).getDlamp1());
		//未获取到数据的话
		if(list.size()>0){
			int[] data = {list.get(0).getDlamp1(),
					list.get(0).getDlamp2(),
					list.get(0).getDlamp3(),
					list.get(0).getDlamp4(),
					list.get(0).getDlamp5(),
					list.get(0).getDlamp6(),
					list.get(0).getDlamp7(),
					list.get(0).getDlamp8(),
					list.get(0).getDlamp9(),
					list.get(0).getDlamp10()};
			
			for(int i=0;i<10;i++){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", i+1);
				map.put("number", (i+11)+"号手术室");
				if(data[i] == 1)
					map.put("status", "锁定");
				else if(data[i] == 0)
					map.put("status", "未锁定");
				else if(data[i] == 10)
					map.put("status", "正在解锁");
				else if(data[i] == 11)
					map.put("status", "正在锁定");
				datalist.add(map);
			}
		}
		resultJSONString = JsonTools.createJsonString(datalist);
		out.println(resultJSONString);
		
		if (s != null) {
			s.close();
		}
		out.flush();
		out.close();
//----------------
		
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
