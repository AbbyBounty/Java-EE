package dao;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Book;
import utils.DBUtils;

public class BookDao implements Closeable {
	private Connection connection;
	private PreparedStatement stmtDistinctSubject;
	private PreparedStatement stmtBooksBySubject;
	private PreparedStatement stmtBookById;
	public BookDao( String driver, String url, String user, String password ) throws Exception {
		this.connection = DBUtils.getConnection(driver, url, user, password);
		this.stmtDistinctSubject = this.connection.prepareStatement("SELECT DISTINCT subject_name FROM BookTable");
		this.stmtBooksBySubject = this.connection.prepareStatement("SELECT *  FROM BookTable WHERE subject_name=?");
		this.stmtBookById = this.connection.prepareStatement("SELECT *  FROM BookTable WHERE book_id=?");
	}
	public List<String> getDistinctSubjects( )throws Exception{
		List<String> subjectList = new ArrayList<>();
		try( ResultSet rs = this.stmtDistinctSubject.executeQuery()){
			while( rs.next()) {
				String subjectName = rs.getString("subject_name");
				subjectList.add(subjectName);
			}
		}
		return subjectList;
	}
	public List<Book> getBooks(String subject) throws Exception{
		this.stmtBooksBySubject.setString(1, subject);
		List<Book> bookList = new ArrayList<>();
		try( ResultSet rs = this.stmtBooksBySubject.executeQuery()){
			while( rs.next()) {
				Book book = new Book(rs.getInt("book_id"), rs.getString("subject_name"),rs.getString("book_name"),rs.getString("author_name"),rs.getFloat("price"));
				bookList.add(book);
			}
		}
		return bookList;
	}
	public Book getBook(Integer bookId) throws Exception{
		this.stmtBookById.setInt(1, bookId);
		try( ResultSet rs = this.stmtBookById.executeQuery()){
			if( rs.next()) {
				return new Book(rs.getInt("book_id"), rs.getString("subject_name"),rs.getString("book_name"),rs.getString("author_name"),rs.getFloat("price"));
			}
		}
		return null;
	}
	public void close() throws IOException 
	{
		try {
			this.connection.close();
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}
	
	
}
