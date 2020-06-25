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
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public TestServlet() {
        super();
        System.out.println("Inside ctor of "+this.getClass().getName());
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("Inside init method of "+this.getClass().getName());
	}

	
	public void destroy() {
		System.out.println("Inside destroy method of "+this.getClass().getName());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet method of "+this.getClass().getName());
		response.setContentType("text/html");
		try( PrintWriter out  = response.getWriter()){
			out.println("<html>");
			out.println("<body>");
			out.println("<h2>"+new Date()+"<h2>");
			out.println("</body>");
			out.println("</html>");
			
		}
	}

}
