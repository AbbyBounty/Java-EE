package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("username");
		System.out.println(name);
		HttpSession session = request.getSession();
		session.setAttribute("username", name);
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>First Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='second'>");
			out.println("<h1>Welcome,"+name+"</h1>");
			out.println("<input type='submit' value='Submit'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
