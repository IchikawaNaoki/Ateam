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
import java.util.List;

import dao.ConnDbDao;

//-------------------------------------------------------------------------------------------------------------
//LoginLogicクラス
//メソッド:execute boolean型
//ユーザのパスワードが合っているかどうかの判定
//-------------------------------------------------------------------------------------------------------------
public class LoginLogic {
	//JFrame frame = new JFrame();

	public boolean execute(User user) {
		//接続するときのタイムアウト時間を設定(5分)
		DriverManager.setLoginTimeout(300);

		//　データベースと接続
		ConnDbDao connDb = new ConnDbDao();
		List<GetDB> listDb = connDb.findAll();
		List<User> listUser = connDb.findUserAll();

		//データベースから情報を取得
		GetDB getDb = new GetDB();

		//ユーザ情報を取得
		User getUser = new User();

		System.out.println(getDb.getId());
		System.out.println(getUser.getPass());
		//System.out.println(listDb);
		//System.out.println(listUser);

		return true;	//パスが通らなかったらfalse を返す（パスでログインできるようになったらfalseに直して）
	}
}
