<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>コメント入力</title>
</head>
<body>
	<h1>コメント入力</h1>
	<p>伝えたいことがある場合<br>
	下の入力フォームに記入して下さい</p>
	<!-- コメント記述 -->
	<form action = "/aTeam/CommentInput" method = "post">
		コメント:<input type="text" name="Comment">
		<input type="submit"  value="送信" >
	</form>
</body>
</html>