<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action = "/aTeam/CommentInput" method = "post">
		新規パスワード:<input type="text" name="pass1">
		確認のためもう1度:<input type="text" name="pass2">
		<input type="submit"  value="送信" >
	</form>
</body>
</html>