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
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mysql.fabric.xmlrpc.base.Array;
import com.pro.entity.Dataofmonitor;
import com.pro.entity.Standofdata;
import com.pro.utils.AlarminfoSave;
import com.pro.utils.HibernateSessionFactory;


public class GetDatatomap extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetDatatomap() {
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
		
		long javaTime = javaDate.getTime() - 180 * 1000 ;//--------------------------
		java.sql.Timestamp time = new java.sql.Timestamp(javaTime);
		HttpSession session = request.getSession();
		Session s = null;
		String hql1 = "from Dataofmonitor where dtime>'" + time + "' order by dtime desc";
		s = HibernateSessionFactory.getSession();
		Query query1 = s.createQuery(hql1);
		List<Dataofmonitor> ldom = new ArrayList<Dataofmonitor>();
		ldom = query1.list();
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> params_stand = new HashMap<String, Object>();
		if(ldom.size() > 0){
			Dataofmonitor dom = ldom.get(0);
			//获取每一个值，并存在MAP中
			params.put("p1", dom.getDp1());
			params.put("p2", dom.getDp2());
			params.put("p3", dom.getDp3());
			params.put("p4", dom.getDp4());
			params.put("p5", dom.getDp5());
			params.put("p6", dom.getDp6());
			params.put("p7", dom.getDp7());
			params.put("p8", dom.getDp8());
			params.put("p9", dom.getDp9());
			params.put("p10", dom.getDp10());
			params.put("p11", dom.getDp11());
			params.put("p12", dom.getDp12());
			params.put("p13", dom.getDp13());
			params.put("p14", dom.getDp14());
			params.put("p15", dom.getDp15());
			params.put("p16", dom.getDp16());
			params.put("p17", dom.getDp17());
			params.put("p18", dom.getDp18());
			params.put("p19", dom.getDp19());
			params.put("p20", dom.getDp20());	
			params.put("p21", dom.getDp21());	
			params.put("p22", dom.getDp22());	
			params.put("p23", dom.getDp23());	
			params.put("p24", dom.getDp24());	
			params.put("p25", dom.getDp25());	
			params.put("p26", dom.getDp26());	
			params.put("p27", dom.getDp27());	
			params.put("p28", dom.getDp28());	
			//----
			params.put("t1", dom.getDt1());
			params.put("t2", dom.getDt2());
			params.put("t3", dom.getDt3());
			params.put("t4", dom.getDt4());
			params.put("t5", dom.getDt5());
			params.put("t6", dom.getDt6());
			params.put("t7", dom.getDt7());
			params.put("t8", dom.getDt8());
			params.put("t9", dom.getDt9());
			params.put("t10", dom.getDt10());
			//----
			params.put("rh1", dom.getDrh1());
			params.put("rh2", dom.getDrh2());
			params.put("rh3", dom.getDrh3());
			params.put("rh4", dom.getDrh4());
			params.put("rh5", dom.getDrh5());
			params.put("rh6", dom.getDrh6());
			params.put("rh7", dom.getDrh7());
			params.put("rh8", dom.getDrh8());
			params.put("rh9", dom.getDrh9());
			params.put("rh10", dom.getDrh10());
			//----

			//---------------------------------------------------------------
			//判断每一个值是否在规定值内，1代表正常，并把每一个值的状态存在MAP中
			//params_stand列表存放标准
			Query queryofstand = s.createQuery("from Standofdata ");
			Standofdata sod = (Standofdata) queryofstand.uniqueResult();
			params_stand.put("dp1", Double.parseDouble(sod.getSstandofp1().split(",")[1]));
			params_stand.put("dp2", Double.parseDouble(sod.getSstandofp2().split(",")[1]));
			params_stand.put("dp3", Double.parseDouble(sod.getSstandofp3().split(",")[1]));
			params_stand.put("dp4", Double.parseDouble(sod.getSstandofp4().split(",")[1]));
			params_stand.put("dp5", Double.parseDouble(sod.getSstandofp5().split(",")[1]));
			params_stand.put("dp6", Double.parseDouble(sod.getSstandofp6().split(",")[1]));
			params_stand.put("dp7", Double.parseDouble(sod.getSstandofp7().split(",")[1]));
			params_stand.put("dp8", Double.parseDouble(sod.getSstandofp8().split(",")[1]));
			params_stand.put("dp9", Double.parseDouble(sod.getSstandofp9().split(",")[1]));
			params_stand.put("dp10", Double.parseDouble(sod.getSstandofp10().split(",")[1]));
			params_stand.put("dp11", Double.parseDouble(sod.getSstandofp11().split(",")[1]));
			params_stand.put("dp12", Double.parseDouble(sod.getSstandofp12().split(",")[1]));
			params_stand.put("dp13", Double.parseDouble(sod.getSstandofp13().split(",")[1]));
			params_stand.put("dp14", Double.parseDouble(sod.getSstandofp14().split(",")[1]));
			params_stand.put("dp15", Double.parseDouble(sod.getSstandofp15().split(",")[1]));
			params_stand.put("dp16", Double.parseDouble(sod.getSstandofp16().split(",")[1]));
			params_stand.put("dp17", Double.parseDouble(sod.getSstandofp17().split(",")[1]));
			params_stand.put("dp18", Double.parseDouble(sod.getSstandofp18().split(",")[1]));
			
			params_stand.put("dp19l", Double.parseDouble(sod.getSstandofp19().split(",")[0]));
			params_stand.put("dp20l", Double.parseDouble(sod.getSstandofp20().split(",")[0]));	
			params_stand.put("dp21l", Double.parseDouble(sod.getSstandofp21().split(",")[0]));	
			params_stand.put("dp22l", Double.parseDouble(sod.getSstandofp22().split(",")[0]));	
			params_stand.put("dp23l", Double.parseDouble(sod.getSstandofp23().split(",")[0]));	
			params_stand.put("dp24l", Double.parseDouble(sod.getSstandofp24().split(",")[0]));
			
			params_stand.put("dp19h", Double.parseDouble(sod.getSstandofp19().split(",")[1]));
			params_stand.put("dp20h", Double.parseDouble(sod.getSstandofp20().split(",")[1]));	
			params_stand.put("dp21h", Double.parseDouble(sod.getSstandofp21().split(",")[1]));	
			params_stand.put("dp22h", Double.parseDouble(sod.getSstandofp22().split(",")[1]));	
			params_stand.put("dp23h", Double.parseDouble(sod.getSstandofp23().split(",")[1]));	
			params_stand.put("dp24h", Double.parseDouble(sod.getSstandofp24().split(",")[1]));
			
			params_stand.put("dp25", Double.parseDouble(sod.getSstandofp25().split(",")[1]));	
			params_stand.put("dp26", Double.parseDouble(sod.getSstandofp26().split(",")[1]));	
			params_stand.put("dp27", Double.parseDouble(sod.getSstandofp27().split(",")[1]));	
			params_stand.put("dp28", Double.parseDouble(sod.getSstandofp28().split(",")[1]));
			
			params_stand.put("dtl", Double.parseDouble(sod.getSstandoft().split(",")[0]));
			params_stand.put("dth", Double.parseDouble(sod.getSstandoft().split(",")[1]));
			
			params_stand.put("drhl", Double.parseDouble(sod.getSstandofrh().split(",")[0]));
			params_stand.put("drhh", Double.parseDouble(sod.getSstandofrh().split(",")[1]));
			
			//-------------------------------------------------------------------------
			for(int i = 1 ; i <= 28 ; i++){
				if(i >= 19 && i <= 24){//正负气压 大于大的 小于小的
					if((double)params.get("p"+i) >= (double)params_stand.get("dp"+i+"h") || (double)params.get("p"+i) <= (double)params_stand.get("dp"+i+"l")){
						params.put("p"+i+"c", 1);
					}else{
						params.put("p"+i+"c", 0);
					}
				}else{
					if((double)params.get("p"+i) <= (double)params_stand.get("dp"+i) && (double)params.get("p"+i) > 0.0){
						params.put("p"+i+"c", 1);
					}else{
						params.put("p"+i+"c", 0);
					}
				}
			}

			
			//依次判断温度是否都在范围内 并赋予标志位
			for(int i = 1 ; i <= 10 ; i++){
				if((double)params.get("t"+i) <= (double)params_stand.get("dth") && (double)params.get("t"+i) >= (double)params_stand.get("dtl")){
					params.put("t"+i+"c", 1);
				}else{
					params.put("t"+i+"c", 0);
				}
			}
			//依次判断湿度是否都在范围内 并赋予标志位
			for(int i = 1 ; i <= 10 ; i++){
				if((double)params.get("rh"+i) <= (double)params_stand.get("drhh") && (double)params.get("rh"+i) >= (double)params_stand.get("drhl")){
					params.put("rh"+i+"c", 1);
				}else{
					params.put("rh"+i+"c", 0);
				}
			}
			//查看三种数据标志位，都正常 说明都有数据上传 --数据通讯正常
			if(AlarminfoSave.alarmofpressofid == -1 && AlarminfoSave.alarmoftempofid == -1 && AlarminfoSave.alarmofrhofid == -1) {
				params.put("c", 1);
			} else {
				params.put("c", 0);
			}
			
			//获取各个气压的标志位，统计不是-1的个数，大于0 说明有气压数据异常
			int sunofp = 0 ;
			for(int i = 0 ; i < 28 ; i++){
				if(AlarminfoSave.idofp[i] != -1)
					sunofp++;
			}
			if(sunofp > 0){
				params.put("p", 0);       //红色
			}else if(AlarminfoSave.warningofpressofid == 1){  //一半的时间内有异常的  黄色
				params.put("p", 2);
			}else{
				params.put("p", 1);            //都没有 绿色
			}
			//获取各个温度的标志位，统计不是-1的个数，大于0 说明有温度数据异常
			int sunoft = 0 ;
			for(int i = 0 ; i < 10 ; i++){
				if(AlarminfoSave.idoft[i] != -1)
					sunoft++;
			}
			if(sunoft > 0){
				params.put("t", 0);
			}else if(AlarminfoSave.warningoftempofid == 1){  //一半的时间内有异常的  黄色
				params.put("p", 2);
			}else{
				params.put("t", 1);
			}
			//--------
			//获取各个湿度的标志位，统计不是-1的个数，大于0 说明有湿度数据异常
			int sunofrh = 0 ;
			for(int i = 0 ; i < 10 ; i++){
				if(AlarminfoSave.idofrh[i] != -1)
					sunofrh++;
			}
			if(sunofrh > 0){
				params.put("rh", 0);
			}else if(AlarminfoSave.warningofrhofid == 1){  //一半的时间内有异常的  黄色
				params.put("p", 2);
			}else{
				params.put("rh", 1);
			}
			

			JSONObject jsonObject = JSONObject.fromObject(params);
			out.println(jsonObject);
		}else{
			params.put("info", "没有实时数据");
			JSONObject jsonObject = JSONObject.fromObject(params);
			out.println(jsonObject);
		}
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
