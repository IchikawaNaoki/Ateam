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
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.swing.JFrame;
//import javax.swing.JOptionPane;

//-------------------------------------------------------------------------------------------------------------
//LoginLogicクラス
//メソッド:execute boolean型
//ユーザのパスワードが合っているかどうかの判定
//-------------------------------------------------------------------------------------------------------------
public class LoginLogic {
	//JFrame frame = new JFrame();
	Connection connection;
	ResultSet rs;

	public boolean execute(User user) {
		//接続するときのタイムアウト時間を設定
		DriverManager.setLoginTimeout(300);

		//接続
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample" , "id" , "pass");
			if(user.getPass().equals(rs.getString("pass")))
					return true;
		}

		catch(SQLException e) {
			System.out.println("エラー！データベース接続されてねーよ！");
			return false;

			//ポップアップウィンドウ なぜか重いのでいらんかも
			//JOptionPane.showMessageDialog(frame , "unko" , "unko" , JOptionPane.ERROR_MESSAGE);
		}

		finally {}

		return false;
	}
}
