package com.wc.tools;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class StringUtil {
	public static boolean isNullOrEmpty(String str)
	{
		if (str==null || str.length()==0)
		return true;
		else return false;
	}
	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
		while (strLen < strLength) {
		StringBuffer sb = new StringBuffer();
		sb.append("0").append(str);//×ó²¹0
		// sb.append(str).append("0");//ÓÒ²¹0
		str = sb.toString();
		strLen = str.length();
		}
		}
		return str;
	}
	
	
	public static String getIP(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("PRoxy-Client-IP");
		}
		if (ip == null || ip.length() == 0
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0
				|| "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
