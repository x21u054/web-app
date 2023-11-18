package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.SendEmail;
import bo.Utility;
import dao.ForgetPasswordDao;
import dao.UserDao;
import entity.ForgetPassword;
import entity.User;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/forget-password")
public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/forgetPassword.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String email = request.getParameter("email");
		String forward = "/WEB-INF/jsp/forgetPassword.jsp";
		
		UserDao userDao = new UserDao();
		User user = userDao.findUserByEmail(email);
		
		if (user != null) {
			System.out.println("ユーザが存在します");
			
			String authToken = Utility.generateAuthToken(); // トークン生成
			
			// 有効期限を2時間後に設定する
			long tokenExpirationMillis = System.currentTimeMillis() + 2 * 60 * 60 * 1000; // 2時間分のミリ秒
			
			ForgetPasswordDao forgetPasswordDao = new ForgetPasswordDao();
			ForgetPassword forgetPassword = forgetPasswordDao.findForgetPasswordByEmail(email);
			if (forgetPassword != null) {
				//既に認証トークンが発行されているメールアドレス
				forgetPassword.setToken(authToken);
				forgetPassword.setExpiration(tokenExpirationMillis);
				
				forgetPasswordDao.update(forgetPassword);
				System.out.println("認証トークンを更新します");
			} else {				
				forgetPassword = new ForgetPassword();
				forgetPassword.setEmail(email);
				forgetPassword.setToken(authToken);
				forgetPassword.setExpiration(tokenExpirationMillis);
				
				forgetPasswordDao.insert(forgetPassword);
				System.out.println("認証トークンを新規に発行します");
			}
			
			SendEmail sendEmail = new SendEmail();
			sendEmail.execute(forgetPassword);
			
			forward = "/WEB-INF/jsp/forgetPasswordResult.jsp";	
		} else {
			System.out.println("ユーザが存在しません");
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}	
}
