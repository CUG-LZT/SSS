package com.pro.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import com.pro.utils.Dowarning;


public class WarningListener extends HttpServlet implements
		ServletContextListener {

	public WarningListener() {
	}

	private java.util.Timer timer = null;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		timer.cancel();
		arg0.getServletContext().log("定时器销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		timer = new java.util.Timer(true);
		arg0.getServletContext().log("定时器已启动");
		timer.schedule(new Dowarning(arg0.getServletContext()), 0, 3 * 60 * 1000);
		arg0.getServletContext().log("已经添加任务调度表");
	}

}
