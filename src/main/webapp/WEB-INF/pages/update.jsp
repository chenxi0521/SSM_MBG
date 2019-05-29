<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/10
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/account/update" method="post">
    <input type="hidden" name="id" value="${account.id}">
    账户名称：<input type="text" name="name" value="${account.name}"><br/>
    账户金额：<input type="text" name="money" value="${account.money}"><br/>
    <input type="submit" value="保存">
</form>
</body>
</html>
