package com.pro.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import com.pro.utils.DoAlarm;




public class AlarmListener extends HttpServlet implements
		ServletContextListener {

	public AlarmListener() {
	}

	private java.util.Timer timer = null;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		timer.cancel();
		event.getServletContext().log("定时器销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		timer = new java.util.Timer(true);
		event.getServletContext().log("定时器已启动");
		timer.schedule(new DoAlarm(event.getServletContext()), 0, 3 * 60 * 1000);
		event.getServletContext().log("已经添加任务调度表");
	}

}
