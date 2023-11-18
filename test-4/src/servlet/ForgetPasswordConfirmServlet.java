package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Utility;
import dao.ForgetPasswordDao;
import dao.UserDao;
import entity.ForgetPassword;
import entity.User;

/**
 * Servlet implementation class ForgetPasswordConfirmServlet
 */
@WebServlet("/forget-password-confirm")
public class ForgetPasswordConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String token = request.getParameter("token");

		ForgetPasswordDao forgetPasswordDao = new ForgetPasswordDao();
		ForgetPassword forgetPassword = forgetPasswordDao.findForgetPasswordByToken(token);

		String forward = "/WEB-INF/jsp/index.jsp";
		if (forgetPassword != null) {
			long tokenExpirationMillis = forgetPassword.getExpiration();
			
			long currentTimestamp = System.currentTimeMillis();
			
			// トークンの有効期限内かどうかを判定
			if (currentTimestamp < tokenExpirationMillis) {
			    System.out.println("トークンは有効です。");

			    System.out.println("email: " + forgetPassword.getEmail());
			    
				HttpSession session = request.getSession();
				session.setAttribute("email", forgetPassword.getEmail());
				
				forward = "/WEB-INF/jsp/forgetPasswordConfirm.jsp";
			} else {
			    System.out.println("トークンは有効期限切れです。");
			}			
		} else {
			//認証トークンが存在しない
			System.out.println("認証トークンが存在しません");
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		System.out.println("ForgetPasswordConfirmServlet email: " + email);
		
		password = Utility.hashPassword(password);
		System.out.println(password);
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		UserDao userDao = new UserDao();
		userDao.update(user);

		request.getRequestDispatcher("/WEB-INF/jsp/forgetPasswordConfirmResult.jsp").forward(request, response);
	}
}
