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
import org.hibernate.Transaction;

import com.pro.entity.Dataofmonitor;
import com.pro.entity.Standofdata;
import com.pro.utils.HibernateSessionFactory;
import com.pro.utils.IsStandChange;
import com.pro.utils.LampofSave;

public class Dochangelampdata extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Dochangelampdata() {
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
		String[] ids = request.getParameterValues("ids");// 获取数组使用该函数
		String op = request.getParameter("op");
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		
		java.util.Date javaDate = new java.util.Date();
		long javaTime = javaDate.getTime() - 180 * 1000 ;
		java.sql.Timestamp time = new java.sql.Timestamp(javaTime);
		
		PrintWriter out = response.getWriter();
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		List<String> _str = new ArrayList<String>();
		_str.add("info");
		
		Query queryofsod = session.createQuery("from Dataofmonitor where dtime>'" + time + "' order by did desc");
		List<Dataofmonitor> list = queryofsod.list();
		//获取修改之前的状态
		int[] olddat = {list.get(0).getDlamp1() , list.get(0).getDlamp2(), list.get(0).getDlamp3(), list.get(0).getDlamp4(), list.get(0).getDlamp5()
				, list.get(0).getDlamp6(), list.get(0).getDlamp7(), list.get(0).getDlamp8(), list.get(0).getDlamp9(), list.get(0).getDlamp10()};
		
		List<Integer> lock = new ArrayList<Integer>();
		List<Integer> unlk = new ArrayList<Integer>();
		
		if(op.equals("lock")){
			//修改数据
			if(list.size() > 0){
				Dataofmonitor dom = list.get(0);
				for(int i = 0 ; i < 10; i++ ){       //10次循环判断是否10个数据都需要修改
					int sum = 0;
					for (int j = 0; j < ids.length; j++) {  //每一次都与前端穿过的数据比对看是否有和前台传过来的ID相等的，相等就是要锁定的
						if(i == (Integer.parseInt(ids[j])-1)) //传过来的数据是从1开始的需要减去1
							sum++;
					}
					if(sum > 0){
						olddat[i] = 11;             
						lock.add(i+11);//为了传递过去直接发送指令，锁几号房间
					}
				}
				
				//获得修改之后的状态
				dom.setDlamp1(olddat[0]);
				dom.setDlamp2(olddat[1]);
				dom.setDlamp3(olddat[2]);
				dom.setDlamp4(olddat[3]);
				dom.setDlamp5(olddat[4]);
				dom.setDlamp6(olddat[5]);
				dom.setDlamp7(olddat[6]);
				dom.setDlamp8(olddat[7]);
				dom.setDlamp9(olddat[8]);
				dom.setDlamp10(olddat[9]);
				session.save(dom);
				transaction.commit();
				//设置发送指令
				LampofSave.islock = 1;
				param.put("lock", lock);
				LampofSave.getdata(param);
				_str.set(0, "锁定指令发送成功，请等待...！");
			}else{
				_str.set(0, "获取原始状态失败！");
			}
		}else if(op.equals("unlk")){
			if(list.size() > 0){
				Dataofmonitor dom = list.get(0);
				for(int i = 0 ; i < 10; i++ ){       //10次循环判断是否10个数据都需要修改
					int sum = 0;
					for (int j = 0; j < ids.length; j++) {  //每一次都与前端穿过的数据比对看是否有和前台传过来的ID相等的，相等就是要锁定的
						if(i == (Integer.parseInt(ids[j])-1)) //传过来的数据是从1开始的需要减去1
							sum++;
					}
					if(sum > 0){
						olddat[i] = 10;             
						unlk.add(i+11);//为了传递过去直接发送指令，锁几号房间
					}
				}
				
				//获得修改之后的状态
				dom.setDlamp1(olddat[0]);
				dom.setDlamp2(olddat[1]);
				dom.setDlamp3(olddat[2]);
				dom.setDlamp4(olddat[3]);
				dom.setDlamp5(olddat[4]);
				dom.setDlamp6(olddat[5]);
				dom.setDlamp7(olddat[6]);
				dom.setDlamp8(olddat[7]);
				dom.setDlamp9(olddat[8]);
				dom.setDlamp10(olddat[9]);
				session.save(dom);
				transaction.commit();
				//设置发送指令
				LampofSave.isunlk = 1;
				param.put("unlk", unlk);
				LampofSave.getdata(param);
				_str.set(0, "解锁指令发送成功，请等待...！");
			}else{
				_str.set(0, "获取原始状态失败！");
			}
		}else{
			_str.set(0, "参数异常");
		}

		JSONArray JSONarray = JSONArray.fromObject(_str);
		out.println(JSONarray);
		if (session != null) {
			session.close();
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
