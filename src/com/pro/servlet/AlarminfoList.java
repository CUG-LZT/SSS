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

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import com.pro.entity.Alarm;
import com.pro.entity.Dataofmonitor;
import com.pro.entity.User;
import com.pro.utils.HibernateSessionFactory;
import com.pro.utils.JsonTools;

public class AlarminfoList extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AlarminfoList() {
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
		
		String mudi = request.getParameter("mudi");
		
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String resultJSONString = "";
		if(!StringUtils.isEmpty(start_time) && !StringUtils.isEmpty(end_time)){
			//获取分页参数
			String _page = request.getParameter("page");
			String _rows = request.getParameter("rows");
			
			int page = Integer.parseInt(request.getParameter("page"));
			int rows = Integer.parseInt(request.getParameter("rows"));
			
			Map<String, Object>  params =  new HashMap<String, Object>();
			List<Map<String, Object>> datalist = new ArrayList<Map<String, Object>>();
		    Session s = HibernateSessionFactory.getSession();;
		    String hql ="";
		    if(mudi.endsWith("0")){
		    	 hql = "from Alarm  where astime > '" + start_time + "' and astime < '"+end_time+"' order by astime";
			}else if(mudi.endsWith("1")){
				 hql = "from Alarm  where aisdeal = '1' and astime > '" + start_time + "' and astime < '"+end_time+"' order by astime";
			}else{
				 hql = "from Alarm  where aisdeal > '0' and astime > '" + start_time + "' and astime < '"+end_time+"' order by astime";
			}
		    
		    String pagesql = "select count(*) from Alarm  where astime > '" + start_time + "' and astime < '"+end_time+"' order by astime";
		    
		    Query query=s.createQuery(hql);
		    //List<Alarm> list = query.list();
		    Query pagequery = s.createQuery(pagesql);
		    //获取总共多条记录
		    int tollpage = ((Number)pagequery.uniqueResult()).intValue();
		    
		    List<Alarm> list = query.setFirstResult((page-1)*rows).setMaxResults(rows).list();
		    
		    for(int i=0;i<list.size();i++){
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	map.put("id", list.get(i).getAid());
		    	map.put("starttime", list.get(i).getAstime().toString());
		    	map.put("endtime", list.get(i).getAetime().toString());
		    	map.put("location", list.get(i).getAlocation());
		    	map.put("detail", list.get(i).getAdetail());
		    	map.put("statues", list.get(i).getAstatues());
		    	map.put("type", list.get(i).getAtype());
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
		}else{
			Map<String, Object>  params =  new HashMap<String, Object>();
			List<Map<String, Object>> datalist = new ArrayList<Map<String, Object>>();
			params.put("total", 0);
		    params.put("rows", datalist);
		    resultJSONString = JsonTools.createJsonString(params);
			out.println(resultJSONString);
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
