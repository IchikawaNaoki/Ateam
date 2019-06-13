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

import dao.ConnDbDao;
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

		System.out.println("doGetはいったよお");
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
//			JOptionPane.showMessageDialog(null, "処理中にエラーが発生しました");
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

		System.out.println("doPostはいったよお");
		//response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String presence = request.getParameter("Presence");
		String leaveseat = request.getParameter("leave seat");
		String all = request.getParameter("all");
		String tokyo = request.getParameter("tokyo");
		String development = request.getParameter("development");
		String miyazaki = request.getParameter("miyazaki");
		String sapporo = request.getParameter("sapporo");



		List<GetDB> list = new ConnDbDao().WhereDb(tokyo, development, miyazaki, sapporo);
		request.setAttribute("getDbList", list);



		//　メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

	public void destroy() {

		System.out.println("デストロイよばれたよお");
	}

}
