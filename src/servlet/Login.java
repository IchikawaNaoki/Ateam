package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
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
		//int post = Integer.parseInt(request.getParameter("post"));

		//Userインスタンス(ユーザ情報)の生成
		User user = new User(id, name, pass, (byte)0);

		//ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);


		//ログイン成功時の処理
		if(isLogin) {
			//ユーザ情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser" , user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>"
					+ "alert( \"表示テスト\");"
					+ "</script>");
		}




	}
}
