package hu.david.bestapple;

import hu.david.dao.OrderDao;
import hu.david.dao.ProductDao;
import hu.david.model.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField tfCustomerName;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPhoneNumber;
    @FXML
    private TextField tfPostCode;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfAddress;
    @FXML
    private TextField tfAmount;
    @FXML
    private ComboBox<String> cbproducts;
    @FXML
    private CheckBox chLoweredPrice;
    @FXML
    private Button btnOrderButton;


    @FXML
    void selectProduct(){
        ProductDao productDao = new ProductDao();
        ObservableList<String> list = FXCollections.observableArrayList(productDao.getAllActiveProductNamesWithPrice());
        cbproducts.setItems(list);
    }

    @FXML
    void placeOrder() {
        String name = tfCustomerName.getText();
        String email = tfEmail.getText();
        String phone = tfPhoneNumber.getText();
        String postalCode = tfPostCode.getText();
        String city = tfCity.getText();
        String address = tfAddress.getText();
        Integer amount = Integer.parseInt(tfAmount.getText());
        Integer price = Integer.parseInt(cbproducts.getSelectionModel().getSelectedItem().split("-")[1]);
        String product = cbproducts.getSelectionModel().getSelectedItem().split("-")[0];
        Boolean reduced = chLoweredPrice.isSelected();
        Double totalSum = reduced ? amount * price * 0.8 : amount * price;

        if (name.isEmpty()
                || email.isEmpty()
                || phone.isEmpty()
                || postalCode.isEmpty()
                || city.isEmpty()
                || address.isEmpty()
        ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error1");
            alert.setHeaderText("error2");
            alert.setContentText("error3");
            alert.showAndWait();

        } else {

            Order obj = new Order(
                    name,
                    email,
                    phone,
                    postalCode,
                    city,
                    address,
                    amount,
                    product,
                    reduced,
                    totalSum);
            OrderDao orderDaoObj = new OrderDao();
            orderDaoObj.saveOrder(obj);
            Alert orderAlert = new Alert(Alert.AlertType.INFORMATION);
            orderAlert.setTitle("Sikeres megrendel�s");
            orderAlert.setContentText("K�sz�nj�k a megrendel�st, hamarosan jelentkez�nk!!!");
            orderAlert.showAndWait();

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectProduct();
    }
}