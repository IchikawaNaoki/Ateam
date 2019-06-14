<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/delete.css">
	<title>
		ユーザー削除フォーム
	</title>
</head>
<body>
	<h1>
		ユーザー削除
	</h1>
	<p>
		削除したいユーザーIDとパスワードを入力してください。
	</p>
	<form action = "/aTeam/DeleteUser" method = "post">
		ユーザーID:<input type="text" name="PersonalID"><br>
		パスワード:<input type="password" name="Pass"><br>

		<button type="submit"  id="delete" >
			削除
		</button>
	</form>
		<!-- button type="button" onclick="history.back()"id="delete" >
		</button>
		<input type="button"  value="戻りゅ"onClick="/aTeam/index.jsp"id="delete"> -->
	<form action="/aTeam/Login"method="post">
		<button type="submit"  id="delete" >
			戻る
		</button>
	</form>
</body>
</html>