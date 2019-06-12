//プログラム名 :	在籍管理アプリケーション

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

import model.UpdateUserLogic;
import model.User;

//-------------------------------------------------------------------------------------------------------------
//アノテーション
//-------------------------------------------------------------------------------------------------------------
@WebServlet("/UpdateUser")

//-------------------------------------------------------------------------------------------------------------
//UpdateUserクラス
//-------------------------------------------------------------------------------------------------------------
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決定するactionの値をリクエストパラメータから取得
		String action = request.getParameter("action");

		//更新の開始をリクエストされた時の処理
		if(action == null)
			forwardPath = "/WEB-INF/jsp/updateForm.jsp";

		//更新確認画面から「更新実行」をリクエストされたときの処理
		else if(action.equals("done")) {
			HttpSession session = request.getSession();
			User updateUser = (User)session.getAttribute("updateUser");

			//更新処理の呼び出し
			UpdateUserLogic updateUserLogic = new UpdateUserLogic();
			boolean isUpdate = updateUserLogic.execute(updateUser);

			if(!isUpdate) {
				JOptionPane.showMessageDialog(null , "更新に失敗しました。");
			}

			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("updateUser");

			//更新後のフォワード先を指定
			forwardPath = "/WEB-INF/jsp/updateDone.jsp";
		}

		//設定されたフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//社員ID、名前、パスワード、部署
		//intにgetparameterないんでparse
		String strId = request.getParameter("PersonalID");
		int id = Integer.parseInt(strId);
		String name = request.getParameter("PersonalName");
		String department = request.getParameter("Pass");
		String nowLogin = request.getParameter("LoginFlag");
		byte post = Byte.parseByte(nowLogin);

		//更新するユーザの情報を設定
		User updateUser = new User(id , name , department , post);

		//セッションスコープに登録ユーザの情報を設定
		HttpSession session = request.getSession();
		session.setAttribute("updateUser" , updateUser);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateConfirm.jsp");
		dispatcher.forward(request, response);
	}
}

