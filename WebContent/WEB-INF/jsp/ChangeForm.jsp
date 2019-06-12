<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import = "model.User" %>
<% User registerUser = (User)session.getAttribute("registerUser"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所属地変更フォーム</title>
</head>
<body>
	<%=registerUser.getId() %>、ログイン中
	<p>現在は、<%=registerUser.getPost() %>に所属しています。</p>
	<p>変更先の部署を選択してください</p>
	<form action="/aTeam/" method="post">
	<input type="radio" name="所属地" value="東京">
	<input type="radio" name="所属地" value="東京（開発室）">
	<input type="radio" name="所属地" value="宮崎">
	<input type="radio" name="所属地" value="札幌">
	<input type="submit" value="決定">
	</form>

</body>
</html>