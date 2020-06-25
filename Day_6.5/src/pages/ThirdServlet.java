package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet( "/third")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = "";
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Third Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			name = (String) request.getAttribute("UserName");
			out.println("<h3>Request Scope : "+name+"</h3></br>");
			
			HttpSession session = request.getSession();
			name =  (String) session.getAttribute("UserName" );
			out.println("<h3>Session Scope : "+name+"</h3></br>");
			
			ServletContext application = this.getServletContext();
			name =  (String) application.getAttribute("UserName");
			out.println("<h3>Application Scope : "+name+"</h3></br>");

			out.println("</body>");
			out.println("</html>");
		}
	}
}
