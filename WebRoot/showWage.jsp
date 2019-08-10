<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="domain.Wage"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showWage.jsp' starting page</title>
    
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
    <form action="UpdateWage.do" method="post">
    	<table align="center">
    		<%
    		Wage w=(Wage)request.getAttribute("w");
    		 %>
    		<tr>
    			<td align="right"><font color="red">*</font>职工编号：</td>
    			<td><input type="text" id="jobNum" name="jobNum" value="<%=w.getJobNum() %>"/></td>
    			<td align="right">岗位补贴：</td>
    			<td><input type="text" name="sub" id="sub" value="<%=w.getJobSub() %>"/></td>
    		</tr>
    		<tr>
    			<td align="right"><font color="red">*</font>出勤天数：</td>
    			<td><input type="text" id="day" name="day"  value="<%=w.getAttenDays() %>"/></td>
    			<td align="right">加班工时：</td>
    			<td><input type="text" name="overHour" id="overHour" value="<%=w.getOverHours() %>"/></td>
    		</tr>
    		<tr>
    			<td align="right">加班天数：</td>
    			<td><input type="text" id="overDay" name="overDay"  value="<%=w.getOverDays() %>"/></td>
    			<td align="right">加班类别：</td>
    			<td><input type="text" name="overCate" id="overCate" value="<%=w.getOverCate() %>"/></td>
    		</tr>
    		<tr>
    			<td align="right">加班工资：</td>
    			<td><input type="text" id="overPay" name="overPay" value="<%=w.getOverPay() %>" /></td>
    			<td align="right">病假扣款：</td>
    			<td><input type="text" name="sick" id="sick" value="<%=w.getSickLeave() %>"/></td>
    		</tr>
    		<tr>
    			<td align="right">事假扣款：</td>
    			<td><input type="text" id="leave" name="leave" value="<%=w.getLeaveCharge() %>" /></td>
    			<td align="right">其他扣款：</td>
    			<td><input type="text" name="other" id="other" value="<%=w.getOther() %>"/></td>
    		</tr>
    		<tr>
    			<td align="right"><font color="red">*</font>应发工资：</td>
    			<td><input type="text" id="should" name="should" value="<%=w.getShouldWage() %>" /></td>
    			<td align="right"><font color="red">*</font>实发工资：</td>
    			<td><input type="text" name="real" id="real" value="<%=w.getRealWage() %>"/></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center">
    				<input type="submit" value="修改"/>
    				<input type="reset" value="重置"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
