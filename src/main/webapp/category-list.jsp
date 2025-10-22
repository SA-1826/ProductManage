<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, model.entity.CategoryBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カテゴリリスト一覧</title>
</head>
<body>
	<%
		List<CategoryBean> categoryList = (List<CategoryBean>) request.getAttribute("categoryList");
	%>
	
	<table border="1">
		<tr>
			<th>カテゴリID</th>
			<th>カテゴリ名</th>
		</tr>
		<%
			for (CategoryBean category : categoryList) {
		%>
		<tr>
			<td><%=category.getId() %></td>
			<td><%=category.getCategoryName() %>
		</tr>
		<%
			}
		%>
	</table>
	
	<form action="category-register-form-servlet" method="POST">
		<input type="submit" value="新規カテゴリー登録">
	</form>
</body>
</html>