package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import pojo.User;

public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao dao;

	@Override
	public void init() throws ServletException {
		
		try {
			this.dao = new UserDao();
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
    				
    				List<Integer> bookCart = new ArrayList<>( );
    				HttpSession session = request.getSession();
    				session.setAttribute("BookCart", bookCart);
    				
    				String location = response.encodeRedirectURL("subject");
        			response.sendRedirect(location);
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
