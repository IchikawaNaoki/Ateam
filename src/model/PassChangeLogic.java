package model;

public class PassChangeLogic
{
	public boolean execute(String pass)
	{
		//パスワードが規則(4～8文字、大文字で始まる)に従っているか判定
		if(((pass.length() < 4) || (pass.length()  > 8)) || pass.isEmpty() || Character.isLowerCase(pass.charAt(0)))
		{
			return false;
		}
		return true;
	}
}
