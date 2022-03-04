package hu.david.bestapple;

import hu.david.dao.ProductDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ComboBox<String> products;

    @FXML
    public void selectProduct(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProductDao productDao = new ProductDao();
        ObservableList<String> list = FXCollections.observableArrayList(productDao.getAllActiveProductNamesWithPrice());
        products.setItems(list);
        products.getSelectionModel().select(0);
    }
}