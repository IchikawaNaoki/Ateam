<%@ page language="java" contentType="text/html;charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/login.css">
		<title>Mgt在席管理アプリケーションログイン画面</title>
	</head>

<body>
	<h1>ログイン</h1>

	<form action="/aTeam/Login" method="post">

<p>ユーザ名</p>
<input id="name" type="text" name="id"><br>
<p> パスワード</p>
    <input id="pass" type="password" name="pass"><br>

 <input id="login" type="submit" value="ログイン"><br>

<a id="new"  href="" id="button">新規登録</a>

<a id="new"  href="#">アカウント削除</a>
	</form>

</body>
</html>