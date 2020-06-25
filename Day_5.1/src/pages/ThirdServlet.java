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
@WebServlet( "/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = "";
		Cookie[] cookies = request.getCookies();
		if( cookies != null ) {
			for (Cookie cookie : cookies) {
				if( cookie.getName().equals("Name")) {
					name = cookie.getValue();
					break;
				}
			}
		}
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Third Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Welcome,"+name+"</h1>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
