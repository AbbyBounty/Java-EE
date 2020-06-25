package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
			
		String name = request.getParameter("uname");
		
		request.setAttribute("UserName", name );
		
		HttpSession session = request.getSession();
		session.setAttribute("UserName", name );
		
		ServletContext application = this.getServletContext();
		application.setAttribute("UserName", name );
		
		//response.sendRedirect("second");
		
		RequestDispatcher rd = request.getRequestDispatcher("second");
		rd.forward(request, response);
	}	
	
}
