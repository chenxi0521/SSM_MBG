<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <a href="/account/saveUI">添加</a>
    <h3>分页查询</h3>
    <table width="400" border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>money</th>
            <th>操作</th>
        </tr>
        <c:forEach  items="${pageInfo.list}" var="account">
            <tr>
                <td>${account.id}</td>
                <td>${account.name}</td>
                <td>${account.money}</td>
                <td>
                    <a href="/account/updateUI?id=${account.id}">编辑</a>
                    <a href="/account/delete?id=${account.id}&page=${pageNum}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <hr>
    当前第${pageInfo.pageNum}页 &nbsp;&nbsp; 共${pageInfo.pages}页 &nbsp;&nbsp; 每页显示${pageInfo.pageSize}条记录
    <hr>
    <a href="/account/findByPage?page=${pageInfo.navigateFirstPage}">首页</a>
    <a href="/account/findByPage?page=${pageInfo.prePage}">上一页</a>
    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNums">
        <a href="/account/findByPage?page=${pageNums}">${pageNums}</a> &nbsp;&nbsp;
    </c:forEach>
    <a href="/account/findByPage?page=${pageInfo.nextPage}">下一页</a>
    <a href="/account/findByPage?page=${pageInfo.navigateLastPage}">末页</a>
</center>
</body>
</html>
