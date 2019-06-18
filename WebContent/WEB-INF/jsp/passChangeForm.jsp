<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Object status = session.getAttribute("status"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>パスワード変更</title>
</head>
<body>
	<h1>パスワード変更</h1>
	<p>パスワードを変更したい場合<br>
	下の入力フォームに記入して下さい</p>
	<!-- コメント記述 -->
	<form action = "/aTeam/PassChangeUser" method = "post">
		<p>新規パスワード:<input type="password" name="pass1"></p>
		<p>確認のためもう1度:<input type="password" name="pass2"></p>
		<input type="submit"  value="送信" >

		</form>
	<a href = "/aTeam/Main">戻る</a>
</body>
</html>