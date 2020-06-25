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
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = "";
		HttpSession session = request.getSession();
		name = (String) session.getAttribute("UName");
		session.invalidate();
		
		ServletContext application = this.getServletContext();
		String userName = (String) application.getAttribute("UserName");
		
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Second Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Hello, From Second Page</h1>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
