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
@WebServlet("/controller")
public class BookShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String location = request.getParameter("page");
			HttpSession session = request.getSession();
			String path = "WEB-INF/view/";
			
			if( location.equals("Registration"))
			{
				UserBean ub = (UserBean) session.getAttribute("ub");
				if( ub == null )
				{
					ub = new UserBean( );
					session.setAttribute("ub", ub);
				}
				ub.setFullName( request.getParameter("fullName") );
				ub.setEmail( request.getParameter("email") );
				ub.setPassword( request.getParameter("password") );
				ub.setBirthDate( request.getParameter("birthDate") );
				path = "controller?page="+ub.register();
				response.sendRedirect(path);
			}
			else if( location.equals("Validation"))
			{
				UserBean ub = (UserBean) session.getAttribute("ub");
				if( ub == null )
				{
					ub = new UserBean( );
					session.setAttribute("ub", ub);
				}
				ub.setEmail( request.getParameter("email") );
				ub.setPassword( request.getParameter("password") );
				path = "controller?page="+ub.validateUser();
				response.sendRedirect(path);
			}
			else if( location.equals("Subject"))
			{
				SubjectBean sb = (SubjectBean) session.getAttribute("sb");
				if( sb == null )
				{
					sb = new SubjectBean();
					sb.fetchSubjects();
					session.setAttribute("sb", sb);
				}
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
			}
			else if( location.equals("Cart"))
			{
				CartBean cb = (CartBean) session.getAttribute("cb");
				if( cb == null )
				{
					cb = new CartBean();
					session.setAttribute("cb", cb);
				}
				cb.setSelectedIds(request.getParameterValues("books"));
				path = "controller?page="+cb.addToCart();
				response.sendRedirect(path);
			}
			else if( location.equals("ShowCart"))
			{
				BookBean bb = (BookBean) session.getAttribute("bb");
				CartBean cb = (CartBean) session.getAttribute("cb");
				List<Book> cart = new ArrayList<>(); 
				for( int bookId : cb.getCart()) {
					bb.setBookId(bookId);
					bb.fetchBook();
					cart.add(bb.getBook());
				}
				request.setAttribute("cart", cart);
			}
			else if( location.equals("Logout"))
			{
				UserBean ub = (UserBean) session.getAttribute("ub");
				ub.close();
				BookBean bb = (BookBean) session.getAttribute("bb");
				bb.close();
				SubjectBean sb = (SubjectBean) session.getAttribute("sb");
				sb.close();
				session.invalidate(); 
			}
			if( !( location.equals("Registration") || location.equals("Validation") || location.equals("Cart") ) )
			{
				path = path.concat(location.concat(".jsp"));
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		} 
	}
}
