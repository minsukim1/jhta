package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Board;

public class BoardDao {

	
	public void insertBoard(Board board) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.insertBoard"));
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setString(3, board.getWriter());
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
	}
	
	public List<Board> getAllBoards() throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllBoards"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			board.setBoardCreateDate(rs.getDate("board_create_date"));
			board.setContent(rs.getString("board_content"));
			board.setDelYn(rs.getString("board_del_yn"));
			board.setHit(rs.getInt("board_hit"));
			board.setNo(rs.getInt("board_no"));
			board.setReplyCnt(rs.getInt("board_reply_cnt"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			
			boards.add(board);
		}
		connection.close();
		pstmt.close();
		rs.close();
		return boards;
	}
	
	public List<Board> getAllBoardByUserId(String userId) throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllBoardByUserId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			board.setBoardCreateDate(rs.getDate("board_create_date"));
			board.setContent(rs.getString("board_content"));
			board.setDelYn(rs.getString("board_del_yn"));
			board.setHit(rs.getInt("board_hit"));
			board.setNo(rs.getInt("board_no"));
			board.setReplyCnt(rs.getInt("board_reply_cnt"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			
			boards.add(board);
		}
		connection.close();
		pstmt.close();
		rs.close();
		return boards;
	}
	
	public Board getBoardByNo(int boardNo) throws SQLException {
		Board board = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getBoardByNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			board = new Board();
			board.setBoardCreateDate(rs.getDate("board_create_date"));
			board.setContent(rs.getString("board_content"));
			board.setDelYn(rs.getString("board_del_yn"));
			board.setHit(rs.getInt("board_hit"));
			board.setNo(rs.getInt("board_no"));
			board.setReplyCnt(rs.getInt("board_reply_cnt"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
		}
		connection.close();
		pstmt.close();
		rs.close();
		return board;
	}
	public void updateHitByNo(int boardNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateHitByNo"));
		pstmt.setInt(1, boardNo);
		
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();
	}
	public void deleteBoardByNo(int boardNo) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.deleteBoardByNo"));
		pstmt.setInt(1, boardNo);
		
		pstmt.executeUpdate();
		
		connection.close();
		pstmt.close();	
	}
	public void modifyBoardByNo(Board board) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.modifyBoardByNo"));
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getNo());
		
		pstmt.executeUpdate();
		connection.close();
		pstmt.close();	
	}
}
