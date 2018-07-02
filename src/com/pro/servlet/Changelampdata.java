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
import com.pro.utils.LampofSave;

public class Changelampdata extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Changelampdata() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/x-json");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String[] dataoflam = request.getParameterValues("data");// 获取数组使用该函数
		PrintWriter out = response.getWriter();
		java.util.Date javaDate = new java.util.Date();

		long javaTime = javaDate.getTime() - 180 * 1000;
		java.sql.Timestamp time = new java.sql.Timestamp(javaTime);
		Session s = null;
		String hql1 = "from Dataofmonitor where dtime>'" + time
				+ "' order by dtime desc";
		s = HibernateSessionFactory.getSession();

		Query query1 = s.createQuery(hql1);
		List<Dataofmonitor> list1 = query1.list();
		List<Integer> params = new ArrayList<Integer>();
		Map<String, Object> param = new HashMap<String, Object>();
		List<Integer> lock = new ArrayList<Integer>();
		List<Integer> unlk = new ArrayList<Integer>();
		List<String> _str = new ArrayList<String>();
		_str.add("info");
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

			for (int i = 0; i < params.size(); i++) {
				int res = Integer.parseInt(dataoflam[i]) - params.get(i);
				if (res > 0) {
					lock.add(i + 11);
				} else if (res < 0) {
					unlk.add(i + 11);
				}
			}
			if ((lock.size() > 0 && unlk.size() > 0)) {
				_str.set(0, "不可同时锁定、解锁！！！");
			}else if ((lock.size() == 0 && unlk.size() == 0)) {
				_str.set(0, "未选择数据！！！");
			}else{
				if (lock.size() > 0) {
					LampofSave.islock = 1;
					param.put("lock", lock);
					LampofSave.getdata(param);
				}
				if (unlk.size() > 0) {
					LampofSave.isunlk = 1;
					param.put("unlk", unlk);
					LampofSave.getdata(param);
				}
				_str.set(0, "请等待1-2分钟数据回传！！");
			}
			
		} else
			_str.set(0, "数据通讯异常！无法获取初始状态！");
		JSONArray JSONarray = JSONArray.fromObject(_str);
		out.println(JSONarray);
		if (s != null) {
			s.close();
		}
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
