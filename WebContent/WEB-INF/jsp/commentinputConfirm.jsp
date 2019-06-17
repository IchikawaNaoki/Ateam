<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String Comment = (String)session.getAttribute("Comment"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>コメント確認画面</title>
</head>
<body>
	<h2>以下のコメントを、残しますか?</h2>
	<p><%= Comment %></p>

	<a href = "/aTeam/CommentInput">戻る</a>
	<a href = "/aTeam/CommentInputDone?action=done">登録</a>
</body>
</html>