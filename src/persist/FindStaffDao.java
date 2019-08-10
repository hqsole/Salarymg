package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JdbcUtil;

import domain.Staff;
import domain.Users;

public class FindStaffDao {
	public Staff findStaffByJobNum(String jobNum,Users u){
		Connection conn=null;
		Staff s=null;
		try {
			conn = JdbcUtil.getConnection(u.getUserName(), u.getPwd());
			PreparedStatement ps=conn.prepareStatement("select * from Staff where Job_number=?");
			ps.setString(1, jobNum);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				s=new Staff();
				s.setJobNum(rs.getString(1));
				s.setName(rs.getString(2));
				s.setSex(rs.getString(3));
				s.setAge(rs.getInt(4));
				s.setHome(rs.getString(5));
				s.setId(rs.getString(6));
				s.setStatus(rs.getString(7));
				s.setEdu(rs.getString(8));
				s.setDepart(rs.getString(9));
				s.setTrade(rs.getString(10));
				s.setGongLing(rs.getString(11));
				s.setLevel(rs.getString(12));
				s.setPostWage(Double.parseDouble(rs.getString(13)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(conn);
		}
		return s;
	}
	public Staff findStaffByIdNum(String idNum,Users u){
		Connection conn=null;
		Staff s=null;
		try {
			conn = JdbcUtil.getConnection(u.getUserName(), u.getPwd());
			PreparedStatement ps=conn.prepareStatement("select * from Staff where ID_number=?");
			ps.setString(1, idNum);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				s=new Staff();
				s.setJobNum(rs.getString(1));
				s.setName(rs.getString(2));
				s.setSex(rs.getString(3));
				s.setAge(rs.getInt(4));
				s.setHome(rs.getString(5));
				s.setId(rs.getString(6));
				s.setStatus(rs.getString(7));
				s.setEdu(rs.getString(8));
				s.setDepart(rs.getString(9));
				s.setTrade(rs.getString(10));
				s.setGongLing(rs.getString(11));
				s.setLevel(rs.getString(12));
				s.setPostWage(Double.parseDouble(rs.getString(13)));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(conn);
		}
		return s;
	}
	public List<Staff> findStaffs(Staff s,Users u){
		Connection conn=null;
		List<Staff> list=new ArrayList<Staff>();
		try{
			conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
			PreparedStatement ps=conn.prepareStatement(this.getSQL(s));
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Staff ss=new Staff();
				ss.setJobNum(rs.getString(1));
				ss.setName(rs.getString(2));
				ss.setSex(rs.getString(3));
				ss.setAge(rs.getInt(4));
				ss.setHome(rs.getString(5));
				ss.setId(rs.getString(6));
				ss.setStatus(rs.getString(7));
				ss.setEdu(rs.getString(8));
				ss.setDepart(rs.getString(9));
				ss.setTrade(rs.getString(10));
				ss.setGongLing(rs.getString(11));
				ss.setLevel(rs.getString(12));
				ss.setPostWage(Double.parseDouble(rs.getString(13)));
				list.add(ss);
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(conn);
		}
		return list;
	}
	private String getSQL(Staff s){
		StringBuffer sb=new StringBuffer("select * from Staff where 1=1");
		if(s.getName()!=null&&s.getName().length()>0)
			sb.append(" and Name like '%").append(s.getName()).append("%'");
		if(s.getSex()!=null&&s.getSex().length()>0)
			sb.append(" and Gender='").append(s.getSex()).append("'");
		if(s.getAge()>0)
			sb.append(" and Age=").append(s.getAge());
		if(s.getDepart()!=null&&s.getDepart().length()>0)
			sb.append(" and Department like '%").append(s.getDepart()).append("%'");
		return sb.toString();
	}
}
