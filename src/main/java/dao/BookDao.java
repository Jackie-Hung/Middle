package dao;

import beans.Book;
import util.JdbcConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public Book findBookById(int id) throws Exception{
        Connection conn = null;
        Book book = new Book();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bookstore?user=root&password=123456&useUnicode=true&characterEncoding=UTF8&useSSL=false");
            String sql = "SELECT * FROM book WHERE  id ="+id;
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()) {
                book.setId(Integer.parseInt(rs.getString("id")));
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setPrice(Double.parseDouble(rs.getString("price")));
                book.setIamge(rs.getString("image"));
                book.setDescription(rs.getString("description"));
                book.setCategory_id(rs.getString("category_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                conn.close();
                conn = null;
            }
        }
        return book;
    }
}