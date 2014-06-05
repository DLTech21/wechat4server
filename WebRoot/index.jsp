<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
     <script type="text/javascript" SRC="../js/jquery.form.js"></script>
    <base href="<%=basePath%>">
    
    <title>登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<form name="login" id="loginForm" action="./api/login.do"
  		method="post">
  		<div data-role="fieldcontain">
  			<label for="uName">手机号</label>
  			<input name="uName" id="uName" data-clear-btn="true"
  				value="" placeholder="请输入手机号" maxlength="11" required="true"
  				data-theme="e" type="text" />
  		</div>
  		<div data-role="fieldcontain">
  			<label for="uPass">密码</label>
  			<input name="uPass" id="uPass" data-clear-btn="true"
  				value="" placeholder="请输入密码" required="true" data-theme="e"
  				type="text" />
  		</div>
  		<input type="submit" value="立即登陆" />
  	</form>
  	
  	<script type="text/javascript">
  	
  	$(document).ready(function(){
  		$("#loginForm").submit(function(){
    	
    	ajaxSubmit();
    	return false;
  		});
	});
	
  	function ajaxSubmit()
  	{
  	var options = {
		     url: '../api/login.do',
		     dataType: 'json',
		     success: function(data) {
		        // 'data' is an object representing the the evaluated json data
		        //alert("消息:"+data.msg);
		        alert(data.uName);
		     }
	};
	$("#loginForm").ajaxSubmit(options);
  	}
  	</script>
  </body>
</html>
