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
 * Servlet implementation class logincontroller
 */
@WebServlet("/login")
public class logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect(request.getContextPath()+"/views/login.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserDAO usDao = new UserDAO();
		User user = usDao.findUSerByUserNameAndPassword(username, password);
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		System.out.println(user.getRole());
		response.sendRedirect(request.getContextPath()+"/trang-chu");
//		RequestDispatcher rd = request.getRequestDispatcher("trang-chu");
//		rd.forward(request, response);
	}

}
