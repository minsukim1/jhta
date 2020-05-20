package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.util.ConnectionUtil;
import com.sample.vo.Book;

public class BookDao {

	public void insertBook(Book book) throws SQLException {
		String sql = "insert into sample_books "
					+ "(book_no, book_title, book_writer, book_genre, "
					+ " book_publisher, book_price, book_discount_price, book_stock) "
					+ "values "
					+ " (sample_book_seq.nextval, ?,?,?,?,?,?,?)";
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getWriter());
		pstmt.setString(3, book.getGenre());
		pstmt.setString(4, book.getPublisher());
		pstmt.setInt(5, book.getPrice());
		pstmt.setInt(6, book.getDiscountPrice());
		pstmt.setInt(7, book.getStock());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	public List<Book> getAllBooks() throws Exception {
		String sql = "select * "
				   + "from sample_books "
				   + "order by book_no desc ";
		
		List<Book> books = new ArrayList<Book>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			books.add(resultSetToBook(rs));
		}
		rs.close();
		pstmt.close();
		connection.close();
		return books;
	}
	private Book resultSetToBook(ResultSet rs) throws SQLException {
		Book book = new Book();
		book.setNo(rs.getInt("book_no"));
		book.setTitle(rs.getString("book_title"));
		book.setWriter(rs.getString("book_writer"));
		book.setGenre(rs.getString("book_genre"));
		book.setPublisher(rs.getString("book_publisher"));
		book.setPrice(rs.getInt("book_price"));
		book.setDiscountPrice(rs.getInt("book_discount_Price"));
		book.setRegisteredDate(rs.getDate("book_registered_date"));
		book.setStock(rs.getInt("book_stock"));
		return book;
	}
	
}
