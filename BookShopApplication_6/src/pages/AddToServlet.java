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

public class AddToServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Integer> bookCart = (List<Integer>) session.getAttribute("BookCart");
		String[] selectedBookIds = request.getParameterValues("books");
		for (String selectedBookId : selectedBookIds) {
			int bookId = Integer.parseInt(selectedBookId);
			bookCart.add(bookId);
		}
		String location = response.encodeRedirectURL("subject");
		response.sendRedirect(location);
	}
}
