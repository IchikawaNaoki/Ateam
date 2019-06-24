<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<!-- setAttributeで呼べ！！ -->
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/updateConfirm.css">
		<script type="text/javascript" src=>"WebContent/music.js"</script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<title>ユーザー情報更新</title>
	</head>

	<body>
	<h1>情報更新</h1>
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
				<input type="radio" name="所属地" value="札幌"required>札幌<br>
				<button onClick="soundplayAndSubmit(this.parentElement);return false;" id="update" type="submit">送信</button>
			</c:when>

			<%-- 東京(開発室) --%>

			<c:when test="${getDbList.belong == \"東京開発室\"}">

				<input type="radio" name="所属地" value="東京"required>東京
				<input type="radio" name="所属地" value="宮崎"required>宮崎
				<input type="radio" name="所属地" value="札幌"required>札幌<br>
				<button onClick="soundplayAndSubmit(this.parentElement);return false;" id="update" type="submit">送信</button>
			</c:when>

			<%-- 宮崎 --%>
			<c:when test="${getDbList.belong == \"宮崎\"}">
				<input type="radio" name="所属地" value="東京"required>東京
				<input type="radio" name="所属地" value="東京開発室"required>東京開発室
				<input type="radio" name="所属地" value="札幌"required>札幌<br>
				<button onClick="soundplayAndSubmit(this.parentElement);return false;" id="update" type="submit">送信</button>
			</c:when>

			<%-- 札幌 --%>
			<c:otherwise >
				<input type="radio" name="所属地" value="東京"required>東京
				<input type="radio" name="所属地" value="東京開発室"required>東京開発室
				<input type="radio" name="所属地" value="宮崎"required>宮崎<br>
				<button onClick="soundplayAndSubmit(this.parentElement);return false;" id="update" type="submit">送信</button>
			</c:otherwise>
		</c:choose>
		</form>

		<%-- メイン画面に戻る --%>

		<form action="/aTeam/Main"method="get" >
		<button onClick="soundplayAndSubmit(this.parentElement);return false;" id="update" type="submit">戻る</button>
		<audio id="sound-file" preload="auto">
		<source src="music/click.mp3" type="audio/mp3">
		</audio>
	</form>
	<body>

</html>