<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー削除フォーム</title>
</head>
<body>
		<form action = "/aTeam/DeleteUser" method = "post">
		ユーザーID:<input type = "text" name = "id"><br>
		パスワード:<input type = "password" name = "pass"><br>
	</form>
</body>
</html>