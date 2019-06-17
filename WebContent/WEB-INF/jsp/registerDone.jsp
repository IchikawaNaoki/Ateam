<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.User" %>
<% User registerUser = (User)session.getAttribute("regiaterUser"); %>
<% int ID = (int) session.getAttribute("registerId"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザー登録完了</title>
	</head>
	<body>
	<p>ユーザー登録が完了しました。</p>
	<p>ユーザーID：<%= ID %></p>
	<a href = "/aTeam/">ログイン画面に戻る</a>
	<a href = "/aTeam/RegisterUser">ユーザー登録画面に戻る</a>
	</body>
</html>