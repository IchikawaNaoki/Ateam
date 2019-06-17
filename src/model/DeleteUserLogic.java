//-------------------------------------------------------------------------------------------------------------
//プログラム名 :	在籍管理アプリケーション
package model;

import dao.ConnDbDao;

//-------------------------------------------------------------------------------------------------------------
//DeleteUserLogicクラス
//メソッド:execute boolean型
//ユーザのパスワードが合っているかどうかの判定
//-------------------------------------------------------------------------------------------------------------
public class DeleteUserLogic
{
	public boolean execute(User user)
	{
			//DB接続し、情報合致しているかの判定を行い結果を返す
			return new ConnDbDao().ConnDbCollation(user);
	}
	
	public void deleteDone(User user)
	{
		//DBコネクトインスタンス作成
		ConnDbDao conn = new ConnDbDao();
		//削除メソッド呼び出し
		conn.ConnDbDelete(user);
	}
}