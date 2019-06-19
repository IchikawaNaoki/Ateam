package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
		ServletContext application = this.getServletContext();
		User loginUser = (User)application.getAttribute("loginUser");

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
		request.setCharacterEncoding("UTF-8");
		String presence = request.getParameter("Presence");
		String leaveseat = request.getParameter("leave seat");
		//所属地ボタンを押したのを保存する
		List<String> button = new ArrayList<String>();
		button.add(request.getParameter("all"));
		button.add(request.getParameter("tokyo"));
		button.add(request.getParameter("development"));
		button.add(request.getParameter("miyazaki"));
		button.add(request.getParameter("sapporo"));

		HttpSession session = request.getSession();
		for( String str : button ){
			if(str != null) {
				session.setAttribute("str", str);
				List<GetDB> list = new ConnDbDao().WhereView(str);
				request.setAttribute("getDbList", list);
			}
		}

		//在席・離席ボタンをおしたとき
		if(presence != null || leaveseat != null) {
			//アプリケーションからUser情報を取得
			ServletContext application = this.getServletContext();
			User loginUser = (User)application.getAttribute("loginUser");
			new ConnDbDao().ConnDbStatus( presence, leaveseat , loginUser.getId());

			String str = (String) session.getAttribute("str");
			if( str != null ) {
				List<GetDB> list = new ConnDbDao().WhereView(str);
				request.setAttribute("getDbList", list);
			}
		}
		//　メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}
@Override
	public void destroy()
	{
		System.out.println("デストロイよばれたよお");
		//アプリケーションスコープを取得
		ServletContext application = this.getServletContext();
		User user = (User)application.getAttribute("loginUser");

		//ログインフラグを0にする
		ConnDbDao conn = new ConnDbDao();
		List<User> listUser = conn.ConDbLogin(user);
		if( listUser.get(0).getNowLogin().equals((byte)1) ) //ログインフラグをみる
		{
			conn.ConnDbLoginLogout(0 ,listUser.get(0).getPass());
			System.out.println(listUser.get(0).getName()+"のログインフラグ下すっぺよ");
		}else {
			System.out.println(listUser.get(0).getName()+"はログインしてないっぺよ"+ listUser.get(0).getNowLogin());
			//return null;
		}


	}
}
