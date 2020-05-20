package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.util.ConnectionUtil;
import com.sample.vo.User;

public class UserDao {

	public void insertUser (User user) throws SQLException {
		String sql = "insert into sample_book_users "
				+ "(user_id, user_password, user_name, user_email) "
				+ "values "
				+ " (?,?,?,?)";
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getEmail());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<User> getAllUsers() throws Exception {
		String sql = "select * "
				   + "from sample_book_users "
				   + "order by user_id desc ";
		
		List<User> users = new ArrayList<User>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			users.add(resultSetToUser(rs));
		}
		rs.close();
		pstmt.close();
		connection.close();
		return users;
	}
	
	private User resultSetToUser(ResultSet rs) throws SQLException{
		User user = new User();
		user.setId(rs.getString("user_id"));
		user.setPassword(rs.getString("user_password"));
		user.setName(rs.getString("user_name"));
		user.setEmail(rs.getString("user_email"));
		user.setPoint(rs.getInt("user_point"));
		user.setRegisteredDate(rs.getDate("user_registered_date"));
		
		return user;
		
	}
}
