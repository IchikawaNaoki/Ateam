//-------------------------------------------------------------------------------------------------------------
//プログラム名 :	在籍管理アプリケーション
//ファイル名 :		RegisterUser.java
//作成者	:			システム部 髙橋晟太
//作成日	:			2019/06/04
//更新日	:			2019/06/05 髙橋晟太
//-------------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------
//パッケージ
//-------------------------------------------------------------------------------------------------------------
package servlet;

//-------------------------------------------------------------------------------------------------------------
//インポート
//-------------------------------------------------------------------------------------------------------------
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import model.RegisterUserLogic;
import model.User;

//-------------------------------------------------------------------------------------------------------------
//アノテーション
//-------------------------------------------------------------------------------------------------------------
@WebServlet("/RegisterUser")

//-------------------------------------------------------------------------------------------------------------
//RegisterUserクラス
//-------------------------------------------------------------------------------------------------------------
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決定するactionの値をリクエストパラメータから取得
		String action = request.getParameter("action");

		//登録の開始をリクエストされた時の処理
		if(action == null)
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";

		//登録確認画面から「登録実行」をリクエストされたときの処理
		else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User registerUser = (User)session.getAttribute("registerUser");

			//登録処理の呼び出し
			RegisterUserLogic registerUserLogic = new RegisterUserLogic();
			boolean isRegister = registerUserLogic.execute(registerUser);

			if(!isRegister) {
				JOptionPane.showMessageDialog(null , "登録に失敗しました。");
			}

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
		//intにgetparameterないんでparse
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String post = request.getParameter("post");

		//登録するユーザの情報を設定
		User registerUser = new User(id , name , pass , post);

		//セッションスコープに登録ユーザーの情報を設定
		HttpSession session = request.getSession();
		session.setAttribute("registerUser" , registerUser);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registerConfirm.jsp");
		dispatcher.forward(request, response);
	}
}
