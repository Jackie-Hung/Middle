package dao;

import beans.Orders;
import util.JdbcConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao {
    public List<Orders> findByUserid(String userid) {
        List<Orders> orders = new ArrayList<Orders>();
        Orders order = null;
        Connection con = JdbcConnect.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Orders where user_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, userid);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String ordertime = rs.getString(2);
                float price = rs.getFloat(3);
                String state = rs.getString(4);
                String uid = rs.getString(5);
                order = new Orders(id, ordertime, price, state, uid);
                orders.add(order);
            }
            return orders;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
