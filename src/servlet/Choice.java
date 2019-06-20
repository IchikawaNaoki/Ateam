package servlet;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class Choice
 */
@WebServlet("/Choice")
public class Choice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	//所属部署のみ表示の処理
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

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


		//　メイン画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}
}
