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
		<p>使用したいユーザーIDとパスワードを入力してください。</p>
		<form action = "/aTeam/RegisterUser" method = "post">
			ユーザーID:<input type = "text" name = "id"><br>
			パスワード:<input type = "password" name = "pass"><br>
		</form>
	</body>
</html>