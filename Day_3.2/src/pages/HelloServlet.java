package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesRequest(request, response);
	}
	protected void procesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String[] preferences = request.getParameterValues("language");
		String preference = request.getParameter("rd");
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter())
		{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Hello Servlet</title>");
			out.println("<body>");
			out.println("<h2>Hello,"+userName+"</h2><br/>");
			out.println("<h2>Preferences,"+Arrays.toString(preferences)+"</h2><br/>");
			out.println("<h2>Preference,"+preference+"</h2><br/>");
			out.println("</body>");
			out.println("<head>");
			
			// int arr[ 3 ];
			int[] arr = new int[ 3 ];
			
			
		}
	}
}
