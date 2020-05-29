package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Reply;

public class ReplyDao {

	public void insertReply (Reply reply) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.insertReply"));
		pstmt.setString(1, reply.getWriter());
		pstmt.setString(2, reply.getContent());
		pstmt.setInt(3, reply.getBoardNo());
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
	}
	
	public List<Reply> getAllReplyByBoardNo(int boardNo) throws SQLException {
		List<Reply> replys = new ArrayList<Reply>();
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.getAllReplyByBoardNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Reply reply = new Reply();
			reply.setBoardNo(rs.getInt("board_no"));
			reply.setContent(rs.getString("reply_content"));
			reply.setDelYn(rs.getString("reply_del_yn"));
			reply.setNo(rs.getInt("reply_no"));
			reply.setReplyCreateDate(rs.getDate("reply_create_date"));
			reply.setWriter(rs.getString("reply_writer"));
			
			replys.add(reply);
		}
		rs.close();
		connection.close();
		pstmt.close();
		
		return replys;
	}
}