<%--
  Created by IntelliJ IDEA.
  User: Hibiki
  Date: 2022-06-28
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
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
  <!--  popper.min.js 用于弹窗、提示、下拉菜单 -->
  <script src="https://cdn.staticfile.org/popper.js/2.9.3/umd/popper.min.js"></script>

  <script src=""></script>
</head>

<body class="">
<div class="container">
  <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
    <ol class="breadcrumb">
      <li class="breadcrumb-item"><a href="#">图书管理</a></li>
      <li class="breadcrumb-item active" aria-current="page">增加图书</li>
    </ol>
  </nav>
</div>


<div class="container container-fluid">
  <form action="book.do?method=add" method="post">

    <div class="row">
      <div class="col-4">
        <label for="inputEmail4" class="form-label">图书名称</label>
        <input type="text" name="bookName" class="form-control" id="inputEmail4">
      </div>
      <div class="col-4">
        <label for="inputPassword4" class="form-label">作者</label>
        <input type="text" name="author" class="form-control" id="inputPassword4">
      </div>
    </div>

    <div class="row">
      <div class="col-4">
        <label for="inputAddress" class="form-label">出版社</label>
        <input type="text" name="publisher" class="form-control" id="inputAddress" >
      </div>
      <div class="col-4">
        <label for="inputAddress2" class="form-label">类别</label>
        <select id="inputState" name="categoryId" class="form-select">
          <option value="1" selected>科技</option>
          <option value="2">心理学</option>
          <option value="3">小说</option>
          <option value="4">经济学</option>
          <option value="5">畅销书</option>
          <option value="6">计算机</option>
          <option value="7">法律</option>
          <option value="8">英语</option>
          <option value="9">儿童</option>
        </select>

      </div>

    </div>

    <div class="row">
      <div class="col-md-4">
        <label for="inputCity" class="form-label">价格</label>
        <input type="number" name="price" class="form-control" id="inputCity">
      </div>
      <div class="col-md-4">
        <label for="inputState" class="form-label">售价</label>
        <input type="number" class="form-control" id="inputAddress2" name="salePrice"
        >
      </div>

    </div>

    <div class="col-12" style="height: 10px;">

    </div>


    <div class="col-12">
      <button type="submit" class="btn btn-primary">添加图书</button>
    </div>
  </form>
</div>







</body>
</html>

