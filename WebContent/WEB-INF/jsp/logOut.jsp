<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		 <link rel="stylesheet" href="css/logout.css">
		 <script type="text/javascript" src=>"WebContent/music.js"</script>
		<title>Mgt在席管理アプリケーション</title>
		<style>
			a:visited{ color: #00f;}
			a:hover{color: #f03;}
		</style>
	</head>

	<body>
		<br>
		<h1>ログアウト</h1>
		<p>ログアウトしました。</p>
		<bgsound src="" volume="1" id="snd0">
		<a href = "/aTeam/index.jsp"  onClick="sound()">ログイン画面に戻る</a>
		<audio id="sound-file" preload="auto">
		<source src="WebContent/music/click.mp3" type="audio/mp3">
		</audio>
	</body>

</html>