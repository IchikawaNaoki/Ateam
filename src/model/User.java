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

//-------------------------------------------------------------------------------------------------------------
//インポート
//-------------------------------------------------------------------------------------------------------------
import java.io.Serializable;

//-------------------------------------------------------------------------------------------------------------
//Userクラス
//-------------------------------------------------------------------------------------------------------------
public class User implements Serializable{

	private int id;				//社員ID
	private String name;	//社員名
	private String pass;	//パスワード
	private byte nowLogin;	//ログイン状況

	public User(){}

	public User(int id, String pass){
		this.id = id;
		this.pass = pass;
	}

	public User(String name, String pass){
		this.name = name;
		this.pass = pass;
	}

	public User(int id , String name , String pass , byte nowLogin) {
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.nowLogin = nowLogin;
	}

	//社員IDのゲッター
	public int  getId() {
		return id;
	}

	//社員名のゲッター
	public String getName() {
		return name;
	}

	//パスワードのゲッター
	public String getPass() {
		return pass;
	}

	//ログイン状況のゲッター
	public Byte getNowLogin() {
		return nowLogin;
	}

	//新規ユーザーのIDセット
	public void setId(int id)
	{
		this.id = id;
	}
}
