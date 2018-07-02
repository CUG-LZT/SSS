package com.pro.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pro.entity.Standofdata;
import com.pro.utils.HibernateSessionFactory;
import com.pro.utils.IsStandChange;

public class ChangealarmInfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ChangealarmInfo() {
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

		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		double dp = Double.parseDouble("2.5");
		double drh = Double.parseDouble(request.getParameter("DR"));//----------
		double dt = Double.parseDouble(request.getParameter("DT"));
		String p1 =  request.getParameter("P1");
		String p2 =  request.getParameter("P2");
		String p3 =  request.getParameter("P3");
		String p4 =  request.getParameter("P4");
		String p5 =  request.getParameter("P5");
		String p6 =  request.getParameter("P6");
		String p7 =  request.getParameter("P7");
		String p8 =  request.getParameter("P8");
		String p9 =  request.getParameter("P9");
		String p10 =  request.getParameter("P10");
		String p11 =  request.getParameter("P11");
		String p12 =  request.getParameter("P12");
		String p13 =  request.getParameter("P13");
		String p14 =  request.getParameter("P14");
		String p15 =  request.getParameter("P15");
		String p16 =  request.getParameter("P16");
		String p17 =  request.getParameter("P17");
		String p18 =  request.getParameter("P18");
		String p19 =  request.getParameter("P19");
		String p20 =  request.getParameter("P20");
		String p21 =  request.getParameter("P21");
		String p22 =  request.getParameter("P22");
		String p23 =  request.getParameter("P23");
		String p24 =  request.getParameter("P24");
		String p25 =  request.getParameter("P25");
		String p26 =  request.getParameter("P26");
		String p27 =  request.getParameter("P27");
		String p28 =  request.getParameter("P28");
		String t =  request.getParameter("TL");
		String rh =  request.getParameter("RH");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query queryofsod = session.createQuery("from Standofdata");
		Standofdata sod = (Standofdata)queryofsod.uniqueResult();
		
		sod.setSptime(dp);
		sod.setSttime(dt);
		sod.setSrhtime(drh);
		sod.setSstandofp1(p1);
		sod.setSstandofp2(p2);
		sod.setSstandofp3(p3);
		sod.setSstandofp4(p4);
		sod.setSstandofp5(p5);
		sod.setSstandofp6(p6);
		sod.setSstandofp7(p7);
		sod.setSstandofp8(p8);
		sod.setSstandofp9(p9);
		sod.setSstandofp10(p10);
		sod.setSstandofp11(p11);
		sod.setSstandofp12(p12);
		sod.setSstandofp13(p13);
		sod.setSstandofp14(p14);
		sod.setSstandofp15(p15);
		sod.setSstandofp16(p16);
		sod.setSstandofp17(p17);
		sod.setSstandofp18(p18);
		sod.setSstandofp19(p19);
		sod.setSstandofp20(p20);
		sod.setSstandofp21(p21);
		sod.setSstandofp22(p22);
		sod.setSstandofp23(p23);
		sod.setSstandofp24(p24);
		sod.setSstandofp25(p25);
		sod.setSstandofp26(p26);
		sod.setSstandofp27(p27);
		sod.setSstandofp28(p28);
		sod.setSstandoft(t);
		sod.setSstandofrh(rh);
		session.save(sod);
		transaction.commit();
		//要设置session就在这
		IsStandChange.isstandchange=true;
		if(session != null)
		{		//关闭session
				session.close();
		}
		out.println("<!DOCTYPE HTML>");
		out.println("<HTML>");
		//自动跳转
		out.print("<meta http-equiv= refresh content=3;url=http://172.16.10.165:8080/sss/page/menuPage/standofdta.jsp>");
		out.println("  <HEAD><TITLE></TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("<div class='alert alert-success'>保存成功！请等待3秒，自动跳转中...</div>");
		out.println("  </BODY>");
		out.println("</HTML>");
		
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
