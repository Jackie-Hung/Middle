$(function () {


    $.ajax({

        // url: '/showOrders?userid='+$("#userid").val(),
        url: '/showOrders?userid=4',

        type: 'GET',

        dataType: 'json',

        timeout: 1000,

        cache: false,

        beforeSend: LoadFunction, //加载执行方法

        error: erryFunction,  //错误执行方法

        success: succFunction //成功执行方法

    })


    function LoadFunction() {

        $("#book").html('加载中...');

    }

    function erryFunction() {

        alert("error");

    }

    function succFunction(tt) {



        var json = eval(tt); //数组

        $.each(json, function (index, item) {

            //循环获取数据

            var id = json[index].id;
            var ordertime = json[index].ordertime;
            var price = json[index].price;
            var state = json[index].state;
            var userid = json[index].user_id;



            $("#content").html($("#content").html()+"<div class=\"dkuang\">\n" +
                "                <p class=\"one\">已收货</p>\n" +
                "                <div class=\"word clearfix\">\n" +
                "                    <ul class=\"fl clearfix\">\n" +
                "                        <li>2016年12月1日 18:53</li>\n" +
                "                        <li>杨小黄</li>\n" +
                "                        <li>订单号:5160513358520018</li>\n" +
                "                        <li>在线支付</li>\n" +
                "                    </ul>\n" +
                "                    <p class=\"fr\">订单金额：<span>"+price+"</span>元</p>\n" +
                "                </div>\n"+
                "                <div class=\"shohou clearfix\">\n" +
                "                    <a href=\"#\" class=\"fl\"><img src=\"img/g1.jpg\"/></a>\n" +
                "                    <p class=\"fl\"><a href=\"#\">家用创意菜盘子圆盘 釉下彩复古</a><a href=\"#\">¥99.00×1</a></p>\n" +
                "                    <p class=\"fr\">\n" +
                "                        <a href=\"myprod.html\">待评价</a>\n" +
                "                        <a href=\"orderxq.html\">订单详情</a>\n" +
                "                    </p>\n" +
                "                </div>\n" +
                "            </div>");

        });

    }

});
function showBook(categoryID) {
    $.ajax({

        url: '/api/home/'+ categoryID,

        type: 'GET',

        dataType: 'json',

        timeout: 1000,

        cache: false,

        beforeSend: LoadFunction, //加载执行方法

        error: erryFunction,  //错误执行方法

        success: succFunction //成功执行方法

    })

    function LoadFunction() {

        $("#book").html('加载中...');

    }

    function erryFunction() {

        alert("error");

    }

    function succFunction(tt) {

        $("#book").html('');

        //eval将字符串转成对象数组

        //var json = { "id": "10086", "uname": "zhangsan", "email": "zhangsan@qq.com" };

        //json = eval(json);

        //alert("===json:id=" + json.id + ",uname=" + json.uname + ",email=" + json.email);

        var json = eval(tt); //数组
        //$("#book").html();
        $.each(json, function (index, item) {

            //循环获取数据

            var name = json[index].name;

            var description = json[index].description;



            $("#book").html($("#book").html() + "<div class=\"col-sm-9 col-md-3\"><div class=\"thumbnail\" ><img src=\"images/book.jpg\"><div class=\"caption\">  <h4>"+name+"</h4><p>"+description+"</p><p><a href=\"#\" class=\"btn btn-primary\" role=\"button\">加入购物车</a> <a href=\"#\" class=\"btn btn-default\" role=\"button\">查看详情\n" +
                "</a></p></div></div> </div>");

        });

    }
}