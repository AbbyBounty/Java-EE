package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;

public class SubjectServlet extends HttpServlet {
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
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			List<String> sbList = this.dao.getDistinctSubjects();
			out.println("<HTML>");
			out.println("<HEAD>");
			out.println("<TITLE>Subject Servlet Page</TITLE>");
			out.println("</HEAD>");
			out.println("<BODY>");
			out.println("<FORM action='book' method='post'>");
			for( String subjectName : sbList ) {
				out.println("<input type='radio' name='subject' value='"+subjectName+"'/>"+subjectName+"<br/>");
			}
			out.println("<INPUT type='submit' value='Show Books'/>");
			out.println("<INPUT type='submit' value='Show cart' formaction='showcart'/>");
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
