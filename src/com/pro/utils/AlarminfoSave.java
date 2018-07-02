package com.pro.utils;

import java.sql.Timestamp;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pro.entity.Alarm;

public class AlarminfoSave {

	public static int warningofpressofid = -1, alarmofpressofid = -1 , idofp[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,} ,
							warningoftempofid = -1 ,alarmoftempofid = -1 , idoft[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1} ,
								warningofrhofid = -1 ,alarmofrhofid = -1 , idofrh[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};

	public static Timestamp etime = null;

	public static int add(Timestamp stime, Timestamp etime, String location, String detail, String status, String type) {
		int idofalarmofpress = 0;
		//与DOALARM的ss(session)是同一个session所以这不能关闭，doalarm在一次运行结束后会关闭
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		
		Alarm alarm = new Alarm();
		alarm.setAstime(stime);
		alarm.setAetime(etime);
		alarm.setAlocation(location);
		alarm.setAdetail(detail);
		alarm.setAstatues(status);
		alarm.setAtype(type);
		//保存数据
		session.save(alarm);
		transaction.commit();
		//获取id
		idofalarmofpress = alarm.getAid();
		
		return idofalarmofpress;
	}

	public static void update(int id , Timestamp etime) {
		String hql = "update Alarm set aetime = '" + etime + "' where aid=" + id;
		//与DOALARM的ss(session)是同一个session所以这不能关闭，doalarm在一次运行结束后会关闭
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		
		Query queryupdate = session.createQuery(hql);
		
		int ret = queryupdate.executeUpdate();
		transaction.commit();
	}
}
