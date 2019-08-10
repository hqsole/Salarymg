package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JdbcUtil;

import domain.Staff;
import domain.Users;

public class OperatorStaff {
	public void addStaff(Staff s,Users u){
		Connection conn=null;
		try{
			conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
			conn.setAutoCommit(false);
			String sql="insert into Staff values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, s.getJobNum());
			ps.setString(2, s.getName());
			ps.setString(3, s.getSex());
			ps.setInt(4, s.getAge());
			ps.setString(5, s.getHome());
			ps.setString(6, s.getId());
			if(s.getStatus()!=null)
				ps.setString(7, s.getStatus());
			else
				ps.setString(7, "");
			if(s.getDepart()!=null)
				ps.setString(8, s.getDepart());
			else
				ps.setString(8, "");
			ps.setString(9, s.getDepart());
			if(s.getTrade()!=null)
				ps.setString(10, s.getTrade());
			else
				ps.setString(10, "");
			ps.setString(11, s.getGongLing());
			if(s.getLevel()!=null)
				ps.setString(12, s.getLevel());
			else
				ps.setString(12, "");
			ps.setDouble(13, s.getPostWage());
			ps.execute();
			conn.commit();
		}catch(SQLException e){
			JdbcUtil.rollbackConnection(conn);
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeConnection(conn);
		}
	}
	public void deleteStaff(String jobNum,Users u){
		Connection conn=null;
		try{
			conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
			conn.setAutoCommit(false);
			PreparedStatement ps1=conn.prepareStatement("delete Wage where Job_number=?");
			ps1.setString(1, jobNum);
			ps1.execute();
			PreparedStatement ps2=conn.prepareStatement("delete Staff where Job_number=?");
			ps2.setString(1, jobNum);
			ps2.execute();
			conn.commit();
		}catch(SQLException e){
			JdbcUtil.rollbackConnection(conn);
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeConnection(conn);
		}
	}
	public void updateStaff(Staff s,Users u){
		Connection conn=null;
		try{
			conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
			conn.setAutoCommit(false);
			PreparedStatement ps=conn.prepareStatement(this.getSQL(s));
			ps.execute();
			conn.commit();
		}catch(SQLException e){
			JdbcUtil.rollbackConnection(conn);
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JdbcUtil.closeConnection(conn);
		}
	}
	private String getSQL(Staff s){
		StringBuffer sb=new StringBuffer("update Staff set");
		if(s.getName()!=null&&s.getName().length()>0)
			sb.append(" Name='").append(s.getName()).append("',");
		if(s.getSex()!=null&&s.getSex().length()>0)
			sb.append(" Gender='").append(s.getSex()).append("',");
		if(s.getAge()>0)
			sb.append(" Age=").append(s.getAge()).append(",");
		if(s.getHome()!=null&&s.getHome().length()>0)
			sb.append(" Hometown='").append(s.getHome()).append("',");
		if(s.getId()!=null&&s.getId().length()>0)
			sb.append(" ID_number='").append(s.getId()).append("',");
		if(s.getStatus()!=null&&s.getStatus().length()>0)
			sb.append(" Marital_status='").append(s.getStatus()).append("',");
		if(s.getEdu()!=null&&s.getEdu().length()>0)
			sb.append(" Educational='").append(s.getEdu()).append("',");
		if(s.getDepart()!=null&&s.getDepart().length()>0)
			sb.append(" Department='").append(s.getDepart()).append("',");
		if(s.getTrade()!=null&&s.getTrade().length()>0)
			sb.append(" Trades='").append(s.getTrade()).append("',");
		if(s.getGongLing()!=null&&s.getGongLing().length()>0)
			sb.append(" gongling='").append(s.getGongLing()).append("',");
		if(s.getLevel()!=null&&s.getLevel().length()>0)
			sb.append(" Job_classification='").append(s.getLevel()).append("',");
		if(s.getPostWage()>0)
			sb.append(" Post_wages=").append(s.getPostWage()).append(",");
		sb.append(" Job_number='").append(s.getJobNum()).append("' where Job_number='").append(s.getJobNum()).append("'");
		return sb.toString();
	}
}
