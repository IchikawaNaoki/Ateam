<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/register.css">
		<title>ユーザー登録</title>
		<script type="text/javascript">
			var cheak = function(){
				if(window.confirm('下記のユーザーで登録しますか？')){
					<% Boolean registerResult = (Boolean)session.getAttribute("isRegister");%>
					if(<%=registerResult%>){
						return true;
					}
					else{
						alert("すでに登録されています。");
						return false;
					}
				}
				else{
					return false;
				}
			}
		</script>
	</head>

	<body>
		<h1>新規ユーザー登録</h1>
		<p>登録する社員名と、</p>
		<p>大文字から始まる、4～8文字の</p>
		<p>パスワードを半角英数字で入力。</p>
		<p>また、部署を選んでください</p>
		<form action="/aTeam/RegisterUser" method="post" onSubmit="return cheak()">
			    社員名:<input type="text" name="name" required><br>
			パスワード:<input type="password" name="pass" required><br>
			<input type="radio" name="belongs" value="未配属"required>未配属
			<input type="radio" name="belongs" value="東京"required>東京
			<input type="radio" name="belongs" value="東京開発室"required>東京開発室
			<input type="radio" name="belongs" value="宮崎"required>宮崎
			<input type="radio" name="belongs" value="札幌"required>札幌
			<br>
			<button id="register" type="submit">
				登録
			</button>
		</form>
		<form action="/aTeam/Login"method="post">
			<button type="submit"  id="register" >
				戻る
			</button>
		</form>
	</body>
</html>