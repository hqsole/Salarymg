<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'wage.jsp' starting page</title>
    
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
			document.forms[0].action="FindWage.do";
			document.forms[0].submit();
		}
		function add(){
			document.forms[0].action="AddWage.do";
			document.forms[0].submit();
		}
	</script>

  </head>
  
  <body>
    <form action="" method="post">
    	<h2 align="center">薪资查询</h2>
    	<table align="center">
    		<tr>
    			<td>职工编号：</td>
    			<td><input type="text" id="job" name="job" /></td>
    		</tr>
    		<tr  align="center">
    			<td colspan="2"><input type="button" onclick="find()" value="查询"/></td>
    		</tr>
    	</table>
    	<h2 align="center">添加员工工资</h2>
    	<table align="center">
    		<tr>
    			<td align="right"><font color="red">*</font>员工编号：</td>
    			<td><input type="text" id="jobNum" name="jobNum" /></td>
    			<td align="right">岗位补贴：</td>
    			<td><input type="text" name="sub" id="sub"/></td>
    		</tr>
    		<tr>
    			<td align="right"><font color="red">*</font>出勤天数：</td>
    			<td><input type="text" id="day" name="day" /></td>
    			<td align="right">加班工时：</td>
    			<td><input type="text" name="overHour" id="overHour"/></td>
    		</tr>
    		<tr>
    			<td align="right">加班天数：</td>
    			<td><input type="text" id="overDay" name="overDay" /></td>
    			<td align="right">加班类别：</td>
    			<td><input type="text" name="overCate" id="overCate"/></td>
    		</tr>
    		<tr>
    			<td align="right">加班工资：</td>
    			<td><input type="text" id="overPay" name="overPay" /></td>
    			<td align="right">病假扣款：</td>
    			<td><input type="text" name="sick" id="sick"/></td>
    		</tr>
    		<tr>
    			<td align="right">事假扣款：</td>
    			<td><input type="text" id="leave" name="leave" /></td>
    			<td align="right">其他扣款：</td>
    			<td><input type="text" name="other" id="other"/></td>
    		</tr>
    		<tr>
    			<td align="right"><font color="red">*</font>应发工资：</td>
    			<td><input type="text" id="should" name="should" /></td>
    			<td align="right"><font color="red">*</font>实发工资：</td>
    			<td><input type="text" name="real" id="real"/></td>
    		</tr>
    		<tr>
    			<td colspan="4" align="center">
    				<input type="button" onclick="add()" value="添加"/>
    				<input type="reset" value="重置"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
