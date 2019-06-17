<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% Object status = session.getAttribute("status"); %>
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
	<form action="/aTeam/DeleteUser" method="post">
		ユーザーID:<input type="text" name="PersonalID"><br>
		パスワード:<input type="password" name="Pass"><br>

<!-- <div id="megmin"> -->
	<button  id="delete"type="submit"  >
		削除
	</button>
	</form>
	<form action="/aTeam/Login"method="post">
		<button type="submit"  id="delete" >
			戻る
		</button>
	</form>
<!--  </div> -->




</body>
</html>