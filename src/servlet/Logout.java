package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConnDbDao;
import model.User;

@WebServlet("/Logout")
public class Logout  extends HttpServlet
{
	private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			//アプリケーションスコープを取得
			ServletContext application = this.getServletContext();
			User user = (User)application.getAttribute("loginUser");

			//ログインフラグを0にする
			ConnDbDao conn = new ConnDbDao();
			List<User> listUser = conn.ConDbLogin(user);
			if( listUser.get(0).getNowLogin().equals((byte)1) ) //ログインフラグをみる
			{
				conn.ConnDbLoginLogout(0 ,listUser.get(0).getPass());
				System.out.println(listUser.get(0).getName()+"のログインフラグ下すっぺよ");
			}else {
				System.out.println(listUser.get(0).getName()+"はログインしてないっぺよ"+ listUser.get(0).getNowLogin());
				//return null;
			}

			//セッションスコープを破棄
			HttpSession session = request.getSession();
			session.invalidate();
			//session.removeAttribute(name);

			//ログアウト画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logOut.jsp");
			dispatcher.forward(request, response);
		}
}
