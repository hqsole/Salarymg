<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body style="background:url(images/6.jpg);background-repart:no-repart;background-attachment:fixed">
   	<form action="">
   		<table align="center" width="500" height="100" style="margin-top: 15%;border-color:#ccc" border="1" >
   			<tr>
   			<td><a href="staff.jsp">员工管理</a></td>
   			<td><a href="wage.jsp">薪资管理</a></td>
   			</tr>
   			
   		</table>
   	</form>
  </body>
</html>