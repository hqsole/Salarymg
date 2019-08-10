package domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import common.JdbcUtil;

public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String pwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPws(String pwd) {
		this.pwd = pwd;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public void login(Users u) throws Exception{
		Connection conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());

	String sql="select * from users";//假设账号、密码保存在表users中
	boolean isMatch=false;
	try
	{
	Statement st=conn.createStatement();
	ResultSet rs=st.executeQuery(sql);
	while(rs.next())
	{
	String name=rs.getString("name");//数据库字段名请根据你的实际填写
	if(name.equals(userName))//如果输入的名字与数据库中的名字相同，则比较密码
	{
	String p=rs.getString("password");//密码字段，请按实际情况写
	if(p.equals(pwd)) //假设密码在数据库中明码保存
	{
	isMatch=true;
	break;
	}
	}
	}
	if(isMatch)	//如果账户名、密码匹配
	{
	//相应的代码
	}
	else
	{
	JOptionPane.showMessageDialog(null,"用户名或密码错误！！");
	//其他代码
	}
	}
	catch(Exception e)//异常捕获
	{}
}
}
