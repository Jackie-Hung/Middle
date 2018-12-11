<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2018/12/10
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <style>
        button{
            margin-left: 25px;
        }
        .form-group{
            margin-left: 200px;
        }
    </style>
</head>
<body>
<div class="modal-title">
    <h1 class="text-center">注销</h1>
</div>
<div class="modal-body">
    <form class="form-group" action="/logout.do" method="post">
        <button class="btn btn-primary" type="submit">注销</button>
        <button class="btn btn-danger" data-dismiss="modal">取消</button>
    </form>
</div>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.js"></script>
</body>
</html>