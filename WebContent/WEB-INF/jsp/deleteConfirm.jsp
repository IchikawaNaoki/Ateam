<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "model.User" %>
<% User registerUser = (User)session.getAttribute("registerUser"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		 <link rel="stylesheet" type="text/css" href="delete.css">
		<title>ユーザ削除確認</title>
	</head>

	<body>
	<h1 class="first">下記のユーザを削除します。</h1>
	<h2>ユーザID:<%=  %></h2>

	<button type="button" id="delete">
	<a href = "/aTeam/deleteUser">戻る</a></button>
			<!-- JSPに飛ばす(仕様書確認) -->
	<button type="button" id="delete">
	<a href = "/aTeam/Delete/User?action=done">削除</a><br></button>
	</body>
</html>