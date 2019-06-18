<%@ page language="java" contentType="text/html;charset=UTF-8"
   pageEncoding="UTF-8"%>
<% Object status = session.getAttribute("status"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/login.css">
		<title>Mgt在席管理アプリケーションログイン画面</title>
		<script type="text/javascript" src="WebContent/js/main.js"></script>
	</head>

<body>
	<h1>ログイン</h1>

	<form action="/aTeam/Login" method="post">

<p>社員ID</p>
<input id="name" type="text" name="id" required="required"><br>
<p> パスワード</p>
    <input id="pass" type="password" name="pass" required="required"><br>

<bgsound src="" volume="1" id="snd0">
 <input onClick="sound()" id="login" type="submit" value="ログイン" ;><br>
 <audio id="sound-file" preload="auto">
	<source src="music/click.mp3" type="audio/mp3">
</audio>

<bgsound src="" volume="1" id="snd0">
<a href="/aTeam/RegisterUser" id="button">新規登録</a>
	<audio id="sound-file" onClick="sound()"load="auto">
		<source src="WebContent/music/click.mp3" type="audio/mp3">
	</audio>

<a id="new"  href="/aTeam/DeleteUser">アカウント削除</a>
	</form>

<%if (status != null){ %>
        <script>alert("ログインIDまたはパスワードが間違っています");</script>
        <script>location.reload();</script>
        <%session.removeAttribute("status"); %>
        <% } %>
</body>
</html>