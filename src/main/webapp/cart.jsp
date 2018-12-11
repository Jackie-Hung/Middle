<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="beans.Book" %>
<%@ page import="dao.BookDao" %><%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2018/12/2
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>cart</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/proList.css" />
    <script src="js/jquery.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
    <style>
        .header{
            width: 100%;
            position: fixed;
            top: 0;
        }
        .header .nav{
            margin: 0 auto;
            width: 1160px;
            height: 40px;
            padding: 20px 0;
            background: #fff;
            z-index: 100;
        }
        .wrapper{
            margin: 80px auto 0;
        }
        .fl img{
            width: 100px;
            height: 120px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="nav">
        <span class="fl">购物车</span>
        <a href="index.jsp" class="fr">继续购物&gt;</a>
    </div>
</div>
<div class="table wrapper">
    <div class="tr">
        <div>商品</div>
        <div>单价</div>
        <div>数量</div>
        <div>小计</div>
        <div>操作</div>
    </div>
    <div class="goOn">空空如也~<a href="index.jsp">去逛逛</a></div>
    <%
        BookDao dao = new BookDao();
        Map<String,Integer> cartMap = (Map<String,Integer>)session.getAttribute("cartMap");
        if(cartMap!=null){
        for (Map.Entry<String, Integer> entry : cartMap.entrySet()) {
            Book book = dao.findBookById(Integer.parseInt(entry.getKey()));
    %>
    <div class="th">
        <div class="pro clearfix">
            <label class="fl">
                <input type="checkbox"/>
                <span></span>
            </label>
            <a class="fl" href="#">
                <dl class="clearfix">
                    <dt class="fl"><img src="<%=book.getIamge()%>"></dt>
                    <dd class="fl">
                        <p><%=book.getName()%></p>
                        <p><%=book.getAuthor()%></p>
                        <p>id:<span class="id"><%=book.getId()%></span></p>
                    </dd>
                </dl>
            </a>
        </div>
        <div class="price">￥<%=book.getPrice()%></div>
        <div class="number">
            <p class="num clearfix">
                <img class="fl sub" src="images/sub.jpg">
                <span class="fl"><%=entry.getValue() %></span>
                <img class="fl add" src="images/add.jpg">
            </p>
        </div>
        <div class="price sAll">￥<%=book.getPrice()%></div>
        <div class="price"><a class="del" href="#2">删除</a></div>
    </div>

<%
        }
    }
    else {
%>
    <script>
        $(".goOn").show();
    </script>
    <%
        }
    %>


    <div class="tr clearfix">
        <label class="fl">
            <input class="checkAll" type="checkbox"/>
            <span></span>
        </label>
        <p class="fl">
            <a href="#">全选</a>
            <a href="#" class="del">删除</a>
        </p>
        <p class="fr">
            <span>共<small id="sl">0</small>件商品</span>
            <span>合计:&nbsp;<small id="all">￥0.00</small></span>
            <a href="showOrder.jsp" class="count">结算</a>
        </p>
    </div>
</div>
</div>
<div class="mask"></div>
<div class="tipDel">
    <p>确定要删除该商品吗？</p>
    <p class="clearfix">
        <a class="fl cer" href="#">确定</a>
        <a class="fr cancel" href="#">取消</a>
    </p>
</div>
</body>
</html>
