package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDao;
import pojo.Book;

public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookDao dao;

	@Override
	public void init() throws ServletException {
		
		try {
			this.dao = new BookDao();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		List<Integer> bookCart = (List<Integer>) session.getAttribute("BookCart");
		
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			out.println("<HTML>");
			out.println("<HEAD>");
			out.println("<TITLE>Show Cart Servlet Page</TITLE>");
			out.println("</HEAD>");
			out.println("<BODY>");
			out.println("<FORM action='logout' method='post'>");
			out.println("Following item(s) are in the cart<br/>");
			out.println("<hr/>");
			for( Integer bookId : bookCart ) {
				Book book = this.dao.getBook( bookId );
				out.println("<h3>"+book.toString()+"</h3><br/>");
			}
			out.println("<hr/>");
			out.println("<INPUT type='submit' value='Logout'/>");
			out.println("</FORM>");
			out.println("</BODY>");
			out.println("</HTML>");
		}
		catch( Exception ex ) {
			throw new ServletException(ex);
		}
	}
	@Override
    public void destroy()throws RuntimeException  {
    	try {
			this.dao.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
}
