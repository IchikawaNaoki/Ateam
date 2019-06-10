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
import model.User;
/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//DBを取得して、リストスコープに保存
		GetDbListLogic getDbListLogic = new GetDbListLogic();
		List<GetDB> getDbList = getDbListLogic.execute();
		request.setAttribute("getDbList", getDbList);

		//ログインしているか確認するため
		//セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		//ログインしていない場合
		if(loginUser == null) {
			//リダイレクト
			response.sendRedirect("/aTeam/");
		}
		//ログインしている場合
		else {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//リクエストパラメータの取得
	//	request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		//入力値チェック
		if(text != null && text.length() != 0) {
			//セッションスコープに保存されたユーザー情報を取得
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");

		}
		else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}

		//DBを取得して、リストスコープに保存
		GetDbListLogic getDbListLogic = new GetDbListLogic();
		List<GetDB> getDbList = getDbListLogic.execute();
		request.setAttribute("getDbList", getDbList);

		//request.setAttribute("mutterList", mutterList);

		//　メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

	public void destroy() {

		System.out.println("デストロイよばれたよお");
	}

}
