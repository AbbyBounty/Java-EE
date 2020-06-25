package beans;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import dao.BookDao;
import pojo.Book;

public class BookBean implements Serializable, Closeable {
	private String subject;
	private BookDao dao;
	private List<Book> bookList;
	private int bookId;
	private Book book;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public BookDao getDao() {
		return dao;
	}
	public void setDao(BookDao dao) {
		this.dao = dao;
	}
	public List<Book> getBookList() {
		return bookList;
	}
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookBean() throws Exception{
		this.dao = new BookDao();
	}
	public void fetchBooks( )throws Exception{
		this.bookList = this.dao.getBooks(subject);
	}
	public void fetchBook( ) throws Exception{
		this.book  = this.dao.getBook(this.bookId);
	}
	@Override
	public void close() throws IOException {
		this.dao.close();
	}
}
