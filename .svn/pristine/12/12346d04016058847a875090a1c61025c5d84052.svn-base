package com.it.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BeanUtil {

	public static Map<String, Object> transBean2Map(Object obj) {
		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value);
				}

			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}

		return map;
	}

	public static String strToCamel(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		StringBuilder sb = new StringBuilder(param.toLowerCase());
		Matcher mc = Pattern.compile("_").matcher(param);
		int i = 0;
		while (mc.find()) {
			int position = mc.end() - (i++);
			sb.replace(position - 1, position + 1,
					sb.substring(position, position + 1).toUpperCase());
		}
		return sb.toString();
	}

	public static String upperFirstChar(String param) {
		String result = strToCamel(param);
		return result.length() > 0 ? result.substring(0, 1).toUpperCase()
				+ result.substring(1) : "";
	}

	public static String dbType2JavaType(int type) {
		String javaType = "";
		switch (type) {
		case 1:
		case 12:
		case -1:
		case -4:
			javaType = "String";
			break;
		case 4:
			javaType = "Long";
			break;
		case -6:
		case 5:
		case -7:
		case -5:
			javaType = "Integer";
			break;
		case 7:
			javaType = "Float";
			break;
		case 91:
		case 93:
			javaType = "Date";
			break;
		}
		return javaType;
	}

	public static void main(String[] args) {
		System.out.println(upperFirstChar(""));
	}
}
