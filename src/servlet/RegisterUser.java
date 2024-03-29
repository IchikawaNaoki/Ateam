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

import dao.ConnDbDao;
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



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//フォワード先のパス初期化

		String forwardPath = null;
		//サーブレットクラスの動作を決定するactionの値をリクエストパラメータから取得
		String action = request.getParameter("action");
		//登録の開始をリクエストされた時の処理
		if(action == null)
		{//最初に画面遷移した時の処理
			//フォワード先の設定
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
			//設定されたフォワード先にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//社員ID、名前、パスワード、ログイン状況
		//intにgetparameterないんでparse
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String belongs =request.getParameter("belongs");
		int belongsNo = 0;
		switch(belongs)
		{
		case "東京":
			belongsNo = 1;
			break;
		case "東京開発室":
			belongsNo = 2;
			break;
		case "宮崎":
			belongsNo = 3;
			break;
		case "札幌":
			belongsNo = 4;
			break;
		}
		//フォワード先のパス初期化
		String forwardPath = null;
		//登録するユーザの情報を設定
		User registerUser = new User(name , pass);
		//セッションスコープに登録ユーザーの情報を設定
		HttpSession session = request.getSession();
		session.setAttribute("registerUser" , registerUser);

		RegisterUserLogic registerUserLogic = new RegisterUserLogic();
		//社員名とパスが入力されているかの判定
		System.out.println("我が名はめぐみん！データを入力のための照合チェックします");
		//登録処理の呼び出し
		boolean isRegister = registerUserLogic.checkRegister(registerUser);
		session.setAttribute("isRegister", isRegister);
		if(isRegister)
		{
			System.out.println("我が名はめぐみん！データを登録します");
			ConnDbDao conn= new ConnDbDao();
			conn.RegisterPersonalDB(registerUser);
			registerUser.setId(conn.ConnDbRegisterId(registerUser));
			conn.RegisterEmployeeDB(registerUser,belongsNo);
			session.setAttribute("registerId" , registerUser.getId());
			session.setAttribute("registerName" , registerUser.getName());
			session.setAttribute("registerPass" , registerUser.getPass());
			session.setAttribute("registerBelongs", belongs);
			//登録後のフォワード先を指定
			forwardPath = "/WEB-INF/jsp/registerDone.jsp";
			//設定されたフォワード先にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);

		}
		else
		{
			/*
			 * 失敗時のエラーログ的なやつ出しといて
			 */

			System.out.println("我が名はめぐみん！多重ログイン情報は爆裂魔法で吹き飛ばします！");
			//登録失敗時のフォワード先を指定
			forwardPath = "/WEB-INF/jsp/registerForm.jsp";
			//設定されたフォワード先にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		}
	}
}
