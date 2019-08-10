<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="domain.Staff"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateStaff.jsp' starting page</title>
    
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
    <form action="UpdateStaff.do">
    	<table align="center">
    		<%
    			Staff s=(Staff)request.getAttribute("s");
    		 %>
    		<tr>
    			<td>工号</td>
    			<td><input type="text" name="jobNum2" id="jobNum2" value="<%=s.getJobNum() %>" readonly="readonly"/></td>
    			<td>姓名</td>
    			<td><input type="text" name="name2" id="name2" value="<%=s.getName() %>"/></td>
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td><input type="radio" name="sex2" value="男"<%if("男".equals(s.getSex())){ %> checked="checked"<%} %>/>男
    				<input type="radio" name="sex2" value="女"<%if("女".equals(s.getSex())){ %> checked="checked"<%} %>/>女
    			</td>
    			<td>年龄</td>
    			<td><input type="text" name="age2" id="age2" value="<%=s.getAge() %>"/></td>
    		</tr>
    		<tr>
    			<td>籍贯</td>
    			<td><input type="text" name="hometown2" id="hometown2" value="<%=s.getHome() %>"/></td>
    			<td>身份证号</td>
    			<td><input type="text" name="idNum2" id="idNum2" value="<%=s.getId() %>"/></td>
    		</tr>
    		<tr>
    			<td>婚姻状况</td>
    			<td><input type="text" name="marital_status2" id="marital_status2"  value="<%=s.getStatus() %>"/></td>
    			<td>学历</td>
    			<td><input type="text" name="edu2" id="edu2" value="<%=s.getEdu() %>"/></td>
    		</tr>
    		<tr>
    			<td>部门名称</td>
    			<td><input type="text" name="depart2" id="depart2" value="<%=s.getDepart() %>"/></td>
    			<td>工种</td>
    			<td><input type="text" name="trade2" id="trade2" value="<%=s.getTrade() %>"/></td>
    		</tr>
    		<tr>
    			<td>工龄</td>
    			<td><input type="text" name="gongling2" id="gongling2" value="<%=s.getGongLing() %>"/></td>
    			<td>职务等级</td>
    			<td><input type="text" name="level2" id="level2" value="<%=s.getLevel() %>"/></td>
    		</tr>
    		<tr>
    			<td>岗位工资</td>
    			<td><input type="text" name="wage2" id="wage2" value="<%=s.getPostWage() %>"/></td>
    			<td></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center">
    				<input type="submit" value="确定"/>
    				<input type="reset" value="重置">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
