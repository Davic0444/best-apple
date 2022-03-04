package hu.david.dao;

import hu.david.model.Order;
import hu.david.utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDao implements IOrder{

    private Connection con = new Database().createConnection();
    private PreparedStatement pstmt = null;

    @Override
    public void saveOrder(Order obj) {
        String sql = "INSERT INTO `order` (name, email, phone, postal_code, city, address, amount, product, reduced, total_sum) VALUES (?,?,?,?,?,?,?,?,?,?);";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getEmail());
            pstmt.setString(3, obj.getPhone());
            pstmt.setString(4, obj.getPostalCode());
            pstmt.setString(5, obj.getCity());
            pstmt.setString(6, obj.getAddress());
            pstmt.setInt(7, obj.getAmount());
            pstmt.setString(8, obj.getProduct());
            pstmt.setInt(9, obj.getReduced() ? 1 : 0);
            pstmt.setDouble(10, obj.getTotalSum());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
