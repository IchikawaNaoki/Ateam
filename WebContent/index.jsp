<%@ page language="java" contentType="text/html;charset=UTF-8"
   pageEncoding="UTF-8"%>
<% Object status = session.getAttribute("status"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/login.css">
		<title>Mgt在席管理アプリケーションログイン画面</title>
	</head>

<body>
	<h1>ログイン</h1>

	<form action="/aTeam/Login" method="post">

<p>社員ID</p>
<input id="name" type="text" name="id" required="required"><br>
<p> パスワード</p>
    <input id="pass" type="password" name="pass" required="required"><br>

 <input id="login" type="submit" value="ログイン"><br>

<a id="new"  href="/aTeam/RegisterUser" id="button">新規登録</a>

<a id="new"  href="/aTeam/DeleteUser">アカウント削除</a>
	</form>

<%if (status != null){ %>
        <script>alert("ログインIDまたはパスワードが間違っています");</script>
        <script>location.reload();</script>
        <%session.removeAttribute("status"); %>
        <% } %>


</body>
</html>