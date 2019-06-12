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
				System.out.println("削除成功");
				conn.ConnDbView();
				return true;
			}
		}

		//DBに保存されたユーザー文照会
		//for(int i = 0; i < listUser.size(); i++)
		//{
		//	Integer sample = listUser.get(i).getId();
		//	String pass =  listUser.get(i).getPass();
		//	//if(listUser.get(i).getId() == user.getId() && pass.equals(user.getPass())) {
		//	if(sample.equals(user.getId()) && pass.equals(user.getPass())) {
		//		System.out.println("削除成功");
		//		return true;
		//	}
		//	else {
		//		System.out.println("削除失敗");
		//	}
		//}


		//ユーザの入力したIDとパスワードを下に表示 いずれ消す！
		//System.out.println(getDb.getId());
		//System.out.println(getUser.getPass());
		//System.out.println(listDb);
		//System.out.println(listUser);

		return false;	//パスが通らなかったらfalse を返す（パスでログインできるようになったらfalseに直して）
	}
}