package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.JdbcUtil;

import domain.Users;
import domain.Wage;

public class OperatorWage {
	public void addWage(Wage w,Users u){
		Connection conn=null;
		try{
			conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
			conn.setAutoCommit(false);
			String sql="insert into Wage values(?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, w.getJobNum());
			ps.setDouble(2, w.getJobSub());
			ps.setDouble(3, w.getAttenDays());
			ps.setDouble(4, w.getOverHours());
			ps.setDouble(5, w.getOverDays());
			ps.setDouble(6, w.getOverCate());
			ps.setString(7, w.getOverPay());
			ps.setDouble(8, w.getSickLeave());
			ps.setDouble(9, w.getLeaveCharge());
			ps.setDouble(10, w.getOther());
			ps.setDouble(11, w.getShouldWage());
			ps.setDouble(12, w.getRealWage());
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
	public void updateWage(Wage w,Users u){
		Connection conn=null;
		try{
			conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
			conn.setAutoCommit(false);
			String sql="update Wage set Job_subsidies=?,Attendance_Days=?,Overtime_hours=?," +
					"Overtime_Days=?,Overtime_Category=?,Overtime_pay=?,Sick_leave_deductions=?," +
					"Leave_chargeback=?,Other_deductions=?,Should_wages=?,Real_wages=? where Job_number=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setDouble(1, w.getJobSub());
			ps.setDouble(2, w.getAttenDays());
			ps.setDouble(3, w.getOverHours());
			ps.setDouble(4, w.getOverDays());
			ps.setDouble(5, w.getOverCate());
			ps.setString(6, w.getOverPay());
			ps.setDouble(7, w.getSickLeave());
			ps.setDouble(8, w.getLeaveCharge());
			ps.setDouble(9, w.getOther());
			ps.setDouble(10, w.getShouldWage());
			ps.setDouble(11, w.getRealWage());
			ps.setString(12, w.getJobNum());
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
}
