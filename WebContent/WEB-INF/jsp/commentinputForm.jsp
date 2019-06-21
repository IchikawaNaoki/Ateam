<!--	プログラム名：備考欄編集処理
		編集者：平澤智彦
		作成日：2019/06/17
		更新日：2019/06/17	-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.GetDB" %>
<% GetDB getDbList = (GetDB)session.getAttribute("getDbList"); %>
<% String Comment = (String) session.getAttribute("oldComment"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<link rel="stylesheet" href="css/commentinputForm.css">
	<title>コメント入力</title>
</head>
<body>
	<h1>コメント入力</h1>
	<p>今までのコメント：<%= Comment %></p>
	<p>伝えたいことがある場合、<br>
	下の入力フォームに記入して下さい。</p>

	<!-- コメント記述 -->
	<form action = "/aTeam/CommentInput" method = "post">
		コメント:<input type="text" name="Comment">
		<br>
		<input id=comment type="submit"  value="送信" >
	</form>

	<form action="/aTeam/Main"method="post">
		<button type="submit"  id="comment" >
			戻る
			</button>
		</form>
	</body>
</html>