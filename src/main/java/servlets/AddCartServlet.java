package servlets;

import beans.Book;
import dao.BookDao;
import org.apache.commons.collections.map.HashedMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.System.out;


public class AddCartServlet extends HttpServlet {
    Map<String,Integer> cartMap = new HashMap<String, Integer>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int num = Integer.parseInt(request.getParameter("num"));
        PrintWriter out = response.getWriter();

        //判断key是否存在
        if (cartMap.containsKey(id)) {
            cartMap.put(id, num);
            out = response.getWriter();
            out.write("{\"result\":\"false\"}");
            out.close();
        } else {
            cartMap.put(id, 1);
            out = response.getWriter();
            out.write("{\"result\":\"true\"}");
            out.close();
        }

        HttpSession session = request.getSession();
        session.setAttribute("cartMap", cartMap);

//        test
        System.out.println("[");
        for (Map.Entry<String, Integer> entry : cartMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println("]");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
