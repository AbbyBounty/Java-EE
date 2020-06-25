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

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			out.println("<HTML>");
			out.println("<HEAD>");
			out.println("<TITLE>Logout Servlet Page</TITLE>");
			out.println("</HEAD>");
			out.println("<BODY>");
			out.println("<h3> Thank you for shopping.Visit again</h3>");
			out.println("</BODY>");
			out.println("</HTML>");
		}
	}
}
