<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<br/>
<font color="red">${message}</font>
<form action="/user/login" method="post">
    帐号：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    <input type="submit" value="登录/user/login">
</form>
</body>
</html>
