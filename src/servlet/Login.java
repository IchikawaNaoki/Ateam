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
			if(str.equals("")) {
				id=-1;
			}
			else {
				id = Integer.parseInt(str);
			}
		}
		catch(NumberFormatException e) {

		}
		catch(NullPointerException e) {
			id = 0;
		}
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		//アプリケーションスコープの取得
		ServletContext application = this.getServletContext();
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("pass", pass);

		if((id!=0)&&(id!=(-1)))
		{
			//Userインスタンス(ユーザ情報)の生成
			User user = new User(id, name, pass, (byte)0);
			//ログイン処理
			LoginLogic loginLogic = new LoginLogic();
			List<User> isLogin = loginLogic.execute(user);

			//ログイン成功時の処理
			if(isLogin != null) {
				List<GetDB> list = new ConnDbDao().ConnDbUserInfo(isLogin.get(0).getId());
				application.setAttribute("loginUser" , isLogin.get(0));
				System.out.println(list.get(0).getBelong());
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);
			}
			else {
				session.setAttribute("id",str);
				session.setAttribute("pass", pass);
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			session.setAttribute("id",str);
			session.setAttribute("pass", pass);
			//フォワード
			response.sendRedirect("./");
		}

	}
}

