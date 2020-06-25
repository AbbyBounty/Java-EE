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
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = "";
		HttpSession session = request.getSession();
		if( !session.isNew() )
		{
			System.out.println("HI");
			name = (String) session.getAttribute("abc");
		}
			
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Second Servlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action='third'>");
			out.println("<h1>Welcome,"+name+"</h1>");
			out.println("<input type='submit' value='Submit'>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
