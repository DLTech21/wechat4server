package com.wc.tools;
import java.security.MessageDigest;

public class EncryptTool {
	 public static String md5(String txt) {
         try{
              MessageDigest md = MessageDigest.getInstance("MD5");
              md.update(txt.getBytes("GBK"));    //������Ҫ�������Java���ַ�����unicode���룬����Դ���ļ��ı���Ӱ�죻��PHP�ı����Ǻ�Դ���ļ��ı���һ�£���Դ�����Ӱ�졣
              StringBuffer buf=new StringBuffer();            
              for(byte b:md.digest()){
                   buf.append(String.format("%02x", b&0xff));        
              }
             return  buf.toString();
           }catch( Exception e ){
               e.printStackTrace(); 

               return null;
            } 
    }
	 
}
