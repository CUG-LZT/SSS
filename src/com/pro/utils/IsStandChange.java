package com.pro.utils;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pro.entity.Standofdata;



public class IsStandChange {

	public static boolean isstandchange = false;
	
	public static String getStandInfo(){
		
		String standInfo = "";
		Session ss = HibernateSessionFactory.getSession();
		Query query = ss.createQuery("from Standofdata ");
		Standofdata sod = (Standofdata) query.uniqueResult();
		
		standInfo += "##set=212;" + (int)(sod.getSttime()) + ";" 
				 		+ (int)sod.getSrhtime() + ";"
				 		
				 		+ (sod.getSstandoft()).split(",")[0] + ";"
				 		+ (sod.getSstandoft()).split(",")[1] + ";"
				 		+ (sod.getSstandofrh()).split(",")[0] + ";"
				 		+ (sod.getSstandofrh()).split(",")[1] + ";"
				 		
				 		+ (sod.getSstandofp1()).split(",")[0] + ";"
				 		+ (sod.getSstandofp1()).split(",")[1] + ";"
				 		+ (sod.getSstandofp2()).split(",")[0] + ";"
				 		+ (sod.getSstandofp2()).split(",")[1] + ";"
				 		+ (sod.getSstandofp3()).split(",")[0] + ";"
				 		+ (sod.getSstandofp3()).split(",")[1] + ";"
				 		+ (sod.getSstandofp4()).split(",")[0] + ";"
				 		+ (sod.getSstandofp4()).split(",")[1] + ";"
				 		+ (sod.getSstandofp5()).split(",")[0] + ";"
				 		+ (sod.getSstandofp5()).split(",")[1] + ";"
				 		+ (sod.getSstandofp6()).split(",")[0] + ";"
				 		+ (sod.getSstandofp6()).split(",")[1] + ";"
				 		+ (sod.getSstandofp7()).split(",")[0] + ";"
				 		+ (sod.getSstandofp7()).split(",")[1] + ";"
				 		+ (sod.getSstandofp8()).split(",")[0] + ";"
				 		+ (sod.getSstandofp8()).split(",")[1] + ";"
				 		+ (sod.getSstandofp9()).split(",")[0] + ";"
				 		+ (sod.getSstandofp9()).split(",")[1] + ";"
				 		+ (sod.getSstandofp10()).split(",")[0] + ";"
				 		+ (sod.getSstandofp10()).split(",")[1] + ";"
				 		+ (sod.getSstandofp11()).split(",")[0] + ";"
				 		+ (sod.getSstandofp11()).split(",")[1] + ";"
				 		+ (sod.getSstandofp12()).split(",")[0] + ";"
				 		+ (sod.getSstandofp12()).split(",")[1] + ";"
				 		+ (sod.getSstandofp13()).split(",")[0] + ";"
				 		+ (sod.getSstandofp13()).split(",")[1] + ";"
				 		+ (sod.getSstandofp14()).split(",")[0] + ";"
				 		+ (sod.getSstandofp14()).split(",")[1] + ";"
				 		+ (sod.getSstandofp15()).split(",")[0] + ";"
				 		+ (sod.getSstandofp15()).split(",")[1] + ";"
				 		+ (sod.getSstandofp16()).split(",")[0] + ";"
				 		+ (sod.getSstandofp16()).split(",")[1] + ";"
				 		+ (sod.getSstandofp17()).split(",")[0] + ";"
				 		+ (sod.getSstandofp17()).split(",")[1] + ";"
				 		+ (sod.getSstandofp18()).split(",")[0] + ";"
				 		+ (sod.getSstandofp18()).split(",")[1] + ";"
				 		+ (sod.getSstandofp19()).split(",")[0] + ";"
				 		+ (sod.getSstandofp19()).split(",")[1] + ";"
				 		+ (sod.getSstandofp20()).split(",")[0] + ";"
				 		+ (sod.getSstandofp20()).split(",")[1] + ";"
				 		+ (sod.getSstandofp21()).split(",")[0] + ";"
				 		+ (sod.getSstandofp21()).split(",")[1] + ";"
				 		+ (sod.getSstandofp22()).split(",")[0] + ";"
				 		+ (sod.getSstandofp22()).split(",")[1] + ";"
				 		+ (sod.getSstandofp23()).split(",")[0] + ";"
				 		+ (sod.getSstandofp23()).split(",")[1] + ";"
				 		+ (sod.getSstandofp24()).split(",")[0] + ";"
				 		+ (sod.getSstandofp24()).split(",")[1] + ";"
				 		+ (sod.getSstandofp25()).split(",")[0] + ";"
				 		+ (sod.getSstandofp25()).split(",")[1] + ";"
				 		+ (sod.getSstandofp26()).split(",")[0] + ";"
				 		+ (sod.getSstandofp26()).split(",")[1] + ";"
				 		+ (sod.getSstandofp27()).split(",")[0] + ";"
				 		+ (sod.getSstandofp27()).split(",")[1] + ";"
				 		+ (sod.getSstandofp28()).split(",")[0] + ";"
				 		+ (sod.getSstandofp28()).split(",")[1] + ";&&";
		System.out.println(standInfo);
		if (ss != null) {
			ss.close();
		}
		return standInfo;
		//return "##set=212;6;180;19.5;29.5;39.9;59.9;0;1;0;2.0;0;3.0;0;4.0;0;5.0;0;6.0;0;7.0;0;8.0;0;9.0;0;10.0;0;11;0;12;0;13;0;14;0;15;0;16;0;17;0;18;-19;19;-20;20;-21;21;-22;22;-23;23;-24;24;0;25;0;26;0;27;0;28;&&";
	}
}
