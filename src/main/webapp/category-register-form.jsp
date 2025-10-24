<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ情報入力フォーム</title>
</head>
<body>
	<form action="category-register-servlet" method="POST">
		ID:<input type="number" name="id" required><br>
		カテゴリー名:<input type="text" name="categoryName" required><br>
		<input type="submit" value="登録する">
	</form>
</body>
</html>