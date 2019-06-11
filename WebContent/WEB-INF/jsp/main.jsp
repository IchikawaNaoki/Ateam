
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<% User loginUser = (User)session.getAttribute("loginUser"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在籍管理システム</title>
<link rel="stylesheet" type="text/css" href="/aTeam/WEB-INF/css/main.css">
</head>
<body>
<p>
<c:out value="${loginUser.name}" />さん、ログイン中
<a href="/aTeam/Logout">ログアウト</a>
<a href = "/aTeam/Main">更新</a>
</p>


<form action="/aTeam/Main" method="post">
	<input type="submit" value="東京" name="tokyo"
	style="position: absolute; left: 6%; top: 50%,
	width:200px; height:30px">

	<input type="submit" value="東京(開発室)" name="development"
	style="position: absolute; left: 11%; top: 50%,
	width:200px; height:30px"
	>

	<input type="submit" value="宮崎" name="miyazaki"
	style="position: absolute; left: 20%; top: 50%,
	width:200px; height:30px"
	>

	<input type="submit" value="札幌" name="sapporo"
	style="position: absolute; left: 25%; top: 50%,
	width:200px; height:30px"
>
</form>
<c:if test="${not empty errorMsg }">
	<p>${errorMsg}</p>
</c:if>
<c:forEach var="getDb" items="${getDbList}">
	<p><c:out value="${getDb.id}"/>:
		<c:out value="${getDb.name}"/>:
		<c:out value="${getDb.belong }"/>
		<c:out value="${getDb.status }"/>
		<c:out value="${getDb.comment }"/></p>
</c:forEach>

</body>

</html>