package hu.david.dao;

import hu.david.model.Product;
import hu.david.utils.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProduct{
    private Connection con = new Database().createConnection();
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;

    @Override
    public List<Product> getAllActiveProduct() {
        List<Product> products = new ArrayList<Product>();
        String sql = "SELECT * FROM product WHERE status = 1;";
        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                products.add(getObjectFromRs(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public List<String> getAllActiveProductNamesWithPrice() {
        List<String> productNames = new ArrayList<String>();
        List<Product> products = getAllActiveProduct();
        for (Product product : products) {
            productNames.add(product.getName() + "-"+product.getPrice());
        }
        return productNames;
    }


    @Override
    public Product getById(Long id) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE id = ?;";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                product = getObjectFromRs(rs);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return product;
    }

    @Override
    public Product getObjectFromRs(ResultSet rs) {
        Product productObj = null;
        try {
            productObj = new Product(
                    rs.getLong("id"),
                    rs.getString("product_identifier"),
                    rs.getString("name"),
                    rs.getInt("price"),
                    rs.getBoolean("status"));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return productObj;
    }
}
