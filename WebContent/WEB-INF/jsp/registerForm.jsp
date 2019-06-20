<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/register.css">
		<title>ユーザー登録</title>
	</head>

	<body>
		<h1>新規ユーザー登録</h1>
		<p>登録する社員名と、</p>
		<p>大文字から始まる、4～8文字の</p>
		<p>パスワードを半角英数字で入力。</p>
		<p>また、部署を選んでください</p>
		<form action="/aTeam/RegisterUser" method="post">
			    社員名:<input type="text" name="name" required="required"><br>
			パスワード:<input type="password" name="pass" required="required"><br>
			<input type="radio" name="belongs" value="未配属"required="required">未配属
			<input type="radio" name="belongs" value="東京"required="required">東京
			<input type="radio" name="belongs" value="東京開発室"required="required">東京開発室
			<input type="radio" name="belongs" value="宮崎"required="required">宮崎
			<input type="radio" name="belongs" value="札幌"required="required">札幌
			入力値てすと:<input type="text" name="" required="required"><br>
			<br>
			<button id="register" type="submit">
				登録
			</button>
		</form>
		<form action="/aTeam/Login"method="post">
			<button type="submit"  id="register" >
				戻る
			</button>
		</form>
	</body>
</html>