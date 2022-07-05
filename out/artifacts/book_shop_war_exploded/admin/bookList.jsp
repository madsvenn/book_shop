<%--
  Created by IntelliJ IDEA.
  User: Hibiki
  Date: 2022-06-28
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
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
            <li class="breadcrumb-item active" aria-current="page">查询图书</li>
        </ol>
    </nav>
</div>


<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <button class="btn btn-success" onclick="location='bookAdd.jsp'"><i class="icon-plus"></i> 增加</button>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">


                </ul>
                <form class="d-flex" role="search">
                    <input  type="search" placeholder="书名" aria-label="Search">
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
            <th>作者</th>
            <th>出版社</th>
            <th>价格</th>
            <th>售价</th>
            <th>数量</th>
            <th style="width: 26px;"></th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${pageInfo.list}" var="b" varStatus="state">
        <tr>
            <td>${state.count+(pageInfo.currentPage-1)*pageInfo.recordSize}</td>
            <td>${b.bookName}</td>
            <td>${b.author}</td>
            <td>${b.publisher}</td>
            <td>${b.price}</td>
            <td>${b.salePrice}</td>
            <td>${b.amount}</td>
            <td>
                <a href="book.do?method=view&bookId=${b.bookId}"><i class="icon-pencil"></i></a>

            </td>
            <td>
                <a href="book.do?method=delete&bookId=${b.bookId}" role="button" data-toggle="modal"><i
                        class="icon-remove"></i></a>
            </td>
        </tr>
        </c:forEach>



        </tbody>
    </table>
    <form id="subPage_form" method="post" action="${pageInfo.url}">
        <input type="hidden" name="method" value="${pageInfo.method}">
        <input id="page_currentPage" type="hidden" name="currentPage" value="">
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-lg-end">
            <li class="page-item disabled">
                <a class="page-link">总记录数：${pageInfo.recordCount}</a>
            </li>

            <c:choose>
                <c:when test="${1==pageInfo.currentPage}">
                    <li class="page-item disabled">
                        <a class="page-link">上一页</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link">上一页</a>
                    </li>
                </c:otherwise>
            </c:choose>
            <c:forEach begin="1" end="${pageInfo.pageCount}" var="pageNum">
                <c:choose>
                    <c:when test="${pageNum==pageInfo.currentPage}">
                        <li class="page-item disabled">
                            <a class="page-link" href="javascript:void(0)" id="page2">${pageNum}</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link" href="javascript:void(0)" id="page1">${pageNum}</a></li>
                    </c:otherwise>
                </c:choose>

            </c:forEach>

<%--            <li class="page-item"><a class="page-link" href="javascript:void(0)" id="page1">1</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="javascript:void(0)" id="page2">2</a></li>--%>
<%--            <li class="page-item"><a class="page-link" href="javascript:void(0)" id="page3">3</a></li>--%>
            <c:choose>
                <c:when test="${pageInfo.pageCount==pageInfo.currentPage}">
                    <li class="page-item disabled">
                        <a class="page-link" href="javascript:void(0)">下一页</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="javascript:void(0)">下一页</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>
    </form>
</div>







</body>
</html>
