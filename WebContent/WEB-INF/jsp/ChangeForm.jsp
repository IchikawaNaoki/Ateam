<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import = "model.User" %>
<%@ page import = "model.GetDB" %>

<% User registerUser = (User)session.getAttribute("registerUser"); %>
<% GetDB getDbList = (GetDB)session.getAttribute("getDbList"); %>
<% User user = (User)application.getAttribute("loginUser"); %>

<!DOCTYPE html>
<html>
<!-- setAttributeで呼べ！！ -->
	<head>
		<meta charset="UTF-8">
		<title>ユーザー情報更新</title>
	</head>

	<body>
	<p><c:out value="${loginUser.name}"></c:out>さんログイン中</p>
		<p>現在は<c:out value="${getDbList.belong}" />に所属しています。</p>
		<p>変更先の部署を選択してください。</p>
		<form action="/aTeam/UpdateUser" method="post">
		<%-- 所属している部署以外を表示 --%>
		<c:choose>

		<%-- 東京 --%>
			<c:when test="${getDbList.belong == \"東京\"}">
				<input type="radio" name="所属地" value="東京開発室"required>東京開発室
				<input type="radio" name="所属地" value="宮崎"required>宮崎
				<input type="radio" name="所属地" value="札幌"required>札幌
				<input type="submit" value="送信">
			</c:when>

			<%-- 東京(開発室) --%>

			<c:when test="${getDbList.belong == \"東京開発室\"}">

				<input type="radio" name="所属地" value="東京"required>東京
				<input type="radio" name="所属地" value="宮崎"required>宮崎
				<input type="radio" name="所属地" value="札幌"required>札幌
				<input type="submit" value="送信">
			</c:when>

			<%-- 宮崎 --%>
			<c:when test="${getDbList.belong == \"宮崎\"}">
				<input type="radio" name="所属地" value="東京"required>東京
				<input type="radio" name="所属地" value="東京開発室"required>東京開発室
				<input type="radio" name="所属地" value="札幌"required>札幌
				<input type="submit" value="送信">
			</c:when>

			<%-- 札幌 --%>
			<c:otherwise >
				<input type="radio" name="所属地" value="東京"required>東京
				<input type="radio" name="所属地" value="東京開発室"required>東京開発室
				<input type="radio" name="所属地" value="宮崎"required>宮崎
				<input type="submit" value="送信">
			</c:otherwise>
		</c:choose>
		</form>

		<%-- メイン画面に戻る --%>
		<a href = "/aTeam/Main">戻る</a>
	<body>

</html>