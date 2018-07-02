package com.pro.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * JSON封装和解析工具类
 * @author lc
 *
 */
public class JsonTools {
	
	public static String createJsonString2(String key, Object value) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}

	/**
	 * @param key
	 *            表示json字符串的头信息
	 * @param object
	 *            是对解析的集合的类型
	 * @return
	 */

	public static String createJsonString(Object value) {
		Gson gson = new Gson();
		String str = gson.toJson(value);
		return str;
	}

	/**
	 * 把json字符串还原成对象
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T getJsonObject(String jsonString, Class<T> cls) {
		T t = null;
		try {
			Gson gson = new Gson();
			t = gson.fromJson(jsonString, cls);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("error!");
		}
		return t;
	}

	/**
	 * 使用Gson进行解析 List<T>
	 * 
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> getJsonObjects(String jsonString, Class<T> cls) {
		List<T> list = new ArrayList<T>();
		try {
			Gson gson = new Gson();
			list = gson.fromJson(jsonString, new TypeToken<List<T>>() {
			}.getType());
		} catch (Exception e) {
			System.out.println("使用Gson进行解析 List<T>出错！！");
		}
		return list;
	}

	/**
	 * 
	 * @param jsonString
	 * @return
	 */
	public static List<String> getJsonList(String jsonString) {
		List<String> list = new ArrayList<String>();
		try {
			Gson gson = new Gson();
			list = gson.fromJson(jsonString, new TypeToken<List<String>>() {
			}.getType());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	/**
	 * 
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> listKeyMaps(String jsonString) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			Gson gson = new Gson();
			list = gson.fromJson(jsonString,
					new TypeToken<List<Map<String, Object>>>() {
					}.getType());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
