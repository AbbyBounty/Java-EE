package errors;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/error")
public class ErrorPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processError(request, response);
	}
	protected void processError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		
		response.setContentType("text/html");
		try( PrintWriter out = response.getWriter())
		{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Exception Page</title>");
			out.println("</head>");
			out.println("<body>");
			if( statusCode != 500 ) {
				out.write("<h3>Error Details</h3>");
		    	out.write("<strong>Status Code</strong>:"+statusCode+"<br>");
		    	out.write("<strong>Requested URI</strong>:"+requestUri);
			}
			else {
				out.println("<h3>Exception Details</h3>");
				out.println("<ul>");
				out.println("<li>Servlet Name:"+servletName+"</li>");
				out.println("<li>Exception Name:"+throwable.getClass().getSimpleName()+"</li>");
				out.println("<li>Requested URI:"+requestUri+"</li>");
				out.println("<li>Exception Message:"+throwable.getMessage()+"</li>");
				out.println("</ul>");
			}
			out.println("</body>");
			out.println("</html>");
		}
	}
}
