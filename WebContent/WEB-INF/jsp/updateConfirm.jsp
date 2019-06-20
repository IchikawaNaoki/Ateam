<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "model.User" %>
<% User updateUser = (User)session.getAttribute("updateUser"); %>
<% String blongs = (String)session.getAttribute("blongs"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/updateConfirm.css">
		<script type="text/javascript" src=>"WebContent/music.js"</script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>ユーザー情報更新確認</title>
	</head>
	<h1>更新確認</h1>
	<body>
	<p>ユーザー部署を、以下の通りに更新します。</p>
	<p>部署:<%= blongs %></p>


	<form action="/aTeam/UpdateDone?action=done"method="get">
	<button onClick="soundplayAndSubmit(this.parentElement);return false;" id="update" type="submit">登録</button>
	<audio id="sound-file" preload="auto">
	<source src="music/click.mp3" type="audio/mp3">
	</audio>
	</form>

	<form action="/aTeam/UpdateUser"method="get" >
	<button onClick="soundplayAndSubmit(this.parentElement);return false;" id="update" type="submit">戻る</button>
	<audio id="sound-file" preload="auto">
	<source src="music/click.mp3" type="audio/mp3">
	</audio>
	</form>
	</body>
</html>