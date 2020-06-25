package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
    public FirstServlet() {
       System.out.println("Inside constructor of "+this.getClass().getSimpleName());
    }

	
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		System.out.println("Inside init method of "+this.getClass().getSimpleName());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("Inside doGet of "+this.getClass().getSimpleName()+" : "+Thread.currentThread());
		response.setContentType("text/html");
		try( PrintWriter out =  response.getWriter()){
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("<H1>"+new Date()+"</h1>");
			out.println("</BODY>");
			out.println("</HTML>");
		}
	}
	
	public void destroy() {
		System.out.println("Inside destroy method of "+this.getClass().getSimpleName());
	}

}
