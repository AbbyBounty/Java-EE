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
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>First Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Welcome,"+name+"</h1>");
			//URL?key1=val1 & key2=value2;
			out.println("<a href='second?Name="+name+"'>Click Here</a>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
