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

		if(user.getId() != 0 && user.getPass() != null)
		{
			//DBコネクトインスタンス作成
			ConnDbDao conn = new ConnDbDao();
			//削除メソッド呼び出し
			conn.ConnDbDelete(user);
			return true;
		}
		return false;
	}
}