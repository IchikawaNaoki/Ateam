<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--
<%@ page import="model.User" %>
<%@ page import= "model.GetDB" %>-->

<%--<% User loginUser = (User)session.getAttribute("loginUser"); %>
<%--<% GetDB employee = (GetDB)session.getAttribute("employee") ;--%>
<% Object status = session.getAttribute("status"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>在籍管理システム</title>
		<link rel= "stylesheet" type="text/css" href = "css/main.css">
		<script type = "text/javascript" src = "WebContent/music.js"></script>
		<!-- jQuery -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<meta name="google" content="notranslate" />

		<%--ログアウトのポップアップ --%>
		<script type="text/javascript">
			function logoutStart(){
				var selectResult = confirm('ログアウトしますか?');
				if(selectResult){
					return true;
				}
				else{
					return false;
				}
			}
		</script>
	</head>

	<body>
		<c:out value="${loginUser.name}" />さん

		<%--ログアウトボタン --%>
		<form action="/aTeam/Logout" method="get" onSubmit="return logoutStart()">
			 <input id="logout" type="submit" value="ログアウト" >
		</form>
		<audio id="sound-file" preload="auto">
			<source src="music/click.mp3" type="audio/mp3">
		</audio>

		<%--自分の在席状況の表示 --%>
		<c:choose>
			<c:when test="${employee.status == \"在席\"}">
				<p>在席中です</p>
			</c:when>

			<c:otherwise>
				<p>不在です</p>
			</c:otherwise>
		</c:choose>

		<ul class = "dropmenu" >
			<li>
				<a href = "javascript:void(0)">メニュー画面</a>
			</li>
			<li class = "menu__single" >
				<a href = "javascript:void(0)" class = "init-bottom">在席/離席 選択</a>
				<ul class = "menu__single_level" >
					<li>
						<form action = "/aTeam/Main"  method = "post"  name = "zaiseki">

							<input type = "hidden"  name = "Presence" value = "在席">
							<a href = "javascript:zaiseki.submit()">在席</a>

						</form>
					</li>
					<li>
						<form action = "/aTeam/Main"  method = "post" name = "riseki">
							<input type = "hidden"  name = "leave seat"  value = "離席">
							<a href = "javascript:riseki.submit()">離席</a>
						</form>
					</li>
					<li>
					<a href = "/aTeam/CommentInput">コメント</a>
					</li>
					<li>
						<a href = "/aTeam/PassChangeUser">パスワード変更</a>
					</li>
				</ul>
			</li>
			<li class = "menu__single">
				<a href = "javascript:void(0)">オフィス選択</a>
				<ul class = "menu__single_level">
					<li>
					<%--東京 --%>
						<form action = "/aTeam/Main"  method = "post"  name = "first">
							<input type = "hidden"  name = "tokyo"  value = "東京">
							<a href = "javascript:first.submit()">東京</a>
						</form>
					</li>
					<li>
					<%--東京開発室 --%>
						<form action = "/aTeam/Main"  method = "post"  name = "second">
							<input type = hidden name = "development"  value = "東京開発室">
							<a href="javascript:second.submit()">東京開発室</a>
						</form>
					</li>
					<li>
					<%--宮崎 --%>
						<form action = "/aTeam/Main"  method ="post" name = "third">
							<input type = hidden name = "miyazaki"  value = "宮崎">
							<a href = "javascript:third.submit()">宮崎</a>
						</form>
					</li>
					<li>
					<%--札幌 --%>
						<form action = "/aTeam/Main" method = "post" name = "force">
							<input type = hidden name = sapporo value = "札幌">
							<a href = "javascript:force.submit()">札幌</a>
						</form>
					</li>
				</ul>
			</li>
			<li>
				<a href = "/aTeam/UpdateUser">部署変更</a>
			</li>
			<li>
				<a href = "/aTeam/Main">全件表示</a>
			</li>
		</ul>

		<div class="list">
			<c:if test="${not empty errorMsg}">
				<p>${errorMsg}</p>
			</c:if>

			<c:forEach var ="getDb" items ="${getDbList}">
		    		<c:out value ="${getDb.name}"/>
					<c:out value ="${getDb.belong}"/>
					<c:if test="${ getDb.status == '在席'}">
					<font color="red"><c:out value ="${getDb.status}"/></font>
		        	</c:if>
		        	<c:if test="${ getDb.status == '不在'}">
					<font color="blue"><c:out value ="${getDb.status}"/></font>
		        	</c:if>
		        	<c:out value ="${getDb.comment}"/><br>
			</c:forEach>
		</div>

		<p id = "pageTop">
			<a href = "#">↑</a>
		</p>

	</body>
</html>
