<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "model.User" %>
<% User registerUser = (User)session.getAttribute("registerUser"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザ削除確認</title>
	</head>

	<body>
	<p>下記のユーザを削除します。</p>
	<p>ユーザID:<%=  %></p>

	<a href = "/aTeam/deleteUser">戻る</a>
			//JSPに飛ばす(仕様書確認)

	<a href = "/aTeam/Delete/User?action=done">削除</a>
	</body>
</html>