//プログラム名 :	在籍管理アプリケーション
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

import model.DeleteUserLogic;
import model.User;

//-------------------------------------------------------------------------------------------------------------
//アノテーション
//-------------------------------------------------------------------------------------------------------------
@WebServlet("/DeleteUser")

//-------------------------------------------------------------------------------------------------------------
//DeleteUserクラス
//-------------------------------------------------------------------------------------------------------------
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決定するactionの値をリクエストパラメータから取得
		String action = request.getParameter("action");

		//削除の開始をリクエストされた時の処理
		if(action == null)
			forwardPath = "/WEB-INF/jsp/deleteForm.jsp";

		//削除確認画面から「削除実行」をリクエストされたときの処理
		else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User deleteUser = (User)session.getAttribute("deleteUser");

			//削除処理の呼び出し
			DeleteUserLogic deleteUserLogic = new DeleteUserLogic();
			boolean isDelete = deleteUserLogic.execute(deleteUser);

			if(!isDelete) {
				JOptionPane.showMessageDialog(null , "ユーザーIDとパスワードが一致しません");
			}

			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("deleteUser");

			//削除後のフォワード先を指定
			forwardPath = "/WEB-INF/jsp/deleteDone.jsp";
		}

		//設定されたフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//社員ID、名前、パスワード、ログイン状況
		//intにgetparameterないんでparse
		String strId = request.getParameter("PersonalID");
		int id = Integer.parseInt(strId);
		String pass = request.getParameter("Pass");

		//削除するユーザの情報を設定
		User deleteUser = new User(id , pass );

		//セッションスコープに削除ユーザーの情報を設定
		HttpSession session = request.getSession();
		session.setAttribute("deleteUser" , deleteUser);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/deleteConfirm.jsp");
		dispatcher.forward(request, response);
	}
}
