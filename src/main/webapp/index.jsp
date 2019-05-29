<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
        <a href="account/findAll">测试查询所有account/findAll</a>
        <br/>
        <form action="/account/save" method="post">
            账户名称：<input type="text" name="name"><br/>
            账户金额：<input type="text" name="money"><br/>
            <input type="submit" value="测试保存/account/save">
        </form>
        <label>查询一个</label>
        <form action="/account/findSingle" method="post">
            账户名称：<input type="text" name="name"><br/>
            <input type="submit" value="查询">
        </form>

        <label>删除一个</label>
        <label style="color: red">${message}</label>
        <form action="/account/delete_name" method="post">
            账户名称：<input type="text" name="name"><br/>
            <input type="submit" value="delete">
        </form>

        <label>修改一个</label>
        <form action="/account/update_s" method="post">
            账户名称：<input type="text" name="name"><br/>
            <input type="submit" value="update">
        </form>


<br/>
        <br/>
        <a href="/account/findAll">测试查询所有account/findAll</a>

        <br/>
        <a href="/account/findByExample?name=aaa&money=900">测试带条件查询account/findByExample?name=aaa&money=900</a>
        <br/>
        <a href="/account/findByExample?name=aaa">测试带条件查询account/findByExample?name=aaa</a>
        <br/>
        <a href="/account/findByExample?money=1000">测试带条件查询account/findByExample?money=1000</a>

        <br/>
        <form action="/account/save" method="post">
            账户名称：<input type="text" name="name"><br/>
            账户金额：<input type="text" name="money"><br/>
            <input type="submit" value="测试保存/account/add">
        </form>


        <br/>
        <a href="account/findByPage?page=1&pageSize=3">测试分页查询account/findByPage?page=1&pageSize=3</a>


</body>
</html>
