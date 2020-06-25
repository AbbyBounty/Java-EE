package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BookBean;
import beans.CartBean;
import beans.SubjectBean;
import beans.UserBean;
import pojo.Book;

/**
 * Servlet implementation class BookShopController
 */
@WebServlet("/controller")
public class BookShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		processRequest(request, response);
	}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	String location = request.getParameter("page");
		String path = "WEB-INF/jsp/";
    	try {
			
			if( location.equals("Index"))
				path = path.concat("Index.jsp");
			else if( location.equals("NewUser"))
				path = path.concat("NewUser.jsp");
			else if( location.equals("Registration")){
				UserBean ub = new UserBean(request.getParameter("fullName"),request.getParameter("email"),request.getParameter("password"),request.getParameter("birthDate"));
				path = "controller?page="+ub.register();
				response.sendRedirect(response.encodeRedirectURL(path));
				ub.close();
			}
			else if( location.equals("Login"))
				path = path.concat("Login.jsp");
			else if( location.equals("Validation")){
				UserBean ub = new UserBean();
				ub.setEmail(request.getParameter("email"));
				ub.setPassword(request.getParameter("password"));
				path = "controller?page="+ub.validateUser();
				response.sendRedirect(response.encodeRedirectURL(path));
				ub.close();
			}
			else if( location.equals("Subject"))
			{
				SubjectBean sb = (SubjectBean) session.getAttribute("sb");
				if( sb == null )
				{
					sb = new SubjectBean( );
					sb.fetchSubjects();
					session.setAttribute("sb", sb);
				}
				path = path.concat("Subject.jsp");
				
			}
			else if( location.equals("Book"))
			{
				BookBean bb = (BookBean) session.getAttribute("bb");
				if( bb == null )
				{
					bb = new BookBean();
					session.setAttribute("bb", bb);
				}
				bb.setSubject(request.getParameter("subject"));
				bb.fetchBooks();
				
				path = path.concat("Book.jsp");
			}
			else if( location.equals("Cart")){
				CartBean cb = (CartBean) session.getAttribute("cb");
				if( cb == null )
				{
					cb = new CartBean();
					session.setAttribute("cb", cb);
				}
				cb.setSelectedIds(request.getParameterValues("books"));
				path = "controller?page="+cb.addToCart();
				
				response.sendRedirect(response.encodeRedirectURL(path));
			}
			else if( location.equals("ShowCart"))
			{
				List<Book> bookCart = new ArrayList<Book>( );
				CartBean cb = (CartBean) session.getAttribute("cb");
				BookBean bb = (BookBean) session.getAttribute("bb");
				for( int id : cb.getCart()) {
					bb.setBookId(id);
					bb.fetchBook();
					bookCart.add(bb.getBook());
				}
				session.setAttribute("BookCart", bookCart);
				path = path.concat("ShowCart.jsp");
			}
			else if( location.equals("Logout"))
			{
				SubjectBean sb = (SubjectBean) session.getAttribute("sb");
				BookBean bb = (BookBean) session.getAttribute("bb");
				sb.close();
				bb.close();
				session.invalidate();
				
				path = path.concat("Logout.jsp");
			}
			else if( location.equals("ErrorPage"))
				path = path.concat("ErrorPage.jsp");
			if( !( location.equals("Registration") || location.equals("Validation") || location.equals("Cart") ) )
			{
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
