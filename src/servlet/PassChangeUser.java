package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ConnDbDao;
import model.PassChangeLogic;
import model.User;

@WebServlet("/PassChangeUser")
public class PassChangeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passChangeForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");

		String Pass = request.getParameter("pass1");
		String Check = request.getParameter("pass2");

		if(Pass.equals(Check))
		{
			PassChangeLogic passchangeLogic = new PassChangeLogic();

			System.out.println("我が名はめぐみん！データを入力のための照合チェックします");
			//登録処理の呼び出し
			boolean isRegister = passchangeLogic.execute(Pass);
			if(!isRegister)
			{
				/*
				 * 失敗時のエラーログ的なやつ出しといて
				 */
				System.out.println("D A M E !!!");
				//登録失敗時のフォワード先を指定
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passChangeForm.jsp");
				dispatcher.forward(request, response);
			}
				else {
				ServletContext application = this.getServletContext();
				User user = (User)application.getAttribute("loginUser");
				new ConnDbDao().ConnDbPassChenger(Pass , user.getId()) ;

				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passChangeDone.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passChangeForm.jsp");
			dispatcher.forward(request, response);
		}
	}

}
