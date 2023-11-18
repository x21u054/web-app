package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.SendEmail;
import bo.Utility;
import dao.EmailVerifyDao;
import dao.UserDao;
import entity.EmailVerify;
import entity.User;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/email-verify")
public class EmailVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailVerifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/emailVerify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
		UserDao userDao = new UserDao();
		User user = userDao.findUserByEmail(email);
		String forward = "/WEB-INF/jsp/emailVerify.jsp";
		if (user != null) {
			//既に登録されているメールアドレス
		} else {
			String authToken = Utility.generateAuthToken(); // トークン生成

			// 有効期限を2時間後に設定する
			long tokenExpirationMillis = System.currentTimeMillis() + 2 * 60 * 60 * 1000; // 2時間分のミリ秒

			EmailVerifyDao emailVerifyDao = new EmailVerifyDao();
			EmailVerify emailVerify = emailVerifyDao.findEmailVerifyByEmail(email);
			if (emailVerify != null) {
				//既に認証トークンが発行されているメールアドレス
				emailVerify.setToken(authToken);
				emailVerify.setExpiration(tokenExpirationMillis);
				
				emailVerifyDao.update(emailVerify);
				System.out.println("認証トークンを更新します");
			} else {				
				emailVerify = new EmailVerify();
				emailVerify.setEmail(email);
				emailVerify.setToken(authToken);
				emailVerify.setExpiration(tokenExpirationMillis);
				
				emailVerifyDao.insert(emailVerify);
				System.out.println("認証トークンを新規に発行します");
			}

			SendEmail sendEmail = new SendEmail();
			sendEmail.execute(emailVerify);

			forward = "/WEB-INF/jsp/emailVerifyResult.jsp";
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}
}