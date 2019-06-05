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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//-------------------------------------------------------------------------------------------------------------
//LoginLogicクラス
//メソッド:execute boolean型
//ユーザのパスワードが合っているかどうかの判定
//-------------------------------------------------------------------------------------------------------------
public class LoginLogic {
	public boolean execute(User user) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://MGT2019\\\\SQLEXPRESS;databaseName=TeamA");
			//connection.getWarnings();
		}
		catch(SQLException e) {
		}

		finally {
		}

		if(user.getPass().equals("takahashiisgod") && user.getName().equals("takahashiisgod")) {
			return true;
		}

		return false;
	}
}
