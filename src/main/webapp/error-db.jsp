<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>データベース接続エラー</title>
</head>
<body>
	<h1>データベース接続エラー</h1>
	<p><%= request.getAttribute("errorMessage") %></p>
	<form action="category-list-servlet" method="GET">
		<input type="submit" value="カテゴリリスト一覧に戻る">
	</form>
</body>
</html>