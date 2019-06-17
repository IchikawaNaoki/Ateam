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

import dao.ConnDbDao;
import model.GetDB;
import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得

		String str=request.getParameter("id");
		int id=0;
		try {
			System.out.println(str);
			id = Integer.parseInt(str);
		}
		catch(NumberFormatException e) {

		}

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		//Userインスタンス(ユーザ情報)の生成
		User user = new User(id, name, pass, (byte)0);

		//ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		List<User> isLogin = loginLogic.execute(user);



		//アプリケーションスコープの取得
		ServletContext application = this.getServletContext();

		//ログイン成功時の処理
		if(isLogin != null) {
			List<GetDB> list= new ConnDbDao().ConnDbUserInfo(isLogin.get(0).getId());
			application.setAttribute("loginUser" , isLogin.get(0));

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
		else {
			application.setAttribute("status", "ID");
            response.sendRedirect("./");
		}
	}
}

