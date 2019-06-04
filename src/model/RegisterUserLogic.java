package model;

public class RegisterUserLogic {
	public boolean execute(User user) {
		//決めたパスワードが規則(4～8文字、大文字で始まる)に従っているかを判定
		if(user.getPass().length() < 4 || user.getPass().length()  > 8 || user.getPass().isEmpty() ||
				Character.isLowerCase(user.getPass().charAt(0))) {
			return false;
		}

		return true;
	}
}