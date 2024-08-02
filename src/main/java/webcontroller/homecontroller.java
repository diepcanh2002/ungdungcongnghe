package webcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import models.User;

/**
 * Servlet implementation class homecontroller
 */
@WebServlet(urlPatterns = { "/trang-chu"})
public class homecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public homecontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null) {
			if(user.getRole()==1) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/admin-home.jsp");
				rd.forward(request, response);
			}
			if(user.getRole()==2) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/manager/manager-home.jsp");
				rd.forward(request, response);
			}
			if(user.getRole()==3) {
				RequestDispatcher rd = request.getRequestDispatcher("/views/customer/customer-home.jsp");
				rd.forward(request, response);
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		UserDAO usDao = new UserDAO();
//		User user = usDao.findUSerByUserNameAndPassword(username, password);
//		if (user != null) {
//			if (user.getRole() == 1) {
//				response.sendRedirect("/views/admin/admin-home.jsp");
//			}
//			if (user.getRole() == 2) {
//				response.sendRedirect("/views/manager/manager-home.jsp");
//			}
//			if (user.getRole() == 3) {
//				response.sendRedirect("/views/customer/customer-home.jsp");
//			}
//		}
	}

}
