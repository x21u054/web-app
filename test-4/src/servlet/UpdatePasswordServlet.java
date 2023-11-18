package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.Utility;
import entity.User;

/**
 * Servlet implementation class UpdatePasswordServlet
 */
@WebServlet("/updatePassword")
public class UpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("ユーザのセッションを確認します");
		
		String forward = "/WEB-INF/jsp/login.jsp";
		if (user != null) {
			System.out.println("セッションがあります");
			forward = "/WEB-INF/jsp/updatePassword.jsp";
		} else {
			System.out.println("セッションがありません");
		}

		request.getRequestDispatcher(forward).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("ユーザのセッションを確認します");
		
		String forward = "/WEB-INF/jsp/login.jsp";
		if (user != null) {
			System.out.println("セッションがあります");

			request.setCharacterEncoding("UTF-8");
			String oldPassword = request.getParameter("old_password");
			String NewPassword = request.getParameter("new_password");
			
			//パスワード認証を実施
			Boolean isValid = Utility.verifyPassword(oldPassword, user.getPassword());
			System.out.println("isValid: " + isValid);
			if (isValid) {
				//新しいパスワードに更新
				user.setPassword(NewPassword);
				
				session.setAttribute("user", user);
				forward = "/WEB-INF/jsp/updatePasswordResult.jsp";
			} else {
				//パスワードが異なる
				System.out.println("パスワードが異なっています");
			}
		} else {
			System.out.println("セッションがありません");
		}

		request.getRequestDispatcher(forward).forward(request, response);
	}
}
