//プログラム名 :	在籍管理アプリケーション

//-------------------------------------------------------------------------------------------------------------
//パッケージ
//-------------------------------------------------------------------------------------------------------------
package servlet;

//-------------------------------------------------------------------------------------------------------------
//インポート
//-------------------------------------------------------------------------------------------------------------
import java.io.IOException;
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

		ServletContext application = this.getServletContext();
		User user = (User)application.getAttribute("loginUser");

		List<GetDB> getDbList = new ConnDbDao().ConnDbUserInfo(user.getId());
		HttpSession session2 = request.getSession();
		session2.setAttribute("getDbList" , getDbList.get(0));

		//設定されたフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ChangeForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");


		int blo = 0;
		ServletContext application =this.getServletContext();
		User user = (User)application.getAttribute("loginUser");
		String blongs = request.getParameter("所属地");
		switch( blongs ) {
		case "東京":
			 blo = 1;
			break;
		case "東京(開発室)":
			blo = 2;
			break;
		case "宮崎":
			blo = 3;
			break;
		case "札幌":
			blo = 4;
			break;
		}
		//new ConnDbDao().ConnDbChangeBelong(blo , user.getId()) ;

		HttpSession session = request.getSession();
		session.setAttribute("blongs", blongs);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateConfirm.jsp");
		dispatcher.forward(request, response);
	}
}

