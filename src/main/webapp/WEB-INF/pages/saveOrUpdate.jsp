<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="/account/saveOrUpdate" method="post">
    <input type="hidden" name="id" value="${account.id}">
    账户名称：<input type="text" name="name" value="${account.name}"><br/>
    账户金额：<input type="text" name="money"value="${account.money}"><br/>
    <input type="submit" value="测试保存/account/save">
</form>
</body>
</html>
