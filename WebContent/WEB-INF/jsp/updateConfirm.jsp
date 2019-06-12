<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "model.User" %>
<% User updateUser = (User)session.getAttribute("updateUser"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザー情報更新確認</title>
	</head>

	<body>
	<p>ユーザー情報を、以下の通りに更新します。</p>
	<p>ユーザーID:<%= updateUser.getId() %></p>

	<a href = "/aTeam/UpdateUser">戻る</a>
	<a href = "/aTeam/UpdateUser?action=done">登録</a>
	</body>
</html>