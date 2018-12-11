package servlets;

import beans.Orders;
import dao.OrdersDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ShowOrderServlet extends HttpServlet {
    public ShowOrderServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String provinceId = request.getParameter("provinceId");

        String userid = request.getParameter("userid");
        OrdersDao dao = new OrdersDao();
        List<Orders> ordersList = dao.findByUserid(userid);
        JSONArray ja = JSONArray.fromObject(ordersList);
        String orderListStr = ja.toString();
        System.out.println(orderListStr);
        //JsonUtil.writeJsonString(resp, cityListStr);
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.write(orderListStr);
        out.close();
        response.flushBuffer();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
