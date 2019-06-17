/*	プログラム名：備考欄編集処理
 *	編集者：平澤智彦
 *	作成日：2019/06/17
 *	更新日：2019/06/17	*/

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


@WebServlet("/CommentInputDone")
public class CommentInputDone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String comment = (String)session.getAttribute("comment");
		ServletContext application = this.getServletContext();
		User user = (User)application.getAttribute("loginUser");

		new ConnDbDao().ConnDbCommentInput(comment , user.getId()) ;

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/commentinputDone.jsp");
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/commentinputDone.jsp");
		dispatcher.forward(request, response);
	}

}
