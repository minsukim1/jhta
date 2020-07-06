package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.TodoDto;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Todo;

public class TodoDao {

	public List<TodoDto> getRecentTodos() throws SQLException {
		List<TodoDto> todos = new ArrayList<TodoDto>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("todo.getRecentTodos"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			TodoDto dto = new TodoDto();
			dto.setNo(rs.getInt("todo_no"));
			dto.setTitle(rs.getString("todo_title"));
			dto.setContent(rs.getString("todo_content"));
			dto.setDay(rs.getDate("todo_day"));
			dto.setCompletedDay(rs.getDate("todo_completed_day"));
			dto.setStatus(rs.getString("todo_status"));
			dto.setCreateDate(rs.getDate("todo_created_date"));
			dto.setUserId(rs.getString("user_id"));
			dto.setUserName(rs.getString("user_name"));
			
			todos.add(dto);
		}
		connection.close();
		pstmt.close();
		rs.close();
		
		return todos;
	}
}
