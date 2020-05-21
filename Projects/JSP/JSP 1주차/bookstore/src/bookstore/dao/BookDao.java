package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.BookDetailDto;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.Book;

public class BookDao {

	public BookDetailDto getBookByNo(int bookNo) throws SQLException {
		BookDetailDto book = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("book.getBookByNo"));
		pstmt.setInt(1, bookNo);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setWriter(rs.getString("book_writer"));
			book.setPublisher(rs.getString("book_publisher"));
			book.setPoint(rs.getDouble("book_point"));
			book.setReviewCnt(rs.getInt("review_cnt"));
			book.setPrice(rs.getInt("book_price"));
			book.setDiscountPrice(rs.getInt("book_discount_Price"));
			book.setLikes(rs.getInt("book_likes"));
			book.setStock(rs.getInt("book_stock"));
		}
		return book;
	}
	
	public List<Book> getNewBooks() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("book.getNewBooks"));
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Book book = new Book();
			book.setNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("book_title"));
			book.setWriter(rs.getString("book_writer"));
			book.setPrice(rs.getInt("book_price"));
			
			books.add(book);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return books;
	}
}
