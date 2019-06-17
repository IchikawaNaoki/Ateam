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

<a href="/aTeam/Logout" id="logout">ログアウト</a>



<ul id="dropmenu" style="clear:both;">
<li><a href="javascript:void(0)">メニュー画面</a></li>


<li><a href="javascript:void(0)">在席/離席 選択</a>
<ul>
<li>
<form action="/aTeam/Main" method="post" name="zaiseki">
<li><input type="hidden" name="Presence" value="在席">
<a href="javascript:zaiseki.submit()">在席</a></li>
</li>
</form>

<li>
<form action="/aTeam/Main" method="post" name="riseki">
<li><input type="hidden" name="leave seat" value="離席">
<a href="javascript:riseki.submit()">離席</a></li>
</li>
</form>
</ul>








<li><a href="javascript:void(0)">オフィス選択</a>
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