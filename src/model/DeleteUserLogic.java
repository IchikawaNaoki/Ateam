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
	public boolean deleteExecute(User user)
	{
		//入力判定
		return (deleteCheck(user));
	}

	public void deleteDone(User user)
	{
		//DBコネクトインスタンス作成
		ConnDbDao conn = new ConnDbDao();
		//削除メソッド呼び出し
		conn.ConnDbDelete(user);
	}
	//IDとPASS照合
	public boolean deleteCheck(User user)
	{//IDとPASSが入力されているかを判定
		System.out.println("削除情報の照合を行います");
		if((user.getId() != 0) && (!user.getPass().equals("")))
		{
			//DB接続し、情報合致しているかの判定を行い結果を返す
			return new ConnDbDao().ConnDbCollation(user);
		}
		return false;
	}
}