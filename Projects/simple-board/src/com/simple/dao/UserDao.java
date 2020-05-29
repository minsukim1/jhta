package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.User;


public class UserDao {

	public User getUserById(String userId) throws SQLException {
		User user = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserById"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			user = new User();
			user.setUserName(rs.getString("user_name"));
			user.setUserId(rs.getString("user_id"));
			user.setUserPassword(rs.getString("user_password"));
			user.setUserEmail(rs.getString("user_email"));
			user.setUserCreateDate(rs.getDate("user_create_date"));
			user.setUserDisabled(rs.getString("user_disabled"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return user;
		
	}
	
	public void insertUser(User user) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.insertUser"));
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getUserName());
		pstmt.setString(3, user.getUserPassword());
		pstmt.setString(4, user.getUserEmail());
		
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
		
	}
}
