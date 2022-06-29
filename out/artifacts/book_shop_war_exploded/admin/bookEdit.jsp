<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Bootstrap Admin</title>
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">


		<link rel="stylesheet" type="text/css" href="js/dist/css/bootstrap.css">
		<link rel="stylesheet" href="js/dist/font-awesome/css/font-awesome.css">
		<script src="js/dist/js/bootstrap.js"></script>
		<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
	</head>

	<body class="">

		<div class="container container-fluid">
			<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">图书管理</a></li>
					<li class="breadcrumb-item active" aria-current="page">增加图书</li>
				</ol>
			</nav>
		</div>


		<div class="container container-fluid">
			<form action="book.do?method=edit" method="post">
				<input type="hidden" name="bookId" value="${book.bookId}">
				<div class="row">
					<div class="col-4">
						<label for="inputEmail4" class="form-label">图书名称</label>
						<input type="text" name="bookName" class="form-control" id="inputEmail4" value="${book.bookName}">
					</div>
					<div class="col-4">
						<label for="inputPassword4" class="form-label">作者</label>
						<input type="text" name="author" class="form-control" id="inputPassword4" value="${book.author}">
					</div>
				</div>

				<div class="row">
					<div class="col-4">
						<label for="inputAddress" class="form-label">出版社</label>
						<input type="text" name="publisher" class="form-control" id="inputAddress" placeholder="出版社" value="${book.publisher}">
					</div>
					<div class="col-4">
						<label for="inputAddress2" class="form-label">类别</label>
						<select id="inputState" name="categoryId" class="form-select">
<%--							<option value="1" selected>科技</option>--%>
<%--							<option value="2">心理学</option>--%>
<%--							<option value="3">小说</option>--%>
<%--							<option value="4">经济学</option>--%>
<%--							<option value="5">畅销书</option>--%>
<%--							<option value="6">计算机</option>--%>
<%--							<option value="7">法律</option>--%>
<%--							<option value="8">英语</option>--%>
<%--							<option value="9">儿童</option>--%>
							<c:forEach items="${categoryList}" var="c">
								<c:choose>
									<c:when test="${c.categoryId==book.categoryId}">
										<option value="${c.categoryId}" selected>${c.categoryName}</option>
									</c:when>
									<c:otherwise>
										<option value="${c.categoryId}">${c.categoryName}</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</select>

					</div>

				</div>

				<div class="row">
					<div class="col-md-4">
						<label for="inputCity" class="form-label">价格</label>
						<input type="text" name="price" class="form-control" id="inputCity" value="${book.price}">
					</div>
					<div class="col-md-4">
						<label for="inputState" class="form-label">售价</label>
						<input type="text" class="form-control" id="inputAddress2" name="salePrice" placeholder="售价" value="${book.salePrice}">
					</div>

				</div>

				<div class="col-12" style="height: 10px;">

				</div>

				<div class="col-12">
					<button type="submit" class="btn btn-primary">修改</button>
				</div>
			</form>
		</div>







	</body>
</html>
