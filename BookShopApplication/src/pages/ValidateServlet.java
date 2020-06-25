package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;
@WebServlet( urlPatterns = {"/validate"}, 
			initParams = { @WebInitParam(name = "DRIVER", value = "com.mysql.cj.jdbc.Driver"),
						   @WebInitParam(name = "URL", value = "jdbc:mysql://localhost:3306/jee_online_db"),
						   @WebInitParam(name = "USER", value = "sandeep"),
						   @WebInitParam(name = "PASSWORD", value = "sandeep")})

public class ValidateServlet extends HttpServlet {
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
    	
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	try{
    		User user = dao.validate(email, password);
    		response.setContentType("text/html");
    		try( PrintWriter out = response.getWriter()){
    			out.println("<html>");
    			out.println("<head>");
    			out.println("<title>Validation Page</title>");
    			out.println("</head>");
    			out.println("<body>");
    			if( user != null ) {
        			out.println("<h3>"+user.toString()+"<h3>");
        			out.println("<h3><a href='Login.html'>Logout</a><h3>");
        		}
        		else {
        			out.println("<h3>Invalid email or password. <a href='Login.html'>Retry?</a></h3>");
        		}
    			out.println("</body>");
    			out.println("</html>");
    		}   		
    	} catch (Exception e) {
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
