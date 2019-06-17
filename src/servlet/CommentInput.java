///*	プログラム名：備考欄編集処理
// *	編集者：平澤智彦
// *	作成日：2019/06/17
// *	更新日：2019/06/17*/
//
//package servlet;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet("/CommentInput")
//public class CommentInput extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
//	{
//		//フォワード先のパス初期化
//		String forwardPath = null;
//		//サーブレットクラスの動作を決定するactionの値をリクエストパラメータから取得
//		String action = request.getParameter("action");
//		//登録の開始をリクエストされた時の処理
//		if(action == null)
//		{
//			//フォワード先の設定
//			forwardPath = "/WEB-INF/jsp/commentinputForm.jsp";
//			//設定されたフォワード先にフォワード
//			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
//			dispatcher.forward(request, response);
//		}
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
