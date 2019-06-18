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

		if(Pass.equals(Check)) {

			ServletContext application = this.getServletContext();
			User user = (User)application.getAttribute("loginUser");
			new ConnDbDao().ConnDbPassChenger(Pass , user.getId()) ;

			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passChangeDone.jsp");
			dispatcher.forward(request, response);
		}
		else {
			//フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/passChangeForm.jsp");
			dispatcher.forward(request, response);
		}
	}

}
