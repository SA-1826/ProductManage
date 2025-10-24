<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリ情報-登録確認</title>
</head>
<body>
	次のカテゴリーを新規登録しました。
	<br>
	
	<jsp:useBean id="category" scope="request" class="model.entity.CategoryBean"/>
	ID:<jsp:getProperty name="category" property="id"/><br>
	カテゴリー名:<jsp:getProperty name="category" property="categoryName"/><br>
	<form action="category-list-servlet" method="GET">
		<input type="submit" value="カテゴリリスト一覧に戻る">
	</form>
</body>
</html>