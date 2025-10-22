<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録エラー</title>
</head>
<body>
	<h1>登録エラー</h1>
	<p><%= request.getAttribute("errorMessage") %></p>
	<form action="category-register-form-servlet" method="POST">
		<input type="submit" value="入力フォームに戻る">
	</form>
</body>
</html>