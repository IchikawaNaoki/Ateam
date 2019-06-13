//-------------------------------------------------------------------------------------------------------------
//プログラム名 :	在籍管理アプリケーション
package model;

import dao.ConnDbDao;

//-------------------------------------------------------------------------------------------------------------
//DeleteUserLogicクラス
//メソッド:execute boolean型
//ユーザのパスワードが合っているかどうかの判定
//-------------------------------------------------------------------------------------------------------------
public class DeleteUserLogic {
	public boolean execute(User user) {

		if(user.getId() != 0 && user.getPass() != null) {

			ConnDbDao conn = new ConnDbDao();
			if(user.getPass().equals(conn.ConDbLogin(user))) {
				System.out.println("削除成功");
				conn.ConnDbView();
				return true;
			}
		}

		return false;	//パスが通らなかったらfalse を返す（パスでログインできるようになったらfalseに直して）
	}
}