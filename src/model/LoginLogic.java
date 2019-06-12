//-------------------------------------------------------------------------------------------------------------
//プログラム名 :	在籍管理アプリケーション
//ファイル名 :		User.java
//作成者	:			システム部 髙橋晟太
//作成日	:			2019/06/04
//更新日	:			2019/06/04 髙橋晟太
//-------------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------
//パッケージ
//-------------------------------------------------------------------------------------------------------------
package model;

import java.sql.DriverManager;

import dao.ConnDbDao;

//-------------------------------------------------------------------------------------------------------------
//LoginLogicクラス
//メソッド:execute boolean型
//ユーザのパスワードが合っているかどうかの判定
//-------------------------------------------------------------------------------------------------------------
public class LoginLogic {
	public boolean execute(User user) {

		//接続するときのタイムアウト時間を設定(5分)
		DriverManager.setLoginTimeout(300);

		//データベースと接続
		//ConnDbDao connDb = new ConnDbDao();
		//List<GetDB> listDb = connDb.findAll();
		//List<User> listUser = connDb.findUserAll();

		//データベースから情報を取得
		//GetDB getDb = new GetDB();

		//ユーザ情報を取得
		//User getUser = new User();

		if(user.getId() != 0 && user.getPass() != null) {

			ConnDbDao conn = new ConnDbDao();


			if(user.getPass().equals(conn.ConDbLogin(user))) {
				System.out.println("ログイン成功");
				conn.ConnDbView();
				return true;
			}
		}
		//DBに保存されたユーザー文照会
//		for(int i = 0; i < listUser.size(); i++)
//		{
//			Integer sample = listUser.get(i).getId();
//			String pass =  listUser.get(i).getPass();
//			if(listUser.get(i).getId() == user.getId() && pass.equals(user.getPass())) {
//			if(sample.equals(user.getId()) && pass.equals(user.getPass())) {
//				System.out.println("ログイン成功");
//				return true;
//			}
//			else {
//				System.out.println("ログイン失敗");
//			}
//		}


		//ユーザの入力したIDとパスワードを下に表示 いずれ消す！
//		System.out.println(getDb.getId());
//		System.out.println(getUser.getPass());
//		System.out.println(listDb);
//		System.out.println(listUser);

		return false;	//パスが通らなかったらfalse を返す（パスでログインできるようになったらfalseに直して）
	}
}
