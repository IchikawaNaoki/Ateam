<%@ page language="java" contentType="text/html;" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>在籍管理システム</title>
	</head>

	<body>
	<p>
		<c:out value="${loginUser.name}" />さん、ログイン中
		<a href="aTeam">ログアウト</a>
	</p>

	<p><a href="/aTeam/Main">更新</a></p>
	<form action="/aTeam/Main" method="post">
	</form>

	<c:if test="${not empty errorMsg}">
		<p>${errorMsg}</p>
	</c:if>

	<c:forEach var="mutter" items="${mutterList}">
		<p><c:out value="${mutter.userName}" />:
			<c:out value="${mutter.text}" /></p>
	</c:forEach>

	</body>
</html>