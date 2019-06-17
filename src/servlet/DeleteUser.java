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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//フォワード先
		String forwardPath = null;
		//サーブレットクラスの動作を決定するactionの値をリクエストパラメータから取得
		String action = request.getParameter("action");
		//削除の開始をリクエストされた時の処理
		if(action == null)
		{
			System.out.println("初回起動時or2回目以降舞い戻り時");
			forwardPath = "/WEB-INF/jsp/deleteForm.jsp";
			//設定されたフォワード先にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		//フォワード先
		String forwardPath = null;
		//社員ID、パスワード
		//intがgetparameterできないのでparseする
		String strId = request.getParameter("PersonalID");
		String pass = request.getParameter("Pass");
		int id =0;
		try
		{
			id = Integer.parseInt(strId);
		}
		catch(NumberFormatException e)
		{
			id = 0;
		}

		//削除するユーザの情報を設定
		User deleteUser = new User(id , pass );

		//セッションスコープに削除ユーザーの情報を設定
		HttpSession session = request.getSession();
		session.setAttribute("deleteUser" , deleteUser);

		//IDとpassが入力されてるか判定
		if((id != 0) && (!pass.equals("")))
		{//IDとpassが入力されているとき
			System.out.println("削除情報の照合を行います");
			//削除処理の呼び出し
			DeleteUserLogic deleteUserLogic = new DeleteUserLogic();
			boolean isDelete = deleteUserLogic.execute(deleteUser);
			if(isDelete)
			{
				System.out.println("我が名はめぐみん！データを削除してやりますです！エクスプロージョン！");
				//ユーザー削除ロジックの起動
				deleteUserLogic.deleteDone(deleteUser);
				//フォワード先を指定
				forwardPath = "/WEB-INF/jsp/deleteDone.jsp";
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);
			}
			else
			{
				System.out.println("データが合致しませんでした");
				//フォワード先を指定
				forwardPath = "/WEB-INF/jsp/deleteForm.jsp";
				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);
			}
		}
		else
		{//IDもしくはpassが入ってないとき
			System.out.println("ちゃんと入力されてなぁぁぁいぃぃぃぃ・・・");
			//フォワード先を指定
			forwardPath = "/WEB-INF/jsp/deleteForm.jsp";
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}
	}
}
