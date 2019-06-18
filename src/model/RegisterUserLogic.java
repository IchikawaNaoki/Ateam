//-------------------------------------------------------------------------------------------------------------
//プログラム名 :	在籍管理アプリケーション
//ファイル名 :		RegisterUserLogic.java
//作成者	:			システム部 髙橋晟太
//作成日	:			2019/06/04
//更新日	:			2019/06/04 髙橋晟太
//-------------------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------------------
//パッケージ
//-------------------------------------------------------------------------------------------------------------
package model;

import dao.ConnDbDao;

//-------------------------------------------------------------------------------------------------------------
//RegisterUserLogicクラス
//-------------------------------------------------------------------------------------------------------------
public class RegisterUserLogic
{
	public boolean checkRegister(User user)
	{
		//パスワードが規則(4～8文字、大文字で始まる)に従っているか判定
		if(((user.getPass().length() >= 4) && (user.getPass().length()  <= 8)) && user.getPass().isEmpty() && Character.isLowerCase(user.getPass().charAt(0)))
		{
			ConnDbDao conn = new ConnDbDao();
			if(!conn.ConnDbCollation(user))
			{
				return true;
			}
		}
		return false;
	}

}