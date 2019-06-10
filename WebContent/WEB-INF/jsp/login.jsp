<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Mgt在席管理アプリケーション</title>
	</head>

	<body>
		<h1>Mgt在席管理アプリケーション</h1>
		<h2>社員の在席/離席情報をお知らせするアプリケーションです。</h2>

		<form action="/aTeam/" method="post">
			ユーザ名:<input type="text" name="name"><br>
			パスワード:<input type="password" name="pass"><br>
			新規登録:<input type="new" name="new"><br>
			アカウント削除:<input type="delete" name="delete"><br>
		</form>
	</body>
</html>