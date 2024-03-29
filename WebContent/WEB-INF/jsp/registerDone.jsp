<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<% User registerUser = (User)session.getAttribute("regiaterUser"); %>
<% int id = (int) session.getAttribute("registerId"); %>
<% String name = (String) session.getAttribute("registerName"); %>
<% String pass = (String) session.getAttribute("registerPass"); %>
<% String belongs = (String) session.getAttribute("registerBelongs"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/register.css">
		<script type="text/javascript" src=>"WebContent/music.js"</script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>ユーザー登録完了</title>
	</head>
	<body>
	<p>新規ユーザー「<%= name%>」さんの登録が完了しました。</p><br>
	<p>ログインID：<%= id %></p>
	<p>ログインパスワード：<%= pass %></p>
	<p>所属：<%= belongs %></p>
	<a href = "/aTeam/">ログイン画面に戻る</a><br>
	<a href = "/aTeam/RegisterUser">ユーザー登録画面に戻る</a>
	</body>
</html>