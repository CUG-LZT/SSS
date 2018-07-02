package com.pro.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pro.entity.Dataofmonitor;
import com.pro.entity.Standofdata;


public class DataSave {
 
	public static void savedatafromnet(Dataofmonitor dom){
		//在SessionFactory中取出一个Session
		Session session =HibernateSessionFactory.getSession() ;
		Transaction transaction = session.beginTransaction();
		session.save(dom);
		transaction.commit();
		//6.关闭session
		session.close();
	}
	
	public static void savestandofdata(Standofdata sod){
		//在SessionFactory中取出一个Session
		Session session =HibernateSessionFactory.getSession() ;
		Transaction transaction = session.beginTransaction();
		session.save(sod);
		transaction.commit();
		//6.关闭session
		session.close();
	}
}
