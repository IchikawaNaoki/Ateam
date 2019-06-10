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

//import javax.swing.JFrame;
//import javax.swing.JOptionPane;

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

		ConnDB connDb = new ConnDB();
		List<GetDB> listDb = connDb.findAll();
/*
		//接続
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sample" , "id" , "pass")){
			//SQLを準備して実行
			String sql = "select id , pass from sample";
			PreparedStatement pStmt = connection.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			if(user.getPass().equals(rs.getString("pass")))
					return true;
		}

		catch(SQLException e) {
			System.out.println("エラーですの！おデータベースが接続されておりませんわ");
			e.printStackTrace();

			return false;

			//ポップアップウィンドウ なぜか重いのでいらんかも
			//JOptionPane.showMessageDialog(frame , "unko" , "unko" , JOptionPane.ERROR_MESSAGE);
		}

		finally {}
*/

		return true;
	}
}
