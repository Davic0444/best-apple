package hu.david.model;

public class Order {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String postalCode;
    private String city;
    private String address;
    private Integer amount;
    private String product;
    private Boolean reduced;
    private Double totalSum;

    public Order(String name, String email, String phone, String postalCode, String city, String address,
                 Integer amount, String product, Boolean reduced, Double totalSum) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.postalCode = postalCode;
        this.city = city;
        this.address = address;
        this.amount = amount;
        this.product = product;
        this.reduced = reduced;
        this.totalSum = totalSum;
    }

    public String getPhone() {
        return phone;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getProduct() {
        return product;
    }

    public Boolean getReduced() {
        return reduced;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public String toString() {
        return this.id+ ", "+this.name+ ", "+this.email+
                ", "+this.postalCode+ ", "+this.city+
                ", "+this.address+ ", "+this.amount+ ", "+this.product+ ", "
                + ""+this.reduced+ ", "+this.totalSum;
    }
}
