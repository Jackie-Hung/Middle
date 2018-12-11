package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnect {
    public static Connection getConnection() {
        //String database = "place";
        //String user = "root";
        //String psw = "123456";
        String url="jdbc:mysql://localhost:3306/bookstore?user=root&password=123456&useUnicode=true&characterEncoding=utf-8";
        //String url = "jdbc:mysql://localhost/" + database+"?useUnicode=true&characterEncoding=utf-8";	//String url = "jdbc:sqlserver://172.26.53.255:1433;DatabaseName=" + database;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url);
            System.out.print("success");
            return conn;

        } catch (Exception e) {
            System.out.println("数据库连接错！");
            e.printStackTrace();
            return null;
        }

    }
}
