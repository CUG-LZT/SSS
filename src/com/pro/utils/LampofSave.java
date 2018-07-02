package com.pro.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LampofSave {

	public static int islock = 0,isunlk = 0 ;
	public static Map<String, Object> params = new HashMap<String, Object>();
	
	public static void getdata(Map<String, Object> param){
		params = param;
		List<Integer> dataoflock = (List<Integer>) params.get("lock");
	}
	//List<Integer> params = new ArrayList<Integer>();
	public static List<Integer> getdataoflock(){
		List<Integer> dataoflock = (List<Integer>) params.get("lock");
		return dataoflock;
	}
	
	public static List<Integer> getdataofunlk(){
		List<Integer> dataofunlk = (List<Integer>) params.get("unlk");
		return dataofunlk;
	}
}
