<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
    <form action="Login.do" method="post">
			<% String msg=(String)request.getAttribute("msg");
			   if(msg!=null){
			 %>
			<h2 style="color: red"><%=msg %></h2>
			<%} %>
			<table align="center">
				<tr>
					<td>
						用户名：
					</td>
					<td>
						<input type="text" id="userName" name="userName" />
					</td>
				</tr>
				<tr>
					<td>
						密 码：
					</td>
					<td>
						<input type="password" id="pwd" name="pwd" />
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="登录">
					</td>
				</tr>
			</table>
		</form>
  </body>
</html>
