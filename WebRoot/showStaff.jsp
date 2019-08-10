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
    
    <title>My JSP 'showStaff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function update(){
		document.forms[0].action="PreUpdateStaff.do";
		document.forms[0].submit();
	}
	function deleted(){
		document.forms[0].action="DeleteStaff.do";
		document.forms[0].submit();
	}
	</script>

  </head>
  
  <body>
    <form action="" method="post">
    	<table align="center" border="1">
    		<tr>
    			<td>工号</td>
    			<td>姓名</td>
    			<td>性别</td>
    			<td>年龄</td>
    			<td>籍贯</td>
    			<td>身份证号</td>
    			<td>婚姻状况</td>
    			<td>学历</td>
    			<td>部门名称</td>
    			<td>工种</td>
    			<td>工龄</td>
    			<td>职务等级</td>
    			<td>岗位工资</td>
    			<td>操作</td>
    		</tr>
    		<%
    		List<Staff> list=(List<Staff>)request.getAttribute("list");
    		for(Staff s:list){
    		 %>
    		 <tr>
    			<td><%=s.getJobNum() %></td>
    			<td><%=s.getName() %></td>
    			<td><%=s.getSex() %></td>
    			<td><%=s.getAge() %></td>
    			<td><%=s.getHome() %></td>
    			<td><%=s.getId() %></td>
    			<td><%=s.getStatus() %></td>
    			<td><%=s.getEdu() %></td>
    			<td><%=s.getDepart() %></td>
    			<td><%=s.getTrade() %></td>
    			<td><%=s.getGongLing() %></td>
    			<td><%=s.getLevel() %></td>
    			<td><%=s.getPostWage() %></td>
    			<td>
    				<input type="hidden" name="jobNum" id="jobNum" value="<%=s.getJobNum() %>">
    				<input type="button" onclick="update()" value="修改"/>
    				<input type="button" onclick="deleted()" value="删除"/>
    			</td>
    		</tr>
    		<%} %>
    	</table>
    </form>
  </body>
</html>
