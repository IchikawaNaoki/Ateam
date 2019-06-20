/*	プログラム名：備考欄編集処理
 *	編集者：平澤智彦
 *	作成日：2019/06/17
 *	更新日：2019/06/17*/

package servlet;

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

@WebServlet("/CommentInput")
public class CommentInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ServletContext application = this.getServletContext();
		User user = (User) application.getAttribute("loginUser");
		List <GetDB>list= new ConnDbDao().ConnDbUserInfo(user.getId());
		String oldComment=list.get(0).getComment();
		HttpSession session = request.getSession();
		session.setAttribute("oldComment",oldComment);
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/commentinputForm.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		List <GetDB>list= new ConnDbDao().ConnDbUserInfo(new User().getId());
//
//		String oldComment=list.get(0).getComment();
//
		String Comment = request.getParameter("Comment");

		HttpSession session = request.getSession();
		session.setAttribute("Comment", Comment);


		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/commentinputConfirm.jsp");
		dispatcher.forward(request, response);



	}
}