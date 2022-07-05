<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
	</head>

	<body class="">
		<div class="container container-fluid bg-light">
			<nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="#">图书管理</a></li>
					<li class="breadcrumb-item active" aria-current="page">出入库列表</li>
				</ol>
			</nav>
		</div>


		<div class="container">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<button class="btn btn-success" onclick="location='book.do?method=viewRepositories'"><i class="icon-plus"></i>
						出入库</button>
					<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
						data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
						aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">


						</ul>
						<form class="d-flex" role="search">
							<input type="search" placeholder="书名" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">查询</button>
						</form>
					</div>
				</div>
			</nav>

		</div>



		<div class="container">

			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>图书名称</th>
						<th>操作类别</th>
						<th>操作数量</th>
						<th>库存量</th>
						<th>时间</th>
						<th>操作者</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="r" varStatus="state">
					<tr>
						<td>${state.count}</td>
						<td>${r.bookName}</td>
						<td>${r.kind}</td>
						<td>${r.count}</td>
						<td>${r.balance}</td>
						<td><fmt:formatDate value="${r.executeTime}" pattern="YYYY-MMM-dd HH:mm:ss"></fmt:formatDate></td>
						<td>${r.operator}</td>

					</tr>
				</c:forEach>
				</tbody>
			</table>

			<nav aria-label="Page navigation example">
				<ul class="pagination justify-content-lg-end">
					<li class="page-item disabled">
						<a class="page-link">Previous</a>
					</li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item">
						<a class="page-link" href="#">Next</a>
					</li>
				</ul>
			</nav>
		</div>



	</body>
</html>
