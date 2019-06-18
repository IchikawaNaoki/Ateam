<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<% User registerUser = (User)session.getAttribute("regiaterUser"); %>
<% int id = (int) session.getAttribute("registerId"); %>
<% String name = (String) session.getAttribute("registerName"); %>
<% String pass = (String) session.getAttribute("registerPass"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザー登録完了</title>
	</head>
	<body>
	<p>新規ユーザー「<%= name%>」さんの登録が完了しました。</p><br>
	<p>ログインID：<%= id %></p>
	<p>ログインパスワード：<%= pass %></p>
	<a href = "/aTeam/">ログイン画面に戻る</a>
	<a href = "/aTeam/RegisterUser">ユーザー登録画面に戻る</a>
	</body>
</html>