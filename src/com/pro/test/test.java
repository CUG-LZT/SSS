package com.pro.test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.pro.entity.Standofdata;
import com.pro.utils.DataSave;
import com.pro.utils.HibernateSessionFactory;
import com.pro.utils.IsStandChange;

public class test {

	public static void main(String[] args) {
		Session s = HibernateSessionFactory.getSession();
		Map<String, Object> params_stand = new HashMap<String, Object>();
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
		
		Set<Map.Entry<String,Object>> set=params_stand.entrySet();
		Iterator<Map.Entry<String,Object>> iter = set.iterator(); 
		while(iter.hasNext()){  
	           Map.Entry<String, Object> entry=iter.next();  
	           System.out.println("key-->"+entry.getKey());  
	           System.out.println("value-->"+entry.getValue());  
	       } 
		
	}
}
