<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'staff.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function find(){
		document.forms[0].action="FindStaff.do";
		document.forms[0].submit();
	}
	function add(){
		document.forms[0].action="AddStaff.do";
		document.forms[0].submit();
	}
	</script>

  </head>
  
  <body>
    <form action="" method="post">
    	<h2 align="center">员工查询</h2>
    	<table align="center">
    		<tr>
    			<td>工号</td>
    			<td><input type="text" name="jobNum" id="jobNum"/></td>
    			<td>姓名</td>
    			<td><input type="text" name="names" id="names"/></td>
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td><input type="radio" name="sex" value="男"/>男
    				<input type="radio" name="sex" value="女"/>女
    			</td>
    			<td>年龄</td>
    			<td><input type="text" name="age" id="age"/></td>
    		</tr>
    		<tr>
    			<td>身份证号</td>
    			<td><input type="text" name="idNum" id="idNum"/></td>
    			<td>部门名称</td>
    			<td><input type="text" name="depart" id="depart"/></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center"><input type="button" onclick="find()" value="查询"/></td>
    		</tr>
    	</table>
    	<h2 align="center">添加员工</h2>
    	<table align="center">
    		<tr>
    			<td>工号</td>
    			<td><input type="text" name="jobNum2" id="jobNum2"/></td>
    			<td>姓名</td>
    			<td><input type="text" name="name2" id="name2"/></td>
    		</tr>
    		<tr>
    			<td>性别</td>
    			<td><input type="radio" name="sex2" value="男" checked="checked"/>男
    				<input type="radio" name="sex2" value="女"/>女
    			</td>
    			<td>年龄</td>
    			<td><input type="text" name="age2" id="age2"/></td>
    		</tr>
    		<tr>
    			<td>籍贯</td>
    			<td><input type="text" name="hometown2" id="hometown2"/></td>
    			<td>身份证号</td>
    			<td><input type="text" name="idNum2" id="idNum2"/></td>
    		</tr>
    		<tr>
    			<td>婚姻状况</td>
    			<td><input type="text" name="marital_status2" id="marital_status2"/></td>
    			<td>学历</td>
    			<td><input type="text" name="edu2" id="edu2"/></td>
    		</tr>
    		<tr>
    			<td>部门名称</td>
    			<td><input type="text" name="depart2" id="depart2"/></td>
    			<td>职称</td>
    			<td><input type="text" name="trade2" id="trade2"/></td>
    		</tr>
    		<tr>
    			<td>工龄</td>
    			<td><input type="text" name="gongling2" id="gongling2"/></td>
    			<td>职务等级</td>
    			<td><input type="text" name="level2" id="level2"/></td>
    		</tr>
    		<tr>
    			<td>岗位工资</td>
    			<td><input type="text" name="wage2" id="wage2"/></td>
    			<td></td>
    			<td></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center">
    				<input type="button" onclick="add()" value="确定"/>
    				<input type="reset" value="重置">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
