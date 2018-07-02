package com.pro.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ThreadServer extends Thread {
	public void run() {
		try {
			//设置端口号
			ServerSocket seversocket = new ServerSocket(9003);
			Socket socket = null;
			while (true) {
				socket = seversocket.accept();
				GetDataServer thread = new GetDataServer(socket);
				thread.start();
				InetAddress address = socket.getInetAddress();
				System.out.println("主机地址："+address.getHostAddress() + "主机名："+ address.getHostName() +"端口号："+ socket.getPort());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
