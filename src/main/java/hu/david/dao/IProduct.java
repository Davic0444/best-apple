package hu.david.dao;

import hu.david.model.Product;

import java.sql.ResultSet;
import java.util.List;

public interface IProduct {

    List<Product> getAllActiveProduct();
    Product getById(Long id);
    Product getObjectFromRs(ResultSet rs);

}
