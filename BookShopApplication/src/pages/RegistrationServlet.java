package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;
@WebServlet(urlPatterns = "/register",
		   initParams = { @WebInitParam(name = "DRIVER", value = "com.mysql.cj.jdbc.Driver"),
		   @WebInitParam(name = "URL", value = "jdbc:mysql://localhost:3306/jee_online_db"),
		   @WebInitParam(name = "USER", value = "sandeep"),
		   @WebInitParam(name = "PASSWORD", value = "sandeep")})
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		try {
//			String driver = config.getInitParameter("DRIVER");
//			String url = config.getInitParameter("URL");
//			String user = config.getInitParameter("USER");
//			String password = config.getInitParameter("PASSWORD");
//			this.dao = new UserDao(driver, url, user, password);
//		} catch (Exception e) {
//			throw new ServletException(e);
//		}
//	}
	@Override
	public void init() throws ServletException {
		try {
			ServletConfig config = this.getServletConfig();
			String driver = config.getInitParameter("DRIVER");
			String url = config.getInitParameter("URL");
			String user = config.getInitParameter("USER");
			String password = config.getInitParameter("PASSWORD");
			this.dao = new UserDao(driver, url, user, password);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			User user = new User();
			user.setFullName( request.getParameter("fullName"));
			user.setEmail( request.getParameter("email") );
			user.setPassword(request.getParameter("password"));
			user.setBirthDate(Date.valueOf(request.getParameter("birthDate")));
			dao.register( user );
			
			response.setContentType("text/html");
			try( PrintWriter out = response.getWriter()){
				out.println("<html>");
    			out.println("<head>");
    			out.println("<title>Registration Servlet</title>");
    			out.println("</head>");
    			out.println("<body>");
    			out.println("<h3>Registration is successful.<a href='Login.html'>Click here</a> to login.<h3>");
    			out.println("</body>");
    			out.println("</html>");
			}
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}
	  @Override
    public void destroy()throws RuntimeException  {
    	try {
			this.dao.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
}
