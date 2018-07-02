package com.pro.net;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class BaseServer extends HttpServlet {

	 public BaseServer() {  
	        super();  
	    }  
	    public void init() throws ServletException {  
	        System.out.println("开始从网络获取数据...");  
	        ThreadServer thread = new ThreadServer();
	        thread.start();
	        
	    }
}
