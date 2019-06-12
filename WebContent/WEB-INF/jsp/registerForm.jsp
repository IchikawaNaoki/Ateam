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
		<p>大文字から始まる、4文字以上8文字以下のパスワードを入力してください。</p>
		<form action = "/aTeam/RegisterUser" method = "post">
			社員名:<input type="text" name="name"><br>
			パスワード:<input type="password" name="pass"><br>
		</form>
	</body>
</html>