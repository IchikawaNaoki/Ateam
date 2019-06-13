<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<% User loginUser = (User)session.getAttribute("loginUser"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在籍管理システム</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript" src="main.js"></script>

</head>
<body>

<c:out value="${loginUser.name}" />さん ログイン中


<form action="/aTeam/Main" method="post">

	<input type="submit" value="在席" name="Presence"
	style="position: absolute; left: 0%; top: 10%,
	width:200px; height:30px">

	<input type="submit" value="離席" name="leave seat"
	style="position: absolute; left: 10%; top: 10%,
	width:200px; height:30px">
</form>





<a href="/aTeam/Logout" id="logout">ログアウト</a>

<form action="/aTeam/Main" method="post" name="first">
<ul id="dropmenu" style="clear:both;">
<li><a href="/">メニュー画面</a>
</li>
<li><a href="/">在席/離席 選択</a>
<ul>
<li><input type="radio" name="select" value="在席">在席</li>
<li><input type="radio" name="select" value="離席">離席</li>
</ul>
</li>


<li><a href="/">オフィス選択</a>
<ul>
<form action="/aTeam/Main" method="post" name="first">
<li><input type="hidden" name="tokyo" value="東京">
<a href="javascript:first.submit()">東京</a></li>
</form>

<form action="/aTeam/Main" method="post" name="second">
<li><input type=hidden name="development" value="東京(開発室)">
<a href="javascript:second.submit()">東京(開発室)</a></li>
</form>

<form action="/aTeam/Main" method="post" name="third">
<li><input type=hidden name="miyazaki" value="宮崎">
<a href="javascript:third.submit()">宮崎</a></li>
</form>

<form action="/aTeam/Main" method="post" name="force">
<li><input type=hidden name=sapporo value="札幌">
<a href="javascript:force.submit()">札幌</a></li>
</form>
</ul>
</li>


<li><a href="/aTeam/UpdateUser">部署変更</a>
</li>
<li><a href = "/aTeam/Main">全件表示</a>
</li>
</ul>
</form>

<!--
<form action="/aTeam/Main" method="post">

	<input type="submit" value="在席" name="Presence"
	style="position: absolute; left: 0%; top: 10%,
	width:200px; height:30px">

	<input type="submit" value="離席" name="leave seat"
	style="position: absolute; left: 10%; top: 10%,
	width:200px; height:30px">
</form>
	<input type="submit" value="すべて" name="all"
	style="position: absolute; left: 6%; top: 50%,
	width:200px; height:30px">


	<input type="submit" value="東京" name="tokyo"
	style="position: absolute; left: 12%; top: 50%,
	width:200px; height:30px">

	<input type="submit" value="東京(開発室)" name="development"
	style="position: absolute; left: 17%; top: 50%,
	width:200px; height:30px"
	>

	<input type="submit" value="宮崎" name="miyazaki"
	style="position: absolute; left: 28%; top: 50%,
	width:200px; height:30px"
	>

	<input type="submit" value="札幌" name="sapporo"
	style="position: absolute; left: 33%; top: 50%,
	width:200px; height:30px"
>
</form> -->


<c:if test="${not empty errorMsg }">
	<p>${errorMsg}</p>
</c:if>
<c:forEach var="getDb" items="${getDbList}">
	<p><c:out value="${getDb.name}"/>:
		<c:out value="${getDb.belong }"/>
		<c:out value="${getDb.status }"/>
		<c:out value="${getDb.comment }"/></p>
</c:forEach>

</body>

</html>