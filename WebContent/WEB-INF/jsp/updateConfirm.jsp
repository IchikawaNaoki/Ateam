<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import = "model.User" %>
<% User updateUser = (User)session.getAttribute("updateUser"); %>
<% String blongs = (String)session.getAttribute("blongs"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザー情報更新確認</title>
	</head>

	<body>
	<p>ユーザー部署を、以下の通りに更新します。</p>
	<p>部署:<%= blongs %></p>

	<a href = "/aTeam/UpdateUser">戻る</a>
	<a href = "/aTeam/UpdateDone?action=done">登録</a>
	</body>
</html>