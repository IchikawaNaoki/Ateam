package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetDB;
import model.GetDbListLogic;
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

		GetDbListLogic getDbListLogic = new GetDbListLogic();
		List<GetDB> getDbList = getDbListLogic.execute();
		request.setAttribute("getDbList", getDbList);

		//ログイン成功時の処理
		if(isLogin != null) {

			//ユーザ情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser" , isLogin.get(0));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}






	}
}
