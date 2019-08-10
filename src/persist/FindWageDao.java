package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtil;

import domain.Staff;
import domain.Users;
import domain.Wage;

public class FindWageDao {
	public Wage findWageByNum(String jobNum,Users u){
		Connection conn=null;
		Wage w=null;
		try {
			conn = JdbcUtil.getConnection(u.getUserName(), u.getPwd());
			PreparedStatement ps=conn.prepareStatement("select * from Wage where Job_number=?");
			ps.setString(1, jobNum);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				w=new Wage();
				w.setJobNum(rs.getString(1));
				w.setJobSub(rs.getDouble(2));
				w.setAttenDays(rs.getDouble(3));
				w.setOverHours(rs.getDouble(4));
				w.setOverDays(rs.getDouble(5));
				w.setOverCate(rs.getDouble(6));
				w.setOverPay(rs.getString(7));
				w.setSickLeave(rs.getDouble(8));
				w.setLeaveCharge(rs.getDouble(9));
				w.setOther(rs.getDouble(10));
				w.setShouldWage(rs.getDouble(11));
				w.setRealWage(rs.getDouble(12));
			}
		} catch (SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			JdbcUtil.closeConnection(conn);
		}
		return w;
	}
}
