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



import java.util.List;

import dao.ConnDbDao;

//-------------------------------------------------------------------------------------------------------------
//LoginLogicクラス
//メソッド:execute boolean型
//ユーザのパスワードが合っているかどうかの判定
//-------------------------------------------------------------------------------------------------------------
public class LoginLogic {
	public List<User> execute(User user) {

		if(user.getId() != 0 && user.getPass() != null) {
			ConnDbDao conn = new ConnDbDao();
			List<User> listUser = conn.ConDbLogin(user);
				if(user.getPass().equals(listUser.get(0).getPass())) {
					System.out.println("ログイン成功");
					if( listUser.get(0).getNowLogin().equals((byte)0) ) {//ログインフラグをみる
						conn.ConnDbLoginLogout(1 ,listUser.get(0).getPass());
						System.out.println(listUser.get(0).getName()+"のログインフラグたてたっぺよ");
					}else {
						System.out.println(listUser.get(0).getName()+"はログイン済みっぺよ"+ listUser.get(0).getNowLogin());
						//System.out.println("ログインしてるよ");
						//return null;
					}
					return listUser;
			}
		}
		System.out.println("ログイン失敗");
		return null;
	}
}
