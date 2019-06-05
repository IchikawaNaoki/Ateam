
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<title>在籍管理システム</title>
</head>
<body>
<p>
<c:out value="${loginUser.name}" />さん、ログイン中
<a href="aTeam">ログアウト</a>
</p>

<input type="button" value="東京"
style="position: absolute; left: 6%; top: 50%,
width:200px; height:30px"
>

<input type="button" value="東京(開発室)"
style="position: absolute; left: 11%; top: 50%,
width:200px; height:30px"
>

<input type="button" value="宮崎"
style="position: absolute; left: 20%; top: 50%,
width:200px; height:30px"
>

<input type="button" value="札幌"
style="position: absolute; left: 25%; top: 50%,
width:200px; height:30px"
>


</body>

</html>