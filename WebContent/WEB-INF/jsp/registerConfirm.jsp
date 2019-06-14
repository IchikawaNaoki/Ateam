<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "model.User" %>
<% User registerUser = (User)session.getAttribute("registerUser"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="registerConfirm.css">
		<title>ユーザー登録確認</title>
	</head>

	<body>
	<h1>下記のユーザーを登録します。</h1>
	<p>社員名:<%= registerUser.getName() %></p>

	<a href="/aTeam/RegisterUser?action=done">登録</a>
	<a href="/aTeam/RegisterUser">戻る</a>


	</body>
</html>