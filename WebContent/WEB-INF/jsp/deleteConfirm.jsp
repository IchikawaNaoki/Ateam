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
		<p>ユーザーID:<%= deleteUser.getId() %></p>
		
	 <a href="/aTeam/DeleteUser?action=done">削除</a>
	<a href="/aTeam/DeleteUser">戻る</a>  

	</body>
</html>