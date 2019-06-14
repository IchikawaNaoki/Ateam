package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConnDbDao;
import model.User;

@WebServlet("/UpdateDone")
public class UpdateDone extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int blo = 0;
		HttpSession session = request.getSession();
		String blongs = (String)session.getAttribute("blongs");
		ServletContext application = this.getServletContext();
		User user = (User)application.getAttribute("loginUser");
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
		new ConnDbDao().ConnDbChangeBelong(blo , user.getId()) ;

		session.removeAttribute("blongs");

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateDone.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		int blo = 0;
		HttpSession session = request.getSession();
		String blongs = (String)session.getAttribute("blongs");
		ServletContext application = this.getServletContext();
		User user = (User)application.getAttribute("loginUser");

		new ConnDbDao().ConnDbChangeBelong(blo , user.getId()) ;

		session.removeAttribute("blongs");

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updateDone.jsp");
		dispatcher.forward(request, response);
	}
}
