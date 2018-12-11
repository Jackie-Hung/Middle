<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2018/12/10
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<div class="modal-title">
    <h1 class="text-center">注册</h1>
</div>
<div class="modal-body">
    <form class="form-group" action="/logup.do" method="post">
        <div class="form-group">
            <label>*用户名</label>
            <input name="username" class="form-control" type="text"
                   placeholder="不可为空">
        </div>
        <div class="form-group">
            <label>*密码</label>
            <input name="password" class="form-control" type="password"
                   placeholder="密码长度不少于6位">
        </div>
        <div class="form-group">
            <label>*确认密码</label>
            <input name="repassword" class="form-control" type="password"
                   placeholder="重新确认密码">
        </div>
        <div class="form-group">
            <label>电话号码</label>
            <input name="phone" class="form-control" type="text"
                   placeholder="可不填写">
        </div>
        <div class="form-group">
            <label>cellphone</label>
            <input name="phone" class="form-control" type="text"
                   placeholder="可不填写">
        </div>
        <div class="form-group">
            <label>地址</label>
            <input name="address" class="form-control" type="text"
                   placeholder="可不填写">
        </div>
        <div class="form-group">
            <label>邮件</label>
            <input name="email" class="form-control" type="text"
                   placeholder="可不填写">
        </div>
        <div class="text-right">
            <button class="btn btn-primary" type="submit">注册</button>
            <button class="btn btn-danger" data-dismiss="modal">取消</button>
        </div>
    </form>
</div>
</body>
</html>
