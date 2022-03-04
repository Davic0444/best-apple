package hu.david.model;

public class Product {

    private Long id;
    private String productIdentifier;
    private String name;
    private Integer price;
    private Boolean status;

    public Product(Long id, String productIdentifier, String name, Integer price, Boolean status) {
        this.id = id;
        this.productIdentifier = productIdentifier;
        this.name = name;
        this.price = price;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Boolean getStatus() {
        return status;
    }

    public String toString() {
        return "Id: "+this.id + ", productId: "+this.productIdentifier
                + ", name: "+this.name + ", price: "+this.price + ", status: "+this.status;
    }
}
