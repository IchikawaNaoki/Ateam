<%@ page language="java" contentType="text/html;charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% Object status = session.getAttribute("status"); %>
<%  String id = (String)session.getAttribute("id");%>
<%  String strPass = (String)session.getAttribute("pass");%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/login.css">
		<title>Mgt在席管理アプリケーションログイン画面</title>
		<script type="text/javascript" src="js/music.js"></script>
	</head>

<body>
	<h1>ログイン</h1>
	<%if (id == null){ %>
	<%id=""; %>
        <% } %>
	<form action="/aTeam/Login" method="post">

<p>社員ID</p>
<input id="name" type="text" name="id"value="<%= id%>"required="required"><br>
<p> パスワード</p>
    <input id="pass" type="password" name="pass" value="<%= strPass%>"required="required"><br>

<!-- this.parentElementはinputの親であるフォームタグ  -->
 <input onClick="soundplayAndSubmit(this.parentElement)" id="login" type="submit" value="ログイン" ><br>
 <audio id="sound-file" preload="auto">
	<source src="music/click.mp3" type="audio/mp3">
</audio>

<a href="/aTeam/RegisterUser" id="button">新規登録</a>
<a id="new"  href="/aTeam/DeleteUser">アカウント削除</a>
	</form>

<%if (status != null){ %>
        <script>alert("ログインIDまたはパスワードが間違っています");</script>
        <script>location.reload();</script>
        <%session.removeAttribute("status"); %>
        <% } %>
</body>
</html>