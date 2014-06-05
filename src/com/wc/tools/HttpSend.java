package com.wc.tools;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;


public class HttpSend {
	public static String getSend(String strUrl,String param){
		URL url = null;
		HttpURLConnection connection = null;
		
		try {
			url = new URL(strUrl + "?" + param);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("GET");
			connection.setUseCaches(false);
			connection.connect();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
		
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
				}
		}
	}
	
	public static String postSend(String strUrl,String param){
		
		
		URL url = null;
		HttpURLConnection connection = null;
		
		try {
			url = new URL(strUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.connect();

			//POST方法时使用
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.writeBytes(param);
			out.flush();
			out.close();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
		
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
				}
		}
		
		
	}
	/**
	 * 转为16进制方法
	 * @param str
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String paraTo16(String str) throws UnsupportedEncodingException {
			String hs = "";
			
			byte[] byStr = str.getBytes("UTF-8");
			for(int i=0;i<byStr.length;i++)
			{
				String temp = "";
				temp = (Integer.toHexString(byStr[i]&0xFF));
				if(temp.length()==1) temp = "%0"+temp;
				else temp = "%"+temp;
				hs = hs+temp;
			}
			return hs.toUpperCase();
	
		
	}

}
