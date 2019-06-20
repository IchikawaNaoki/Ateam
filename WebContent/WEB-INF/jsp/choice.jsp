<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="model.User" %>
<%@ page import = "model.GetDB" %>

<% User loginUser = (User)session.getAttribute("loginUser"); %>
<% GetDB getDbList = (GetDB)session.getAttribute("getDbList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在籍管理システム</title>
</head>
<body>
	<h1>ようこそ<c:out value="${loginUser.name}"/>さん</h1>
	<p>現在<c:out value="${getDbList.belong}"/>に所属しています。</p>
	<p>全件表示にしますか、それとも所属している部署のみ表示しますか。</p>
	<form action="/aTeam/Main" method="post">
		<input type="submit"  value="全件表示" >
	</form>
	<form action="/aTeam/Main" method="post">
			<c:when test="${getDbList.belong == \"東京\"}">
				<input type="submit" name="tokyo" value="東京部署のみ表示" >
			</c:when>
			<c:when test="${getDbList.belong == \"東京開発室\"}">
				<input type="submit" name="development" value="東京開発室のみ表示" >
			</c:when>
			<c:when test="${getDbList.belong == \"宮崎\"}">
				<input type="submit" name="miyazaki" value="宮崎部署のみ表示" >
			</c:when>
			<c:when test="${getDbList.belong == \"札幌\"}">
				<input type="submit" name="sapporo" value="札幌部署のみ表示" >
			</c:when>
	</form>
</body>
</html>