<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Bootstrap Admin</title>
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css"> -->
		<!-- <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css"> -->
		<!-- <script src="lib/bootstrap/js/bootstrap.js"></script> -->

		<link rel="stylesheet" type="text/css" href="js/dist/css/bootstrap.css">
		<!-- 	<link rel="stylesheet" type="text/css" href="stylesheets/theme.css"> -->
		<link rel="stylesheet" href="js/dist/font-awesome/css/font-awesome.css">
		<script src="js/dist/js/bootstrap.js"></script>
		<script src="lib/jquery-1.7.2.min.js" type="text/javascript"></script>
	</head>

	<body class="">
		<div class="container container-fluid">
			<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">图书管理</a></li>
					<li class="breadcrumb-item active" aria-current="page">出入库</li>
				</ol>
			</nav>
		</div>


		<div class="container container-fluid">
			<form action="book.do?method=repositories" method="post">

				<div class="row">
					<div class="col-4">
						<label class="form-label">图书名称</label>
						<select name="bookId" class="form-select">
							<c:forEach items="${list}" var="b">
								<option value="${b.bookId}">${b.bookName}</option>
							</c:forEach>
						</select>
<%--						<datalist id="bookList">--%>
<%--							<option>数学之美</option>--%>
<%--							<option>兄弟</option>--%>
<%--							<option>活着</option>--%>
<%--							<option>自卑与超越</option>--%>
<%--							<option>自卑与超越2</option>--%>
<%--							<option>自卑的我</option>--%>
<%--						</datalist>--%>
					<!-- 	
						<select id="inputState" name="bookId" class="form-select">
						
						</select> -->
					</div>

					<div class="col-4">
						<label for="inputAddress" class="form-label">当前库存</label>
						<input type="text" name="balance" value="90" disabled="disabled" class="form-control">
					</div>

				</div>

				<div class="row">
					<div class="col-4">
						<label  class="form-label">操作类型</label>

						<select id="inputState" name="kind" class="form-select">
							<option value="in" selected>入库</option>
							<option value="out">出库</option>

						</select>

					</div>

					<div class="col-4">
						<label for="inputAddress" class="form-label">数量</label>
						<input type="number" name="count" class="form-control" id="inputAddress">
					</div>


				</div>

	

				<div class="col-12" style="height: 10px;">

				</div>


				<div class="col-12">
					<button type="submit" class="btn btn-primary">确认</button>
				</div>
			</form>
		</div>







	</body>
</html>
