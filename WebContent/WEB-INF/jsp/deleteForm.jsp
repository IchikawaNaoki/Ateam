<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <% Object status = session.getAttribute("status"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/delete.css">
	<script type="text/javascript" src="js/music.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>ユーザー削除フォーム</title>
</head>
<body>
	<h1>
		ユーザー削除
	</h1>
	<p>
		削除したいユーザーIDとパスワードを入力してください。
	</p>

	<form action="/aTeam/DeleteUser" method="post">

		ユーザーID:<input type="text" name="PersonalID" required="required"><br>
		パスワード:<input type="password" name="Pass" required="required"><br>

	<button onClick="soundplayAndSubmit(this.parentElement)" id="delete"type="submit">削除</button>
	<audio id="sound-file" preload="auto">
	<source src="music/click.mp3" type="audio/mp3">
	</audio>
	</form>



	<form action="/aTeam/Login"method="post" id="backForm">
		<button onClick="soundplayAndSubmit(this.parentElement);return false;" id="delete" type="submit">戻る</button>
		<audio id="sound-file" preload="auto">
		<source src="music/click.mp3" type="audio/mp3">
		</audio>
	</form>



<!--  </div> -->




</body>
</html>