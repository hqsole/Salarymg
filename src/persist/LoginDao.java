package persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JdbcUtil;

import domain.Users;

public class LoginDao {
	public void login(Users u) throws Exception{
		Connection conn=JdbcUtil.getConnection(u.getUserName(), u.getPwd());
	}
}
