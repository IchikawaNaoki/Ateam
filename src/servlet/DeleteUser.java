package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/RegisterUser")


public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決定するactionの値をリクエストパラメータから取得
		String action = request.getParameter("action");

		//登録の開始をリクエストされた時の処理
		if(action == null)
			forwardPath = "/WEB-INF/jsp/deleteForm.jsp";

		//登録確認画面から「登録実行」をリクエストされたときの処理
		else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("deleteUser");


			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("registerUser");

			//登録後のフォワード先を指定
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
		}

		//設定されたフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//社員ID、名前、パスワード、部署
		//intにgetparameteerないんでparse
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String post = request.getParameter("post");


		User deleteUser = new User(id , name , pass , post);

		//セッションスコープに削除ユーザの情報を設定
		HttpSession session = request.getSession();
		session.setAttribute("deleteUser" , deleteUser);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteConfirm.jsp");
		dispatcher.forward(request, response);
	}
}
