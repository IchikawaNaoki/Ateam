<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "model.User" %>
<% User deleteUser = (User)session.getAttribute("deleteUser"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="delete.css">
		<title>ユーザー削除確認</title>
	</head>

	<body>
	<p>下記のユーザーを削除します。</p>
	<p>ユーザーID:<%=  %></p>

	<a href = "/aTeam/deleteUser">戻る</a>
			//JSPに飛ばす(仕様書確認)

	<a href = "/aTeam/Delete/User?action=done">削除</a>
	</body>
</html>