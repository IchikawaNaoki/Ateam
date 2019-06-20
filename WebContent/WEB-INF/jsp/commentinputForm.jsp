<!--	プログラム名：備考欄編集処理
		編集者：平澤智彦
		作成日：2019/06/17
		更新日：2019/06/17	-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import = "model.GetDB" %>
<% GetDB getDbList = (GetDB)session.getAttribute("getDbList"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<title>コメント入力</title>
</head>
<body>
	<h1>コメント入力</h1>
	<p>現在のコメントは：<c:out value="${getDbList.}"/>です。</p>
	<p>伝えたいことがある場合、<br>
	下の入力フォームに記入して下さい。</p>
	<!-- コメント記述 -->
	<form action = "/aTeam/CommentInput" method = "post">
		コメント:<input type="text" name="Comment">
		<input type="submit"  value="送信" >
	</form>
	<a href = "/aTeam/Main">戻る</a>
</body>
</html>